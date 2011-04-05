/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.generator.lib;

import java.util.LinkedList;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;

import org.dojoserverfaces.build.process.generator.SourceGenerator;
import org.dojoserverfaces.build.process.generator.SourceLocation;
import org.dojoserverfaces.build.process.info.BehaviorInfo;
import org.dojoserverfaces.build.process.info.FaceletTagInfo;
import org.dojoserverfaces.build.process.info.FacesArtifact;

/**
 * The FacesConfigResourceGenerator class defines a source generator used to
 * generate a Dojo JSF faces-config.xml file.
 */

abstract class LibraryResourceGenerator extends SourceGenerator {
    private LinkedList<FacesArtifact> artifacts;
    private LinkedList<FacesArtifact> behaviors;
    private LinkedList<FacesArtifact> faceletTags;
    private LinkedList<FacesArtifact> components;

    /**
     * Creates a FacesConfigResourceGenerator object.
     * 
     * @param processingEnv
     *            a ProcessingEnvironment object containing the processing
     *            environment to use.
     * @param roundEnv
     *            a RoundEnvironment object containing the round environment to
     *            use.
     * @param outputLocation
     *            a String containing the location where the generated source
     *            should be saved.
     * @throws Throwable
     *             if an error occurs while creating this source generator.
     */

    public LibraryResourceGenerator(ProcessingEnvironment processingEnv,
            RoundEnvironment roundEnv, String outputLocation) throws Throwable {

        super(processingEnv, roundEnv, outputLocation);

        this.artifacts = new LinkedList<FacesArtifact>();
        this.behaviors = new LinkedList<FacesArtifact>();
        this.faceletTags = new LinkedList<FacesArtifact>();
        this.components = new LinkedList<FacesArtifact>();

        setShouldGenerate(true);

        // Add standard context properties.

        addContextProperty("artifacts", this.artifacts);
        addContextProperty("behaviors", this.behaviors);
        addContextProperty("faceletTags", this.faceletTags);
        addContextProperty("componentInfos", this.components);
    }

    public void addArtifact(FacesArtifact artifact) {
        switch (artifact.getArtifactType()) {
        case BEHAVIOR: {
            this.behaviors.add((BehaviorInfo) artifact);
            break;
        }
        case FACELET_TAG: {
            this.faceletTags.add((FaceletTagInfo) artifact);
            break;
        }
        case COMPONENT: {
            this.components.add(artifact);
            break;
        }
        }
        this.artifacts.add(artifact);
    }

    /*
     * @see org.dojoserverfaces.internal.annotation.generator.SourceGenerator#
     * getSourceLocation()
     */

    @Override
    protected SourceLocation getSourceLocation() {
        return SourceLocation.RESOURCES;
    }
}
