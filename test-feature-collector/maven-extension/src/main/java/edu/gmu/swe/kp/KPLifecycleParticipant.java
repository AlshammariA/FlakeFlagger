package edu.gmu.swe.kp;

import edu.gmu.swe.kp.configurator.JacocoConfigurator;
import edu.gmu.swe.kp.configurator.PitConfigurator;
import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.MavenExecutionException;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.aether.repository.RemoteRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

@Component(role = AbstractMavenLifecycleParticipant.class, hint = "kp-ext")
public class KPLifecycleParticipant extends AbstractMavenLifecycleParticipant {
	public static final String KP_VERSION = "1.0-SNAPSHOT";

	private static final String ARGLINE_FLAGS = System.getenv("KP_ARGLINE");
	private static final String ADDL_TEST_DEPS = System.getenv("KP_DEPENDENCIES");
	private static final boolean FAIL_FAST = System.getenv("KP_FAIL_ON_FAILED_TEST") != null;

	private static final boolean RECORD_TESTS = System.getenv("KP_RECORD_TESTS") != null;

	private static final boolean DO_JACOCO = true; //System.getenv("KP_JACOCO") != null;
	private static final boolean DO_PIT = System.getenv("KP_PIT") != null;

	private static final boolean FORK_PER_TEST = true; //System.getenv("KP_FORK_PER_TEST") != null && !DO_PIT;
	static HashSet<String> disabledPlugins = new HashSet<String>();

	static {
		disabledPlugins.add("maven-enforcer-plugin");
		disabledPlugins.add("license-maven-plugin");
		disabledPlugins.add("maven-duplicate-finder-plugin");
		disabledPlugins.add("apache-rat-plugin");
		disabledPlugins.add("cobertura-maven-plugin");
		disabledPlugins.add("jacoco-maven-plugin");
		disabledPlugins.add("maven-dependency-versions-check-plugin");
		disabledPlugins.add("duplicate-finder-maven-plugin");
	}

	LinkedList<Configurator> configurators = new LinkedList<>();
	private MavenSession session;

	private void removeAnnoyingPlugins(MavenProject proj) {
		LinkedList<Plugin> newPlugs = new LinkedList<>();
		for (Plugin p : proj.getBuildPlugins()) {
			if (disabledPlugins.contains(p.getArtifactId())) {
				System.out.println("Warning: KebabPizza disabling incompatible " + p.getGroupId() + ":" + p.getArtifactId() + " from " + proj.getArtifactId());
			}
			else{
				newPlugs.add(p);
			}
			if (System.getProperty("diffcov.mysql") != null) {
				//fix for checkstyle in evaluation
				if (p.getArtifactId().equals("maven-antrun-plugin") && proj.getName().contains("checkstyle")) {
					PluginExecution del = null;
					for (PluginExecution pe : p.getExecutions()) {
						if (pe.getId().equals("ant-phase-verify"))
							del = pe;
					}
					if (del != null)
						p.getExecutions().remove(del);
				}
			}
		}
		proj.getBuild().setPlugins(newPlugs);

		//Also, fix terrible junit deps
		for (Dependency d : proj.getDependencies()) {
			if ("junit".equals(d.getGroupId()) && "junit".equals(d.getArtifactId())) {
				if ("4.2".equals(d.getVersion()) || "4.5".equals(d.getVersion()) || "4.4".equals(d.getVersion()) || "4.3".equals(d.getVersion()) || d.getVersion().startsWith("3"))
					d.setVersion("4.6");
			}
		}

		//Also fix dead pluginrepos

		LinkedList<RemoteRepository> reposToRemove = new LinkedList<>();
		for (RemoteRepository r : proj.getRemotePluginRepositories()) {
			if (r.getUrl().startsWith("http://build.eclipse.org"))
				reposToRemove.add(r);
		}
		if (reposToRemove.size() > 0)
			proj.getRemotePluginRepositories().removeAll(reposToRemove);
	}

