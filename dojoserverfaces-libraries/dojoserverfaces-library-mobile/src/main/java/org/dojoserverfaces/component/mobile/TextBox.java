/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.mobile;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Property;

/**
 * A simple text input area. A non-templated base class for textbox form inputs
 * 
 */
@EditableValueHolder(dojoType = "dojox.mobile.TextBox", requiredCss = { "dojox/mobile/themes/{theme}/TextBox.css" })
class TextBox extends TextBoxBase {
    public static class ForceCaseProperty extends
            org.dojoserverfaces.widget.property.Property {
        public ForceCaseProperty() {
            super("forceCase");
        }

        public ForceCaseProperty(String name) {
            super(name);
        }

        public ForceCaseProperty(String name, String propertyName) {
            super(name, propertyName);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            return null;
        }

        @Override
        public String getAsJsonPropertySetting(UIComponent component) {
            Object forceCase = getAttributeValue(component);
            if (null != forceCase) {
                String propertyName = forceCase + "case";
                return buildJsonPropertySetting(propertyName, "true");
            }
            return null;
        }
    }

    /**
     * The text case (upper, lower, proper) to which the entered text will be
     * forced.
     */
    @Property(handler = ForceCaseProperty.class)
    String forceCase;

    public static class SecretHandler extends
            org.dojoserverfaces.widget.property.Property {
        public SecretHandler() {
            super("Secret");
        }

        public SecretHandler(String name) {
            super(name);
        }

        public SecretHandler(String name, String propertyName) {
            super(name, propertyName);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            Object value = getAttributeValue(component);
            if (null != value) {
                if (value.toString().equals("true"))
                    return "\"password\"";
            }
            return null;
        }

    }

    /**
     * if true it will mask the content you input in the textbox
     * 
     */
    @Property(name = "type", handler = SecretHandler.class)
    Boolean secret;

}
