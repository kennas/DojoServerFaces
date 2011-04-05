/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.gadget;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.widget.property.EnumPropertyBase;

/**
 * A ColorPalette component.
 * 
 */
@Gadget(dojoType = "dijit.ColorPalette")
class ColorPalette {

    static class PaletteProperty extends EnumPropertyBase {
        private static String[] validValues = { "7x10", "3x4" };

        protected PaletteProperty(String name, String propertyName) {
            super(name, propertyName, validValues);
        }
    }

    /**
     * The event handler script to execute when the field value changes. This
     * may be immediate of when the field loses focus.
     */
    @Event(isDefault = true)
    String onChange;

    /**
     * A string defining the size of the palette. Can only take one of two
     * values, 7x10 or 3x4. The default value is 7x10.
     */
    @Property(handler = PaletteProperty.class)
    String palette;
}