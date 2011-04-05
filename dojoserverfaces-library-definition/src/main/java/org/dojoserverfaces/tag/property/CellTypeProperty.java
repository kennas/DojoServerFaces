/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tag.property;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.widget.property.DojoClass;
import org.dojoserverfaces.widget.property.Property;

public class CellTypeProperty extends Property implements DojoClass {

    private static final String DOJO_PACKAGE = "dojox.grid.cells.";

    public CellTypeProperty(String name, String propertyName) {
        super(name, propertyName);
    }

    public CellTypeProperty(String attributeName) {
        this(attributeName, "type");
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        Object value = getAttributeValue(component);
        if (null != value) {
            return DOJO_PACKAGE + value.toString();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dojoserverfaces.widget.property.DojoClass#getDojoType()
     */
    @Override
    public String getDojoType() {
        return DOJO_PACKAGE + "dijit";
    }

}