	public void rewriteSurefireConfiguration(MavenProject project, Plugin p) throws MojoFailureException {
		boolean testNG = false;
		for (Dependency d : project.getDependencies()) {
			if (d.getGroupId().equals("org.testng"))
				testNG = true;
		}
		String version = p.getVersion();
		if (version != null) {
			try {
				version = version.substring(2);
				if (!"19.1".equals(version) && !version.startsWith("20")) {
					int vers = Integer.valueOf(version);
					if (vers <= 17)
						p.setVersion("2.19.1");
				}
			} catch (NumberFormatException ex) {
				p.setVersion("2.19.1");
			}
		}
		Dependency d = new Dependency();
		d.setArtifactId("kp-test-listener");
		d.setGroupId("edu.gmu.swe.smells");
		d.setVersion("1.0-SNAPSHOT");
		d.setScope("test");
		project.getDependencies().add(d);
		if (ADDL_TEST_DEPS != null) {
			for (String dep : ADDL_TEST_DEPS.split(",")) {
				String[] dat = dep.split(":");
				d = new Dependency();
				d.setGroupId(dat[0]);
				d.setArtifactId(dat[1]);
				d.setVersion(dat[2]);
				d.setScope("test");
				project.getDependencies().add(d);
			}
		}

		p.getDependencies().clear();
		for (PluginExecution pe : p.getExecutions()) {

			Xpp3Dom config = (Xpp3Dom) pe.getConfiguration();
			if (config == null)
				config = new Xpp3Dom("configuration");
			rewriteSurefireExecutionConfig(config, testNG);
			p.setConfiguration(config);
			pe.setConfiguration(config);
			for (Configurator c : configurators)
				c.applyConfiguration(project, p, pe);
		}

	}

	void rewriteSurefireExecutionConfig(Xpp3Dom config, boolean testNG) throws MojoFailureException {

		Xpp3Dom disableXmlReport = config.getChild("disableXmlReport");
		if(disableXmlReport != null)
		{
			disableXmlReport.setValue("false");
		}
		Xpp3Dom argLine = config.getChild("argLine");
		if (argLine == null) {
			argLine = new Xpp3Dom("argLine");
			argLine.setValue("");
			config.addChild(argLine);
		}
		argLine.setValue(argLine.getValue().replace("${surefireArgLine}", ""));
		if (argLine != null && argLine.getValue().equals("${argLine}"))
			argLine.setValue("'-XX:OnOutOfMemoryError=kill -9 %p' ");
		else if (argLine != null) {
			argLine.setValue("'-XX:OnOutOfMemoryError=kill -9 %p' " + argLine.getValue().replace("@{argLine}", "").replace("${argLine}", "").replace("${test.opts.coverage}", ""));
		}

		//Now fix if we wanted jacoco or cobertura
		if (ARGLINE_FLAGS != null)
			argLine.setValue(ARGLINE_FLAGS + " " + argLine.getValue());
		Xpp3Dom parallel = config.getChild("parallel");
		if (parallel != null)
			parallel.setValue("none");

		fixForkMode(config, FORK_PER_TEST);


		Xpp3Dom properties = config.getChild("properties");
		if (properties == null) {
			properties = new Xpp3Dom("properties");
			config.addChild(properties);
		}
		if (RECORD_TESTS) {
			Xpp3Dom prop = new Xpp3Dom("property");
			properties.addChild(prop);
			Xpp3Dom propName = new Xpp3Dom("name");
			propName.setValue("listener");
			Xpp3Dom propValue = new Xpp3Dom("value");
			if (testNG)
				propValue.setValue("edu.gmu.swe.kp.listener.TestNGExecutionListener");
			else
				propValue.setValue("edu.gmu.swe.kp.listener.TestExecutionListener");


			prop.addChild(propName);
			prop.addChild(propValue);
		}
		for (Configurator c : configurators) {
			String listener = c.getListenerClass(testNG);
			if (listener != null) {
				Xpp3Dom prop = new Xpp3Dom("property");
				properties.addChild(prop);
				Xpp3Dom propName = new Xpp3Dom("name");
				propName.setValue("listener");
				Xpp3Dom propValue = new Xpp3Dom("value");
				propValue.setValue(listener);
				prop.addChild(propName);
				prop.addChild(propValue);
			}
		}


		Xpp3Dom testFailureIgnore = config.getChild("testFailureIgnore");
		if (testFailureIgnore != null) {
			testFailureIgnore.setValue((FAIL_FAST ? "false" : "true"));
		} else {
			testFailureIgnore = new Xpp3Dom("testFailureIgnore");
			testFailureIgnore.setValue((FAIL_FAST ? "false" : "true"));
			config.addChild(testFailureIgnore);
		}

		Xpp3Dom vars = config.getChild("systemPropertyVariables");
		if (vars == null) {
			vars = new Xpp3Dom("systemPropertyVariables");
			config.addChild(vars);
		}
	}

