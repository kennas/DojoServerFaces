/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.build.process.info;

import java.util.Collection;

/**
 * The FacesArtifact class defines a class used to encapsulate
 * information related to the Faces artifacts.
 */

public interface FacesArtifact {

    public enum Type {
        COMPONENT,
        BEHAVIOR,
        CONVERTER,
        VALIDATOR, 
        FACELET_TAG
    }
    
    public Type getArtifactType();
    
    public String getUniqueId();
    
    /**
     * Retrieves the class name associated with this artifact.
     * 
     * @return a String containing the class name associated with this artifact.
     */
    public String getClassName();

    public String getDescription();

    public String getXmlDescription();

    public String getDisplayName();
    
    public String getTagName();
    
    public Collection<AttributeInfo> getAttributes();
}
