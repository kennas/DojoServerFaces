/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;

/**
 * This behavior will allow you to set the css "visibility" value of an element
 */
@Behavior
public class SetVisible extends SetStyleBase {

    public SetVisible() {
        super("visibility");
    }
    
    /**
     * a boolean value: <code>true</code> -> visibility: visible;
     * <code>false</code> -> visibility: 'hidden';
     */
    @Attribute(required = true)
    public Boolean getValue() {
        // this will rarely be called if ever
        return Boolean.valueOf(super.getValueString());
    }

    public void setValue(Boolean value) {
        super.setValue(value ? "visible" : "hidden");
    }
}