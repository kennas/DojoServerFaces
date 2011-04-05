/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.component.UIComponent;

public class ClientIdProperty extends StringProperty {
    public ClientIdProperty(String name) {
        super(name);
    }

    public ClientIdProperty(String name, String propertyName) {
        super(name, propertyName);
    }

    @Override
    public Object getAttributeValue(UIComponent component) {
        return component.getClientId();
    }
}
