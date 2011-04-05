/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;

/**
 * Property handler for a property that consists of sub properties
 */
public class ComplexProperty extends Property implements PropertyCollection{
    private List<Property> properties = null;

    public ComplexProperty(String name) {
        super(name, name);
        properties = new ArrayList<Property>();
    }

    public ComplexProperty(String name, String propertyName) {
        super(name, propertyName);
        properties = new ArrayList<Property>();
    }

    public ComplexProperty(String name, List<Property> properties) {
        super(name, name);
        this.properties = properties;
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        StringBuilder widgetDeclaration = new StringBuilder("{");

        String jsonPropertySetting;
        boolean addComma = false;
        for (Property property : properties) {
            if (null != (jsonPropertySetting = property
                    .getAsJsonPropertySetting(component))) {
                if (addComma) {
                    widgetDeclaration.append(',');
                }
                widgetDeclaration.append(jsonPropertySetting);
                addComma = true;
            }
        }
        if (!addComma) {
            // no sub properties
            return null;
        }
        widgetDeclaration.append('}');
        return widgetDeclaration.toString();
    }

    /**
     * Add a sub property to this complex property
     * 
     * @param property
     */
    public void add(Property property) {
        properties.add(property);
    }

    /* (non-Javadoc)
     * @see org.dojoserverfaces.widget.property.PropertyCollection#iterator(javax.faces.component.UIComponent)
     */
    @Override
    public Iterator<Property> iterator(UIComponent component) {
        return properties.iterator();
    }
}