	void fixForkMode(Xpp3Dom config, boolean forkPerTest) {
		Xpp3Dom forkMode = config.getChild("forkMode");
		boolean isSetToFork = false;
		if (forkPerTest) {
			if (forkMode != null)
				forkMode.setValue("perTest");
			else {
				Xpp3Dom forkCount = config.getChild("forkCount");
				if (forkCount != null)
					forkCount.setValue("1");
				else {
					forkCount = new Xpp3Dom("forkCount");
					forkCount.setValue("1");
					config.addChild(forkCount);
				}
				Xpp3Dom reuseForks = config.getChild("reuseForks");
				if (reuseForks != null)
					reuseForks.setValue("false");
				else {
					reuseForks = new Xpp3Dom("reuseForks");
					reuseForks.setValue("false");
					config.addChild(reuseForks);
				}
			}
			return;
		} else {
			//Want to NOT fork per-test
			if (forkMode != null) {
				forkMode.setValue("once");
				isSetToFork = true;
			}

			Xpp3Dom forkCount = config.getChild("forkCount");
			if (forkCount != null && !forkCount.getValue().equals("1")) {
				isSetToFork = true;
				forkCount.setValue("1");
			}

			Xpp3Dom reuseForks = config.getChild("reuseForks");
			if (reuseForks != null && reuseForks.getValue().equals("false")) {
				reuseForks.setValue("true");
			}

			if (!isSetToFork) {
				forkCount = new Xpp3Dom("forkCount");
				forkCount.setValue("1");
				config.addChild(forkCount);
			}
		}
	}

	@Override
	public void afterProjectsRead(MavenSession session) throws MavenExecutionException {

		this.session = session;
		try {
			if (DO_JACOCO)
				configurators.add(new JacocoConfigurator(session));
			if (DO_PIT)
				configurators.add(new PitConfigurator(session));
		} catch (MojoFailureException ex) {
			throw new MavenExecutionException("Unable to create KP configurator", ex);
		}

		//Find out which is the last run of tests
		Plugin lastRunOfSurefireOrFailsafe = null;
		for (MavenProject p : session.getProjects()) {
			for (Plugin o : p.getBuildPlugins()) {
				if ((o.getArtifactId().equals("maven-surefire-plugin") || o.getArtifactId().equals("maven-failsafe-plugin"))
						&& o.getGroupId().equals("org.apache.maven.plugins")) {
					lastRunOfSurefireOrFailsafe = o;
				}
			}

		}
		for (MavenProject p : session.getProjects()) {
			removeAnnoyingPlugins(p);
			addDependencyPlugin(p);
			try {
				LinkedList<Plugin> toModify = new LinkedList<>(p.getBuildPlugins());
				for (Plugin o : toModify) {
					if ((o.getArtifactId().equals("maven-surefire-plugin") && o.getGroupId().equals("org.apache.maven.plugins")) || (o.getArtifactId().equals("maven-failsafe-plugin") && o.getGroupId().equals("org.apache.maven.plugins")))
						rewriteSurefireConfiguration(p, o);
				}
			} catch (MojoFailureException e) {
				e.printStackTrace();
			}
		}

	}

	private void addDependencyPlugin(MavenProject p) {
		Plugin depPlugin = null;
		for(Plugin o : p.getBuildPlugins()){
			if(o.getArtifactId().equals("maven-dependency-plugin") && o.getGroupId().equals("org.apache.maven.plugins")){
				depPlugin = o;
			}
		}
		if(depPlugin == null){
			depPlugin = new Plugin();
			depPlugin.setArtifactId("maven-dependency-plugin");
			depPlugin.setGroupId("org.apache.maven.plugins");
			depPlugin.setVersion("3.1.2");
			p.getBuild().addPlugin(depPlugin);
		}
		PluginExecution ex = new PluginExecution();
		Xpp3Dom config = new Xpp3Dom("configuration");
		Xpp3Dom outputProperty = new Xpp3Dom("outputProperty");
		outputProperty.setValue("flakyTestClasspath");
		config.addChild(outputProperty);
		ex.setConfiguration(config);
		ex.setId("kp-cp-build");
		ex.setPhase("generate-sources");
		ex.setGoals(Collections.singletonList("build-classpath"));
		depPlugin.addExecution(ex);

	}

}
