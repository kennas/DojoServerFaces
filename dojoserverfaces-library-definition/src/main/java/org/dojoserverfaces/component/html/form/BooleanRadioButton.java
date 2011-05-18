/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import java.util.Map;

import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.constants.HtmlElementType;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.property.ValueProperty;

/**
 * An input component for setting boolean values using a radio button. Multiple
 * components can be identified as to belong to a group which will allow for
 * only one component in the group to be set (true).
 */
@EditableValueHolder(dojoType = "dijit.form.RadioButton", elementType = HtmlElementType.INPUT_RADIO)
class BooleanRadioButton extends InputBase {

    static final String GROUP_ATTRIBUTE_NAME = "groupId";

    /**
     * Property class to handle writing the special value for the name property
     * that makes use of groupId attribute
     * 
     */
    public static class NameProperty extends
            org.dojoserverfaces.widget.property.Property {
        public NameProperty(String attributeName, String ignoredName) {
            super(attributeName, "name");
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            return Helper.makeStringVar(makeClientId(component,
                    (String) getAttributeValue(component)));
        }
    }

    /**
     * An id value used to group mutually exclusive instances of this component
     */
    @Property(handler = NameProperty.class, name = "name")
    String groupId;

    /**
     * Property class used tor writing the "value" property that must be handled
     * in a special way for this component.
     * 
     */
    public static class SpecialValueProperty extends
            org.dojoserverfaces.widget.property.Property {
        public SpecialValueProperty(String doNotCareName, String ignoredName) {
            super("value");
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            // the value must be the client id of the component
            // so we will know which of the mutually exclusive
            // radio components got selected
            return Helper.makeStringVar(component.getClientId());
        }
    }

    @Property(exposed = false, handler = SpecialValueProperty.class)
    Object overriddenValue;

    /**
     * Value property class that maps the components value to the "checked"
     * attribute of the dojo(input) widget
     * 
     */
    public static class CheckedValue extends ValueProperty {
        public CheckedValue() {
            super("checked");
        }

        /**
         * @param name
         * @param propertyName
         */
        public CheckedValue(String name, String propertyName) {
            // generated code assumes a two argument constructor
            // is available. Ignoring the arguments as this is
            // special value prop.
            this();
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            javax.faces.component.EditableValueHolder editableValue = (javax.faces.component.EditableValueHolder) component;
            Object attrValue = editableValue.getSubmittedValue();

            if (null == attrValue) {
                if (editableValue.isLocalValueSet()) {
                    attrValue = Helper.getConvertedValue(component,
                            editableValue.getLocalValue());
                }
                else {
                    attrValue = Helper.getConvertedValue(component,
                            editableValue.getValue());
                }
            }
            if ("true".equals(attrValue)) {
                return "true";
            }
            else {
                // this "checked" attribute should only be written if the
                // components value is true
                return null;
            }
        }

        @Override
        public void retrievePostBackValue(FacesContext context,
                UIComponent component) {
            Map<String, String> requestParams = context.getExternalContext()
                    .getRequestParameterMap();
            Object submittedValue = requestParams.get(makeClientId(component,
                    (String) Helper.getAttributeValue(component,
                            GROUP_ATTRIBUTE_NAME)));
            if (null != submittedValue) {
                ((javax.faces.component.EditableValueHolder) component)
                        .setSubmittedValue(component.getClientId().equals(
                                submittedValue) ? "true" : "false");
            }
        }
    }

    /**
     * The value for this component which will be treated like a boolean.
     */
    @Property(handler = CheckedValue.class)
    Object value;

    static String makeClientId(UIComponent component, String group) {
        StringBuilder name = new StringBuilder();
        while (null != component) {
            component = component.getParent();
            if (component instanceof NamingContainer) {
                name.append(component.getClientId());
            }
        }
        name.append(UINamingContainer.getSeparatorChar(FacesContext
                .getCurrentInstance()));
        // if no group id is given the parent id is unique enough if
        // this is the only GROUP_ATTRIBUTE_NAME
        if (null == group) {
            name.append("checked");
        }
        else {
            name.append(group);
        }
        return name.toString();
    }

}
