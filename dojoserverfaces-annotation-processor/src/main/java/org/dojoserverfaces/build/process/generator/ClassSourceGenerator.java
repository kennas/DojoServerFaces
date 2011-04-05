/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.generator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

/**
 * The ClassSourceGenerator class defines an extension of the SourceGenerator
 * class from which source generators that generate Java source code should
 * extend.
 */

public abstract class ClassSourceGenerator extends SourceGenerator {
     private HashSet<String> interfaces;
     private Set<Modifier> modifiers;
     private String unqualifiedClassName;
     
     /**
      * Creates a ClassSourceGenerator object.
      * 
      * @param processingEnv a ProcessingEnvironment object containing the
      *        processing environment to use.
      * @param roundEnv a RoundEnvironment object containing the round
      *        environment to use.
      * @param element a TypeElement object containing the Java model element
      *        representing the class used by this class source generator.
      * @param outputLocation a String containing the location where the
      *        generated source should be saved.
      * @throws Throwable if an error occurs while creating this source
      *         generator.
      */
     
     public ClassSourceGenerator (ProcessingEnvironment processingEnv,
          RoundEnvironment roundEnv, TypeElement element,
          String outputLocation) throws Throwable {
          super (processingEnv, roundEnv, outputLocation);
          
          String className;
          List<? extends TypeMirror> interfaces;
          
          // Interestingly, the Filer class expects the output location to be a
          // qualified class name, so that's why we're reusing it for the class
          // name.
          
          className = outputLocation;
          
          setQualifiedClassName (className);
          
          // Set up the superclass and interface names.
          
          this.interfaces = new HashSet<String>();
          
          setSuperclass (element.getSuperclass().toString());
          
          interfaces = element.getInterfaces();
          
          for (TypeMirror curInterface : interfaces) {
               addInterfaceName (curInterface.toString());
          }
          
          addContextProperty ("interfaces", this.interfaces);
          
          this.modifiers = element.getModifiers();
          
          addContextProperty ("modifiers", this.modifiers);
     }
     
     /*
      * @see org.dojoserverfaces.internal.annotation.generator.SourceGenerator#getSourceLocation()
      */
     
     @Override
     protected SourceLocation getSourceLocation () {
          return SourceLocation.CLASSES;
     }
     
     /**
      * Retrieves the unqualified class name associated with this class source
      * generator.
      * 
      * @return a String containing the unqualified class name associated with
      *         this class source generator.
      */
     
     protected String getUnqualifiedClassName () {
          return this.unqualifiedClassName;
     }
     
     /**
      * Sets the qualified class name associated with this class source
      * generator.
      * 
      * @param className a String containing the qualified class name to
      *        associate with this class source generator.
      */
     
     protected void setQualifiedClassName (String className) {
          String packageName;
          
          this.unqualifiedClassName = className.substring
               (className.lastIndexOf ('.') + 1);
          
          packageName = className.substring (0, className.lastIndexOf ('.'));
          
          addContextProperty ("packageName", packageName);
          addContextProperty ("qualifiedClassName", className);
          addContextProperty ("unqualifiedClassName",
               this.unqualifiedClassName);
          
          // Also need to update the output location to reflect the possibly
          // new package name.
          
          setOutputLocation (packageName + "." + this.unqualifiedClassName);
     }
     
     /**
      * Sets the superclass associated with this class source generator.
      * 
      * @param className a String containing the name of the superclass to
      *        associate with this class source generator.
      */
     
     protected void setSuperclass (String className) {
          if (!className.equals ("java.lang.Object")) {
               addContextProperty ("superclass", className);
          }
     }
     
     /**
      * Adds an interface name to this class source generator.
      * 
      * @param interfaceName a String containing the name of the interface to
      *        add to thsi class source generator.
      */
     
     protected void addInterfaceName (String interfaceName) {
          this.interfaces.add (interfaceName);
     }
}
