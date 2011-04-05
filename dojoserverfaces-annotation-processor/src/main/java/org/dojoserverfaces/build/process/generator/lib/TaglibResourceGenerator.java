/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.generator.lib;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;

import org.dojoserverfaces.build.process.AnnotationProcessor;

/**
 * The TaglibResourceGenerator class defines a source generator used to generate
 * a Facelets taglib.xml file.
 */

public class TaglibResourceGenerator extends LibraryResourceGenerator {

    /**
     * Creates a TaglibResourceGenerator object.
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

    public TaglibResourceGenerator(ProcessingEnvironment processingEnv,
            RoundEnvironment roundEnv, String outputLocation) throws Throwable {
        super(processingEnv, roundEnv, outputLocation);
        addContextProperty(
                "namespace",
                System.getProperty(AnnotationProcessor.PROPERTY_NAMESPACE));
    }

    /*
     * @see
     * org.dojoserverfaces.internal.annotation.generator.SourceGenerator#getTemplatePath
     * ()
     */

    @Override
    protected String getTemplatePath() {
        return "META-INF/template/lib/taglib.template";
    }
}
