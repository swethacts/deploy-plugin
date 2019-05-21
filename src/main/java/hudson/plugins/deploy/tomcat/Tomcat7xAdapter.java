package hudson.plugins.deploy.tomcat;

import hudson.EnvVars;
import hudson.Extension;
import hudson.plugins.deploy.ContainerAdapterDescriptor;
import hudson.util.VariableResolver;

import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.cargo.container.configuration.Configuration;
import org.codehaus.cargo.container.property.RemotePropertySet;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Tomcat 7.x
 *
 * @author soudmaijer
 */
public class Tomcat7xAdapter extends TomcatAdapter {

    private static String path = "/manager/text";

    /**
     * Tomcat 7 support
     *
     * @param url Tomcat server location (for example: http://localhost:8080)
     * @param credentialsId the tomcat user credentials
     */
    @DataBoundConstructor
    public Tomcat7xAdapter(String url, String credentialsId) {
        super(url, credentialsId, path);
    }

    /**
     * Tomcat Cargo containerId
     * @return tomcat7x
     */
    public String getContainerId() {
        return "tomcat7x";
    }

    @Symbol("tomcat7")
    @Extension
    public static final class DescriptorImpl extends ContainerAdapterDescriptor {
        public String getDisplayName() {
            return "Tomcat 7.x";
        }
    }
}
