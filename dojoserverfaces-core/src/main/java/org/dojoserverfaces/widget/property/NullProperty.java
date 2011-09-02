/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.component.UIComponent;

/**
 * 
 * This handler let the property generates no js code in the client.
 * 
 */
public class NullProperty extends Property {

    protected NullProperty(String name) {
        super(name);
    }

    public NullProperty(String name, String propertyName) {
        super(name, propertyName);
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        return null;
    }

}
