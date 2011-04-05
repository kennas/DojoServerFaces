/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.dojoserverfaces.component.dojo.DojoScriptBlockComponent;
import org.dojoserverfaces.widget.DojoWidget;

/**
 * Property that is reference to a component that represents a dojo object. For
 * example a DataStore.
 */
public class DojoRefProperty extends Property {

    public DojoRefProperty(String attributeName, String propertyName) {
        super(attributeName, propertyName);
    }

    public DojoRefProperty(String name) {
        super(name);
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        Object value = getAttributeValue(component);

        if (value != null) {
            // referenced objects would have been created at the "top" of the
            // view so start searching at the root.
            UIComponent targetComponent = FacesContext.getCurrentInstance()
                    .getViewRoot().findComponent(value.toString());
            if (targetComponent == null
                    || (!(targetComponent instanceof DojoWidget))) {
                log(component, "Invalid id");
                return null;
            }
            // vars are created for dojo objects using the id of the component
            return DojoScriptBlockComponent
                    .getGlobalReference((DojoWidget) targetComponent);
        }
        else
            return null;

    }

}
