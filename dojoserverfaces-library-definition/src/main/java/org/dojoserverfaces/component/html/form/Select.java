/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import java.util.Collection;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.build.annotation.SelectValueHolder;
import org.dojoserverfaces.widget.DojoWidget;
import org.dojoserverfaces.widget.property.DojoRefProperty;
import org.dojoserverfaces.widget.property.StringArrayProperty;

/**
 * The Select component allows the selection of an item from a list of items.
 * You provide a list of acceptable value pairs consisting of text to be
 * displayed and value to be submitted through SelectItemStore component
 * 
 */
@SelectValueHolder(dojoType = "dijit.form.Select", displayName = "Select Listbox")
class Select extends InputBase {

    public static class DataStoreRefProperty extends DojoRefProperty implements
            Validator {

        public DataStoreRefProperty(String name) {
            super(name);
        }

        public DataStoreRefProperty(String attributeName, String propertyName) {
            super(attributeName, propertyName);
        }

        /*
         * @see
         * javax.faces.validator.Validator#validate(javax.faces.context.FacesContext
         * , javax.faces.component.UIComponent, java.lang.Object)
         */
        @Override
        public void validate(FacesContext context, UIComponent comp,
                Object value) throws ValidatorException {
            String storeId = (String) comp.getAttributes().get(this.getName());
            if (storeId == null || value == null)
                return;

            UIComponent storeComp = context.getViewRoot()
                    .findComponent(storeId);
            if (storeComp != null && (storeComp instanceof DojoWidget)) {
                Validator validator = getDataStroeValidator((DojoWidget) storeComp);
                if (validator != null) {
                    validator.validate(context, (UIComponent) storeComp, value);
                }
            }
        }

        private Validator getDataStroeValidator(DojoWidget selectItemStore) {
            Collection<org.dojoserverfaces.widget.property.Property> propertyHandlers = selectItemStore
                    .getPropertyHandlers();
            for (org.dojoserverfaces.widget.property.Property property : propertyHandlers) {
                if ("data".equals(property.getName())
                        && property instanceof Validator) {
                    return (Validator) property;
                }
            }
            return null;
        }
    }

    /**
     * Indicates a value is required to be submitted for this component.
     */
    @Property(handler = RequiredProperty.class)
    Boolean required;

    /**
     * Currently error/prompt message. When using the default tooltip
     * implementation, this will only be displayed when the field is focused.
     */
    @Property
    String message;
    // TODO does this conflict with common tooltip attribute?

    /**
     * This attribute controls the position of the tooltip. It can be a list of
     * the following values:
     * 
     * before: places tooltip to the left of the component, or to the right in
     * the case of RTL scripts like Hebrew and Arabic
     * 
     * after: places tooltip to the right of the target node/widget, or to the
     * left in the case of RTL scripts like Hebrew and Arabic
     * 
     * above: tooltip goes above target node
     * 
     * below: tooltip goes below target node
     * 
     * The list, (String[] or a String where the values are space separated, of
     * positions is tried, in order, until a position is found where the tooltip
     * fits within the viewport. Be careful setting this attribute. A value of
     * "above" may work fine until the user scrolls the screen so that there's
     * no room above the target node. Nodes with drop downs, like DropDownButton
     * or FilteringSelect, are especially problematic, in that you need to be
     * sure that the drop down and tooltip don't overlap, even when the viewport
     * is scrolled so that there is only room below (or above) the target node,
     * but not both.
     */
    @Property(handler = StringArrayProperty.class)
    Object tooltipPosition;
    /**
     * Id of a data store component containing potential values for the
     * field.e.g.SelectItemStore
     */
    @Property(handler = DataStoreRefProperty.class)
    Object store;
}
