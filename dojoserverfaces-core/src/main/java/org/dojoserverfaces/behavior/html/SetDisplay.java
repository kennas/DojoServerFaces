/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;

/**
 * This behavior will allow you to set the css "display" value of an element
 */
@Behavior
public class SetDisplay extends SetStyleBase {

    public SetDisplay() {
        super("display");
    }

    /**
     * a boolean value: <code>true</code> -> display: ""; <code>false</code> ->
     * display: "none";
     */
    @Attribute(required = true)
    public Boolean getValue() {
        // this will rarely be called if ever
        return Boolean.valueOf(super.getValueString());
    }

    public void setValue(Boolean value) {
        super.setValue(value ? "" : "none");
    }
}