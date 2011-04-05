/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.mojo.widget;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import org.dojoserverfaces.build.process.AnnotationProcessor;
import org.dojoserverfaces.build.process.WidgetLibraryConfig;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.bsc.maven.plugin.processor.MainAnnotationProcessorMojo;

/**
 * The WidgetMojo class defines a Maven Mojo that generates code for a set of
 * DojoServerFaces widgets.
 * 
 * @goal generate
 * @phase generate-sources
 * @requiresDependencyResolution compile
 */

public class WidgetMojo extends AbstractMojo {
    /**
     * @parameter expression="${project.compileClasspathElements}"
     * @readonly
     */

    private List<Object> classpathElements;

    /**
     * @parameter expression="${project.build.directory}/docs"
     */

    private File docsDirectory;

    /**
     * @parameter expression="${project.build.outputDirectory}"
     * @readonly
     */

    private File outputClassDirectory;

    /**
     * @parameter 
     *            expression="${project.build.directory}/generated-sources/dojoserverfaces"
     * @readonly
     */

    private File outputDirectory;

    /**
     * @parameter expression="${plugin.artifacts}"
     * @readonly
     */

    private List<Artifact> pluginArtifacts;

    /**
     * @parameter expression="${project.build.plugins}"
     * @readonly
     */

    private List<Plugin> plugins;

    /**
     * @parameter expression="${project}"
     * @readonly
     */

    private MavenProject project;

    /**
     * @parameter
     * @required
     */

    private WidgetLibraryConfig[] widgetLibs;

    private List<Object> widgetPluginClasspathElements;

    /**
     * Creates a WidgetMojo object.
     */

    public WidgetMojo() {
    }

    /**
     * Retrieves an initialized annotation processor Mojo.
     * 
     * @param config
     *            a WidgetLibraryConfig object containing the widget library
     *            configuration to use.
     * @return a MainAnnotationProcessorMojo object containing the initialized
     *         annotation processor mojo.
     * @throws MojoExecutionException
     *             if an error occurs while initializing the annotation
     *             processor Mojo.
     */

    private MainAnnotationProcessorMojo getInitializedAnnotationProcessor(
            WidgetLibraryConfig config) throws MojoExecutionException {
        MainAnnotationProcessorMojo mojo = new MainAnnotationProcessorMojo();

        setProperty(mojo, "classpathElements", this.classpathElements);
        setProperty(mojo, "compilerArguments", "-Adir.classes="
                + this.outputClassDirectory.toString() + " -Adir.docs="
                + this.docsDirectory.toString());
        setProperty(mojo, "failOnError", false);
        setProperty(mojo, "outputClassDirectory", this.outputClassDirectory);
        setProperty(mojo, "outputDiagnostics", false);
        setProperty(mojo, "outputDirectory", this.outputDirectory);
        setProperty(mojo, "pluginArtifacts", this.pluginArtifacts);
        setProperty(mojo, "processors",
                new String[] { AnnotationProcessor.class.getName() });
        setProperty(mojo, "project", this.project);
        setProperty(mojo, "sourceDirectory", new File(config.getPath()));

        System.setProperty(AnnotationProcessor.PROPERTY_NAMESPACE,
                config.getNamespace());
        if (null != config.getComponentPackage()) {
            System.setProperty(
                    AnnotationProcessor.PROPERTY_PACKAGE_COMPONENT,
                    config.getComponentPackage());
        }
        return mojo;
    }

    /**
     * Sets a reflective property.
     * 
     * @param obj
     *            an Object containing the object on which the property is to be
     *            set.
     * @param name
     *            a String containing the name of the property to set.
     * @param value
     *            an Object containing the value of the property to set.
     * @throws MojoExecutionException
     *             if an error occurs while setting the property.
     */

    private void setProperty(Object obj, String name, Object value)
            throws MojoExecutionException {
        Class<?> cls = obj.getClass();

        try {
            Field field = null;

            try {
                field = cls.getDeclaredField(name);
            }

            catch (NoSuchFieldException e) {
                // Could be in the parent...

                field = cls.getSuperclass().getDeclaredField(name);
            }

            field.setAccessible(true);

            field.set(obj, value);
        }

        catch (Throwable e) {
            throw new MojoExecutionException("unable to set reflective "
                    + "property \"" + name + "\" on object " + obj, e);
        }
    }

    /*
     * @see org.apache.maven.plugin.AbstractMojo#execute()
     */

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        initializeWidgetPluginClasspathElements();

        this.classpathElements.addAll(this.widgetPluginClasspathElements);

        for (WidgetLibraryConfig widgetLib : this.widgetLibs) {
            MainAnnotationProcessorMojo mojo = getInitializedAnnotationProcessor(widgetLib);

            mojo.execute();
        }
    }

    /**
     * Initializes the classpath elements for this widget Mojo.
     * 
     * @throws MojoExecutionException
     *             if an error occurs while initializing the classpath elements
     *             for this widget Mojo.
     */

    @SuppressWarnings("unchecked")
    private void initializeWidgetPluginClasspathElements()
            throws MojoExecutionException {
        String qualifiedPluginName = null;

        // Iterate over all the referenced plugins and figure out the exact
        // version of the widget plugin.

        for (Plugin plugin : this.plugins) {
            String artifactId = plugin.getArtifactId();
            String groupId = plugin.getGroupId();

            if (groupId.equals("org.dojoserverfaces")) {
                if (artifactId.equals("dojoserverfaces-maven-plugin")) {
                    qualifiedPluginName = groupId + ":" + artifactId + ":"
                            + plugin.getVersion();

                    break;
                }
            }
        }

        // No real way this variable can't be set, but just to be safe...

        if (qualifiedPluginName != null) {
            MavenProject pluginProject = (MavenProject) this.project
                    .getProjectReferences().get(qualifiedPluginName);

            try {
                this.widgetPluginClasspathElements = (List<Object>) pluginProject
                        .getCompileClasspathElements();
            }

            catch (Throwable e) {
                throw new MojoExecutionException(
                        "unable to get " + "classpath", e);
            }
        }
    }
}
