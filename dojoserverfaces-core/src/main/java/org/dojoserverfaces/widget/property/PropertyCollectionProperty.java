/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.widget.property.Property;
import org.dojoserverfaces.widget.property.PropertyCollection;

/**
 * Property whose value is a collection (List, Map, Property[]) of Property definitions
 *
 */
public class PropertyCollectionProperty extends Property implements PropertyCollection{

    /**
     * the attribute name to use for finding matching selection
     */

    public PropertyCollectionProperty(String attributeName, String propertyName) {
        super(attributeName, propertyName);
    }

    public PropertyCollectionProperty(String name) {
        super(name);
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {

        boolean addComma = false;
        StringBuilder json = new StringBuilder();
        Object value = component.getAttributes().get(this.getName());
        json.append("[");
        if (value instanceof List<?>) {
            @SuppressWarnings("unchecked")
            List<Property> propertyArray = (List<Property>) value;
            for (org.dojoserverfaces.widget.property.Property property : propertyArray) {
                if (addComma) {
                    json.append(',');
                }
                json.append(property.getAsPropertyValue(component));
                addComma = true;
            }
        }
        else if (value instanceof Map<?, ?>) {
            @SuppressWarnings("unchecked")
            Map<Object, Property> properties = (Map<Object, Property>) value;
            for (Map.Entry<Object, Property> propEntry : properties.entrySet()) {
                if (addComma) {
                    json.append(',');
                }
                json.append(propEntry.getValue().getAsPropertyValue(component));
                addComma = true;
            }
        }
        else if (value instanceof Property[]) {
            for (org.dojoserverfaces.widget.property.Property property : (Property[]) value) {
                if (addComma) {
                    json.append(',');
                }
                json.append(property.getAsPropertyValue(component));
                addComma = true;
            }
        }
        json.append("]");
        return json.toString();
    }

    /* (non-Javadoc)
     * @see org.dojoserverfaces.widget.property.PropertyCollection#iterator(javax.faces.component.UIComponent)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Iterator<Property> iterator(UIComponent component) {
        Object value = component.getAttributes().get(this.getName());
        if (value instanceof List<?>) {
            return ((List<Property>) value).iterator();
        }
        else if (value instanceof Map<?, ?>) {
            Map<Object, Property> properties = (Map<Object, Property>) value;
            return new MapIterator(properties);
        }
        else if (value instanceof Property[]) {
            return new ArrayIterator((Property[]) value);
        }
        return new EmptyIterator();
    }
}
