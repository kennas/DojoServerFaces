/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.widget.property.DojoRefProperty;

/**
 * 
 * An input text field with the capability of selecting a predefined value.
 * 
 */
@EditableValueHolder(dojoType = "dijit.form.ComboBox", displayName = "ComboBox")
class ComboBox extends TextBoxBase {

    /**
     * Id of a data store component containing potential values for the field.
     */
    @Property(handler = DojoRefProperty.class)
    Object store;

    /**
     * The attribute (field) in the data set to use for finding potential values.
     */
    @Property(handler = SearchAttrHandler.class)
    String searchAttr;

    /**
     * If user types in a partial string, and then tab out of the field,
     * automatically copy the first entry displayed in the drop down list to the
     * field
     */
    @Property
    Boolean autoComplete;

    /**
     * One of: "first", "all" or "none". If the searched string can be found, it
     * will be highlighted.
     */
    @Property
    String highlightMatch;

    /**
     * Set to false case should be not be ignored when matching possible items
     */
    @Property
    Boolean ignoreCase;

    /**
     * Set the textbox to have a down arrow button, to display the drop down
     * list. Defaults to true.
     */
    @Property
    Boolean hasDownArrow;

    /**
     * Delay in milliseconds between when user types something and we start
     * searching based on that value
     */
    @Property
    Integer searchDelay;
}