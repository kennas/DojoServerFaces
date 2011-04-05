/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.generator;

import java.util.LinkedList;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;

/**
 * The CompositeSourceGenerator class defines a class used to execute multiple
 * source generators.
 * 
 * @author $Author$
 * @version $Id$
 */

public abstract class CompositeSourceGenerator extends SourceGenerator {
     private ProcessingEnvironment processingEnv;
     private RoundEnvironment roundEnv;
     private LinkedList<SourceGenerator> sourceGenerators;
     
     /**
      * Creates a CompositeSourceGenerator object.
      * 
      * @param processingEnv a ProcessingEnvironment object containing the
      *        processing environment to use.
      * @param roundEnv a RoundEnvironment object containing the round
      *        environment to use.
      * @param outputLocation a String containing the location where the
      *        generated source should be saved.
      * @throws Throwable if an error occurs while creating this source
      *         generator.
      */
     
     public CompositeSourceGenerator (ProcessingEnvironment processingEnv,
          RoundEnvironment roundEnv, String outputLocation) throws Throwable {
          super (processingEnv, roundEnv, outputLocation);
          
          this.processingEnv = processingEnv;
          this.roundEnv = roundEnv;
          this.sourceGenerators = new LinkedList<SourceGenerator>();
          
          setShouldGenerate (true);
     }
     
     /**
      * Retrieves the processing environment associated with this source
      * generator.
      * 
      * @return a ProcessingEnvironment object containing the processing
      *         environment associated with this source generator.
      */
     
     protected ProcessingEnvironment getProcessingEnvironment () {
          return this.processingEnv;
     }
     
     /**
      * Retrieves the round environment associated with this source generator.
      * 
      * @return a RoundEnvironment object containing the processing environment
      *         associated with this source generator.
      */
     
     protected RoundEnvironment getRoundEnvironment () {
          return this.roundEnv;
     }
     
     /*
      * @see org.dojoserverfaces.build.process.generator.SourceGenerator#getSourceLocation()
      */
     
     @Override
     protected SourceLocation getSourceLocation () {
          return SourceLocation.NONE;
     }
     
     /*
      * @see org.dojoserverfaces.build.process.generator.SourceGenerator#getTemplatePath()
      */
     
     @Override
     protected String getTemplatePath () {
          return null;
     }
     
     /**
      * Adds a source generator to this composite source generator.
      * 
      * @param sourceGenerator a SourceGenerator object containing the source
      *        generator to add to this composite source generator.
      */
     
     protected void addSourceGenerator (SourceGenerator sourceGenerator) {
          this.sourceGenerators.add (sourceGenerator);
     }
     
     /*
      * @see org.dojoserverfaces.build.process.generator.SourceGenerator#applyTemplate()
      */
     
     @Override
     protected String applyTemplate () throws Throwable {
          SourceGeneratorManager manager;
          
          // Create a new source generator manager and have it process all the
          // child source generators.
          
          manager = new SourceGeneratorManager (this.processingEnv);
          
          for (SourceGenerator sourceGenerator : this.sourceGenerators) {
               manager.addSourceGenerator (sourceGenerator);
          }
          
          manager.applyAllSourceGenerators();
          
          return null;
     }
}
