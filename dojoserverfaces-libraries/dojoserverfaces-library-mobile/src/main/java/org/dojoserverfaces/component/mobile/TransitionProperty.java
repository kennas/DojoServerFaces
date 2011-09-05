/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.mobile;

import org.dojoserverfaces.widget.property.EnumPropertyBase;

/**
 * Property handler for properties that are transition type name.
 */
public class TransitionProperty extends EnumPropertyBase {
    private static String[] validValues = { "slide", "fade", "flip", "cover",
            "coverv", "dissolve", "flip2", "reveal", "revealv", "scaleIn",
            "scaleOut", "slidev", "swirl", "zoomIn", "zoomOut" };

    protected TransitionProperty(String name, String propertyName) {
        super(name, propertyName, validValues);
    }
}