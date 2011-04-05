/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.DojoWidget;

/**
 * Handler for a property that is an id of a component for which we want to
 * retrieve a reference to the dijit object.
 */
public class DijitProperty extends Property {

    public DijitProperty(String attributeName, String propertyName) {
        super(attributeName, propertyName);
    }

    public DijitProperty(String name) {
        super(name);
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        Object value = getAttributeValue(component);

        if (value != null) {
            UIComponent targetComponent = component.findComponent(value
                    .toString());
            if (targetComponent == null
                    || (!(targetComponent instanceof DojoWidget))) {
                log(component, "Invalid id");
                return null;
            }
            StringBuilder dijitBuilder = new StringBuilder("dijit.byId(")
                    .append(Helper.quote(targetComponent.getClientId()))
                    .append(")");
            return dijitBuilder.toString();
        }
        else
            return null;
    }
}
