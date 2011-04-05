/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.library.test.data.model;

public class KeyValuePair {
     private String key;
     private String value;
     
     public KeyValuePair (String key, String value) {
          this.key = key;
          this.value = value;
     }
     
     public String getKey () {
          return this.key;
     }
     
     public String getValue () {
          return this.value;
     }
}
