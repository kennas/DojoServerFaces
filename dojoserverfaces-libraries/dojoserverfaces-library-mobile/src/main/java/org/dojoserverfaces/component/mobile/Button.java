/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.mobile;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.build.annotation.ActionSource;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.property.EnumPropertyBase;

/**
 * A stylable button that can display a label, an icon, or both. The label can
 * be hidden via showLabel=false.
 * 
 */
@ActionSource(dojoType = "dojox.mobile.Button", requiredCss = { "dojox/mobile/themes/{theme}/Button.css" })
class Button extends ButtonBase {
    static class TypeProperty extends EnumPropertyBase {
        private static String[] validValues = { "submit", "reset", "button" };

        protected TypeProperty(String name, String propertyName) {
            super(name, propertyName, validValues);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            Object value = getAttributeValue(component);
            if (null == value) {
                // if no type set then assume submit it action set
                if (null != component.getAttributes().get("action")) {
                    return Helper.quote("submit");
                }
            }
            return super.getAsPropertyValue(component);
        }

    }

    /**
     * Button type; submit, reset and button.
     */
    @Property(handler = TypeProperty.class)
    String type;
    /**
     * duration of selection, milliseconds or -1 for no post-click CSS styling
     */
    @Property
    Integer duration;

}
