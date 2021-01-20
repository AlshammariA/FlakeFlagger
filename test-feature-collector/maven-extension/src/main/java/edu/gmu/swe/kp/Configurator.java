package edu.gmu.swe.kp;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;

public abstract class Configurator {

	protected MavenSession session;
	public Configurator(MavenSession session) throws MojoFailureException {
		this.session = session;
	}
	public abstract void applyConfiguration(MavenProject project, Plugin plugin, PluginExecution pluginExecution) throws MojoFailureException;

	public String getListenerClass(boolean isTestNG) {
		return null;
	}

	protected Plugin getOrAddPlugin(MavenProject project, String groupId, String artifactID, String version){
		Plugin ret = project.getPlugin(groupId+":"+artifactID);
		if(ret == null){
			ret = new Plugin();
			ret.setGroupId(groupId);
			ret.setArtifactId(artifactID);
			ret.setVersion(version);
			project.getBuild().addPlugin(ret);
			project.getBuild().getPluginsAsMap().put(groupId+":"+artifactID,ret);
		}
		return ret;
	}
}
