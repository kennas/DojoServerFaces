/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.generator.doc;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;

import org.dojoserverfaces.build.process.generator.CompositeSourceGenerator;
import org.dojoserverfaces.build.process.info.FacesArtifact;

/**
 * The DocCompositeSourceGenerator defines a composite source generator used to
 * create DojoServerFaces documentation.
 * 
 * @author $Author$
 * @version $Id$
 */

public class DocCompositeSourceGenerator extends CompositeSourceGenerator {

    private IndexResourceGenerator tocResourceGenerator;

    /**
     * Creates a DocCompositeSourceGenerator object.
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

    public DocCompositeSourceGenerator(ProcessingEnvironment processingEnv,
            RoundEnvironment roundEnv, String outputLocation) throws Throwable {
        super(processingEnv, roundEnv, outputLocation);

        this.tocResourceGenerator = new IndexResourceGenerator(processingEnv,
                roundEnv, "html/toc.html");
        addSourceGenerator(this.tocResourceGenerator);

        addSourceGenerator(new StyleSheetResourceGenerator(processingEnv, roundEnv,
                "css/doc.css"));
    }

    public void addArtifact(FacesArtifact artifact) {
        try {
            DocResourceGenerator generator = new DocResourceGenerator(
                    getProcessingEnvironment(), getRoundEnvironment(),
                    artifact, "html/" + artifact.getTagName() + ".html");
            addSourceGenerator(generator);
            // Also need to add the artifact to the TOC resource generator.
            this.tocResourceGenerator.addArtifact(artifact);
        }
        catch (Throwable e) {
            // TODO: report error?
        }
    }

}
