package edu.gmu.swe.kp.configurator;

import edu.gmu.swe.kp.Configurator;
import edu.gmu.swe.kp.KPLifecycleParticipant;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PitConfigurator extends Configurator {
//	private static final String PIT_OUTPUT_DIR = System.getenv("PIT_OUTPUT_DIR");
	LinkedList<String> classFileDirs = new LinkedList<String>();
	LinkedList<String> testClassFileDirs = new LinkedList<>();

	public PitConfigurator(MavenSession session) throws MojoFailureException {
		super(session);
//		File f = new File(PIT_OUTPUT_DIR);
//		if (f.getParentFile() != null)
//			f.getParentFile().mkdirs();

		for (MavenProject p : session.getProjects()) {
			testClassFileDirs.add(p.getBuild().getTestOutputDirectory());
			classFileDirs.add(p.getBuild().getOutputDirectory());
		}

	}

	private String joinString(Iterable<String> in) {
		StringBuilder ret = new StringBuilder();
		for (String s : in) {
			ret.append(s);
			ret.append(',');
		}
		ret.deleteCharAt(ret.length() - 1);
		return ret.toString();
	}

	@Override
	public void applyConfiguration(MavenProject project, Plugin plugin, PluginExecution pluginExecution) throws MojoFailureException {
		Xpp3Dom config = (Xpp3Dom) pluginExecution.getConfiguration();


		project.getProperties().setProperty("buildDirs", joinString(classFileDirs));
		project.getProperties().setProperty("testBuildDirs", joinString(testClassFileDirs));

		//Add KP plugin that will run after tests are compiled to build the targetClasses and targetTests lists

		plugin.getDependencies().clear();
		Dependency d = new Dependency();
//		if(testNG)
//			d.setArtifactId("deflaker-surefire-reexec-testng");
//		else
		{
//			if(shouldUseJUnit47)
//				d.setArtifactId("deflaker-surefire-reexec-junit47");
//			else
				d.setArtifactId("kp-surefire-provider-junit4");
		}
		d.setGroupId("edu.gmu.swe.kp");
		d.setVersion("2.19.1-SNAPSHOT");
		plugin.addDependency(d);


		File testsToRunFile = new File(project.getBuild().getDirectory(),"kpTestsToRun");
		Xpp3Dom ttrf = new Xpp3Dom("property");
		Xpp3Dom pname = new Xpp3Dom("name");
		pname.setValue("testsToRunFile");
		Xpp3Dom pval = new Xpp3Dom("value");
		pval.setValue(testsToRunFile.getAbsolutePath());
		ttrf.addChild(pname);
		ttrf.addChild(pval);

		config.getChild("properties").addChild(ttrf);

		Xpp3Dom failIfNoTests = config.getChild("failIfNoTests");
		if(failIfNoTests == null)
		{
			failIfNoTests = new Xpp3Dom("failIfNoTests");
			config.addChild(failIfNoTests);
		}
		failIfNoTests.setValue("false");

		Plugin kpPlug = getOrAddPlugin(project,"edu.gmu.swe.kp","kp-reporter-plugin",KPLifecycleParticipant.KP_VERSION);
		PluginExecution repExec = new PluginExecution();
		if(plugin.getArtifactId().contains("failsafe"))
		{
			repExec.setId("kp-prepare-pit-" + pluginExecution.getId());
			repExec.setPhase("verify");
		}
		else
		{
			repExec.setId("kp-prepare-pit-"+pluginExecution.getId());
			repExec.setPhase("test");

		}
		Xpp3Dom configuration = new Xpp3Dom("configuration");
		Xpp3Dom opt = new Xpp3Dom("testsToRunFile");
		opt.setValue(testsToRunFile.getAbsolutePath());
		configuration.addChild(opt);
		repExec.setConfiguration(configuration);
		repExec.setGoals(Collections.singletonList("preparePIT"));
		kpPlug.addExecution(repExec);

		//Add PIT as a plugin
		String version = "1.4.4-SNAPSHOT";
		if(System.getenv("PIT_VERSION") != null)
			version = System.getenv("PIT_VERSION");
		Plugin newPlug = getOrAddPlugin(project, "org.pitest","pitest-maven",version);
		configuration = new Xpp3Dom("configuration");

//		Xpp3Dom fullMutationMatrix = new Xpp3Dom("fullMutationMatrix");
//		fullMutationMatrix.setValue("true");
//		configuration.addChild(fullMutationMatrix);

		Xpp3Dom failWhenNoMutations = new Xpp3Dom("failWhenNoMutations");
		failWhenNoMutations.setValue("false");
		configuration.addChild(failWhenNoMutations);

		Xpp3Dom outputCov = new Xpp3Dom("exportLineCoverage");
		outputCov.setValue("true");
		configuration.addChild(outputCov);

		Xpp3Dom outputFormats = new Xpp3Dom("outputFormats");
		Xpp3Dom of = new Xpp3Dom("outputFormat");
		of.setValue("XML");
		outputFormats.addChild(of);
		configuration.addChild(outputFormats);

		Xpp3Dom timestampedReports = new Xpp3Dom("timestampedReports");
		timestampedReports.setValue("false");
		configuration.addChild(timestampedReports);

		//Check for argLine
		Xpp3Dom surefireConfig = (Xpp3Dom) plugin.getConfiguration();
		Xpp3Dom argLine = surefireConfig.getChild("argLine");
		String theArgs = argLine.getValue().replace("'-XX:OnOutOfMemoryError=kill -9 %p'","");
		if(argLine != null){
			Xpp3Dom pitArgLine = new Xpp3Dom("jvmArgs");
			Pattern regex = Pattern.compile("[^\\s\"']+|\"[^\"]*\"|'[^']*'");
			Matcher regexMatcher = regex.matcher(theArgs);
			while (regexMatcher.find()) {
				Xpp3Dom arg = new Xpp3Dom("jvmArg");
				arg.setValue(regexMatcher.group());
				pitArgLine.addChild(arg);
			}

			configuration.addChild(pitArgLine);
		}

		repExec = new PluginExecution();
		if (plugin.getArtifactId().contains("failsafe")) {
			repExec.setId("pit-integration-tests");
			repExec.setPhase("verify");
		} else {
			repExec.setId("pit-tests");
			repExec.setPhase("test");

		}
		repExec.setConfiguration(configuration);
		repExec.setGoals(Collections.singletonList("mutationCoverage"));
		newPlug.addExecution(repExec);

	}
}
