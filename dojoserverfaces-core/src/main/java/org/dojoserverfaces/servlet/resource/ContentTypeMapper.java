/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.servlet.resource;

import java.util.HashMap;

/**
 * The ContentTypeMapper class defines methods for mapping file extensions to
 * content-types.
 */

public class ContentTypeMapper {
     private static final HashMap<String, String> contentTypes =
          new HashMap<String, String>();
     
     static {
          // Set up content-type mappings.
          ContentTypeMapper.contentTypes.put (".css", "text/css");
          ContentTypeMapper.contentTypes.put (".js", "text/javascript");
          ContentTypeMapper.contentTypes.put (".png", "image/png");
     }
 
     /**
      * Retrieves the content-type for a path.
      * 
      * @param path a String containing the path to use.
      * @return a String containing the content-type for the given path.
      */
     
     public static String getContentType (String path) {
          int index = path.lastIndexOf ('.');
          if (index > 0) {
	          String extension = path.substring (index).toLowerCase();
	          String contentType = ContentTypeMapper.contentTypes.get(extension);
	          if (null != contentType) {
	               return contentType;
	          }
          }
	      return "text/plain";
     }
}
