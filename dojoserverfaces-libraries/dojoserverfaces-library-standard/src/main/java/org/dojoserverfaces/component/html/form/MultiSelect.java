/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import org.dojoserverfaces.build.annotation.MultiSelectValueHolder;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.widget.property.CollectionValue;

/**
 * The MultiSelect component allows the selection of multiple items. You provide
 * a list of acceptable value pairs consisting of text to be displayed and value
 * to be submitted.
 * 
 */
@MultiSelectValueHolder(dojoType = "dijit.form.MultiSelect", displayName = "Multi-select Listbox", store = false)
class MultiSelect extends InputBase {
    /**
     * The value, a collection, for this component.
     */
    @Property(handler = CollectionValue.class)
    Object value;
}
