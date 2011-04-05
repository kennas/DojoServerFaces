/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedHashMap;

import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

import org.dojoserverfaces.build.process.generator.lib.ComponentSourceGeneratorFactory;

/**
 * The SourceGeneratorManager class defines a class from which specific source
 * generators can be accessed.
 */

public class SourceGeneratorManager {
     private static final SourceGeneratorFactory factories[] = {
          new ComponentSourceGeneratorFactory()
     };
     
     private ProcessingEnvironment env;
     private LinkedHashMap<String, SourceGenerator> sourceGenerators;
     
     /**
      * Creates a SourceGeneratorManager object.
      * 
      * @param env a ProcessingEnvironment object containing the processing
      *        environment to use.
      */
     
     public SourceGeneratorManager (ProcessingEnvironment env) {
          this.env = env;
          this.sourceGenerators = new LinkedHashMap<String, SourceGenerator>();
     }
     
     /**
      * Retrieves an existing source generator.
      * 
      * @param className a String containing the class name of the source
      *        generator to retrieve. 
      * @return a SourceGenerator object containing the desired source
      *         generator or null if no source generator with the given class
      *         name can be found.
      */
     
     public SourceGenerator getExistingSourceGenerator (String className) {
          return this.sourceGenerators.get (className);
     }
     
     /**
      * Retrieves a source generator for a given Java model element.
      * 
      * @param element a Java model element containing the class which will be
      *        handled by the desired source generator.
      * @param roundEnv a RoundEnvironment object containing the round
      *        environment to use.
      * @return a SourceGenerator object containing the desired source
      *         generator.
      * @throws Throwable if an error occurs while creating the source
      *         generator.
      */
     
     public synchronized SourceGenerator getSourceGenerator
          (TypeElement element, RoundEnvironment roundEnv) throws Throwable {
          String className = element.getQualifiedName().toString();
          SourceGenerator generator = this.sourceGenerators.get (className);

          if (generator != null) {
               return generator;
          }

          // Iterate over all the source generator factories and attempt to
          // find one that can handle the given type element.

          for (SourceGeneratorFactory factory :
               SourceGeneratorManager.factories) {
               if (factory.canHandle (element)) {
                    generator = factory.createSourceGenerator (this.env,
                         roundEnv, element, className);

                    this.sourceGenerators.put (className, generator);

                    return generator;
               }
          }
          // Couldn't find a source generator factory, so throw an exception.

          // TODO: better message.

          throw new Throwable ("Couldn't find source generator factory");
     }
     
     /**
      * Manually adds a source generator to this source generator manager.
      * 
      * @param generator a SourceGenerator object containing the source
      *        generator to add.
      */
     
     public synchronized void addSourceGenerator (SourceGenerator generator) {
          this.sourceGenerators.put (generator.getOutputLocation(), generator);
     }
     
     /**
      * Applies all the source generators associated with this source generator
      * manager.
      * 
      * @throws Throwable if an error occurs while applying the source
      *         generators.
      */
     
     public void applyAllSourceGenerators () throws Throwable {
          Filer filer = this.env.getFiler();
          Collection<SourceGenerator> generators =
               this.sourceGenerators.values();
          
          // Iterate over all the source generators and have them generate
          // their sources and save them to their respective locations.
          
          for (SourceGenerator generator : generators) {
               if (generator.shouldGenerate()) {
                    switch (generator.getSourceLocation()) {
                         case DOCS: {
                              File file = new File (this.env.getOptions().get
                                   ("dir.docs"),
                                   generator.getOutputLocation());
                              FileWriter writer;
                              
                              // We have to use a property specified in the POM
                              // in order to get access to the classes
                              // directory and write a resource without having
                              // to give it Java naming conventions.

                              if (!file.getParentFile().exists()) {
                                   file.getParentFile().mkdirs();
                              }

                              writer = new FileWriter (file);

                              writer.append (generator.applyTemplate());

                              writer.flush();
                              writer.close();
                              
                              break;
                         }
                         
                         case CLASSES: {
                              JavaFileObject file = filer.createSourceFile
                                   (generator.getOutputLocation(),
                                   (Element) null);
                              Writer writer = file.openWriter();

                              writer.append (generator.applyTemplate());

                              writer.flush ();
                              writer.close ();

                              break;
                         }
                         
                         case NONE: {
                              // Generally the case for composite source
                              // generators.  Nothing gets written out for this
                              // particular source generator, but applying the
                              // template will allow it to write its child
                              // source generators.
                              
                              generator.applyTemplate();
                              
                              break;
                         }
                         
                         case RESOURCES: {
                              File file = new File (this.env.getOptions().get
                                   ("dir.classes"),
                                   generator.getOutputLocation());
                              FileWriter writer;

                              // We have to use a property specified in the POM
                              // in order to get access to the classes
                              // directory and write a resource without having
                              // to give it Java naming conventions.

                              if (!file.getParentFile().exists()) {
                                   file.getParentFile().mkdirs();
                              }

                              writer = new FileWriter (file);

                              writer.append (generator.applyTemplate());

                              writer.flush();
                              writer.close();

                              break;
                         }
                    }
               }
          }
     }
}
