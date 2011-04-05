/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.generator.lib;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;

/**
 * The FacesConfigResourceGenerator class defines a source generator used to
 * generate a faces-config.xml file.
 */

public class FacesConfigResourceGenerator extends LibraryResourceGenerator {

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

    public FacesConfigResourceGenerator(ProcessingEnvironment processingEnv,
            RoundEnvironment roundEnv, String outputLocation) throws Throwable {

        super(processingEnv, roundEnv, outputLocation);
    }

    /*
     * @see
     * org.dojoserverfaces.internal.annotation.generator.SourceGenerator#getTemplatePath
     * ()
     */

    @Override
    protected String getTemplatePath() {
        return "META-INF/template/lib/faces-config.template";
    }
}
