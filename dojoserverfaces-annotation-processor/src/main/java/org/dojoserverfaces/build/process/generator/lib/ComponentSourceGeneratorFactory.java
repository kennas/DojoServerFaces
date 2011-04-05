/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.generator.lib;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

import org.dojoserverfaces.build.process.generator.SourceGenerator;
import org.dojoserverfaces.build.process.generator.SourceGeneratorFactory;

/**
 * The FormComponentSourceGeneratorFactory class defines an implementation of
 * the SourceGenerator interface used to create form component source
 * generators.
 */

public class ComponentSourceGeneratorFactory implements
     SourceGeneratorFactory {
     /**
      * Creates a FormComponentSourceGeneratorFactory object.
      */
     
     public ComponentSourceGeneratorFactory () {
     }
     
     /*
      * @see org.dojoserverfaces.internal.annotation.generator.SourceGeneratorFactory#canHandle(javax.lang.model.element.TypeElement)
      */
     
     @Override
     public boolean canHandle (TypeElement element) {
          return true;
     }
     
     /*
      * @see org.dojoserverfaces.internal.annotation.generator.SourceGeneratorFactory#createSourceGenerator(javax.annotation.processing.ProcessingEnvironment, javax.annotation.processing.RoundEnvironment, javax.lang.model.element.TypeElement, java.lang.String)
      */
     
     @Override
     public SourceGenerator createSourceGenerator (
          ProcessingEnvironment processingEnv, RoundEnvironment roundEnv,
          TypeElement element, String outputLocation) throws Throwable {
          return new ComponentSourceGenerator (processingEnv, roundEnv,
               element, outputLocation);
     }

}
