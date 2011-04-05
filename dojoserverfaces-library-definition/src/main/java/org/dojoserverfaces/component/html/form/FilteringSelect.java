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
 * A select field component where the possible options will be narrowed by the
 * user typing in the field.it is data source can be SelectItemStore or other datastores.
 * 
 */
@EditableValueHolder(dojoType = "dijit.form.FilteringSelect", displayName = "Select Listbox w/Filtering")
class FilteringSelect extends InputBase {

 

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
     * Indicate whether or not case should be ignored when matching possible items.
     * Default is true.
     */
    @Property
    Boolean ignoreCase;

    /**
     * Indicates a value is required to be submitted for this component.
     */
    @Property(handler = RequiredProperty.class)
    Boolean required;

    /**
     * Id of a data store component containing potential values for the field.e.g. SelectItemStore
     */
    @Property(handler = DojoRefProperty.class)
    Object store;

}
