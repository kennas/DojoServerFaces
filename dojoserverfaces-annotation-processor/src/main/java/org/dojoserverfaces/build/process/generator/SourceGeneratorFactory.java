/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.generator;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/**
 * The SourceGeneratorFactory class defines methods used to create source
 * generators.
 */

public interface SourceGeneratorFactory {
     /**
      * Creates a source generator.
      * 
      * @param processingEnv a ProcessingEnvironment object containing the
      *        processing environment to use.
      * @param roundEnv a RoundEnvironment object containing the round
      *        environment to use.
      * @param element a Java model element containing the class used to for
      *        the source generator, which may be null.
      * @param outputLocation a String containing the location where the
      *        generated source should be saved.
      * @return a SourceGenerator object containing the desired source
      *         generator.
      * @throws Throwable if an error occurs while creating the source
      *         generator.
      */
     
     public SourceGenerator createSourceGenerator
          (ProcessingEnvironment processingEnv, RoundEnvironment roundEnv,
          TypeElement element, String outputLocation) throws Throwable;
     
     /**
      * Retrieves the status as to whether or not this source generator
      * factory can create a source generator capable of handling the given
      * Java model element (which corresponds to a class).
      * 
      * @param element a TypeElement object containing the Java model element
      *        that this source generator factory will check.
      * @return a boolean containing true if this source generator factory can
      *         create a source generator capable of handling the given Java
      *         model element, false otherwise.
      */
     
     public boolean canHandle (TypeElement element);
}
