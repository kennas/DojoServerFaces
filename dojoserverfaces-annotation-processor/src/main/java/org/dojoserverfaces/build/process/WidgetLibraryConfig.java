/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process;

/**
 * The WidgetLibraryConfig class defines a bean used to store the configuration
 * data for a DojoServerFaces widget library.
 */

public class WidgetLibraryConfig {
     private String componentPackage;
     private String namespace;
     private String path;
     
     /**
      * Retrieves the component package associated with this widget library
      * configuration.
      * 
      * @return a String containing the component package associated with this
      *         widget library configuration.
      */
     
     public String getComponentPackage () {
          return this.componentPackage;
     }
     
     /**
      * Retrieves the namespace associated with this widget library
      * configuration.
      * 
      * @return a String containing the namespace associated with this widget
      *         library configuration.
      */
     
     public String getNamespace () {
          return this.namespace;
     }
     
     /**
      * Retrieves the path associated with this widget library configuration.
      * 
      * @return a String containing the path associated with this widget
      *         library configuration.
      */
     
     public String getPath () {
          return this.path;
     }
}
