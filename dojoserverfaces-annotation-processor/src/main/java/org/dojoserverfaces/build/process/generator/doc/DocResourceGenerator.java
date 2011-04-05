/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.generator.doc;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;

import org.dojoserverfaces.build.process.AnnotationProcessor;
import org.dojoserverfaces.build.process.generator.SourceGenerator;
import org.dojoserverfaces.build.process.generator.SourceLocation;
import org.dojoserverfaces.build.process.info.FacesArtifact;

/**
 * The DocResourceGenerator class defines a resource generator used to generate
 * DojoServerFaces documentation.
 * 
 * @author $Author$
 * @version $Id$
 */

public class DocResourceGenerator extends SourceGenerator {
    /**
     * Creates a DocResourceGenerator object.
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

    public DocResourceGenerator(ProcessingEnvironment processingEnv,
            RoundEnvironment roundEnv, FacesArtifact artifact,
            String outputLocation) throws Throwable {
        super(processingEnv, roundEnv, outputLocation);
        addContextProperty("artifact", artifact);
        // Add standard context properties.
        addContextProperty(
                "namespace",
                System.getProperty(AnnotationProcessor.PROPERTY_NAMESPACE));
        setShouldGenerate(true);
    }

    /*
     * @see
     * org.dojoserverfaces.build.process.generator.SourceGenerator#getSourceLocation()
     */

    @Override
    protected SourceLocation getSourceLocation() {
        return SourceLocation.DOCS;
    }

    /*
     * @see
     * org.dojoserverfaces.build.process.generator.SourceGenerator#getTemplatePath()
     */

    @Override
    protected String getTemplatePath() {
        return "META-INF/template/doc/doc.template";
    }
}
