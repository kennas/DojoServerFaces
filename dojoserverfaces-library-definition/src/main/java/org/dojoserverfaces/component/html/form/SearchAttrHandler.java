/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.component.html.store.SelectItemStore;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.property.StringProperty;

public class SearchAttrHandler extends StringProperty {
    protected SearchAttrHandler(String name, String propertyName) {
        super(name, propertyName);

    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        Object value = getAttributeValue(component);

        if (null != value) {
            return Helper.makeStringVar(value.toString());
        }
        return Helper
                .makeStringVar(SelectItemStore.DataStoreProperty.SEARCH_ATTR_NAME);
    }
}
