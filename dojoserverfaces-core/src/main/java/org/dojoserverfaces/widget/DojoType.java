/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget;


/**
 * Base class to represent a dojo object type definition to be used by a
 * component definition.
 * 
 */
public abstract class DojoType {
    /**
     * @return the type string identifying the dojo object type to create
     */
    public abstract String geTypeName();
    
    /**
     * @return flag indicating if this dojo type is a Dijit.
     */
    public abstract boolean isDijit();
}
