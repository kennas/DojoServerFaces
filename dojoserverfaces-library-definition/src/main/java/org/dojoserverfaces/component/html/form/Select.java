/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.build.annotation.SelectValueHolder;
import org.dojoserverfaces.widget.property.DojoRefProperty;
import org.dojoserverfaces.widget.property.StringArrayProperty;

/**
 * The Select component allows the selection of an item from a list of items.
 * You provide a list of acceptable value pairs consisting of text to be
 * displayed and value to be submitted through SelectItemStore component
 * 
 */
@SelectValueHolder(dojoType = "dijit.form.Select", displayName = "Select Listbox")
class Select extends InputBase {

    /**
     * Indicates a value is required to be submitted for this component.
     */
    @Property(handler = RequiredProperty.class)
    Boolean required;

    /**
     * Currently error/prompt message. When using the default tooltip
     * implementation, this will only be displayed when the field is focused.
     */
    @Property
    String message;
    // TODO does this conflict with common tooltip attribute?

    /**
     * This attribute controls the position of the tooltip. It can be a list of
     * the following values:
     * 
     * before: places tooltip to the left of the component, or to the right in
     * the case of RTL scripts like Hebrew and Arabic
     * 
     * after: places tooltip to the right of the target node/widget, or to the
     * left in the case of RTL scripts like Hebrew and Arabic
     * 
     * above: tooltip goes above target node
     * 
     * below: tooltip goes below target node
     * 
     * The list, (String[] or a String where the values are space separated, of
     * positions is tried, in order, until a position is found where the tooltip
     * fits within the viewport. Be careful setting this attribute. A value of
     * "above" may work fine until the user scrolls the screen so that there's
     * no room above the target node. Nodes with drop downs, like DropDownButton
     * or FilteringSelect, are especially problematic, in that you need to be
     * sure that the drop down and tooltip don't overlap, even when the viewport
     * is scrolled so that there is only room below (or above) the target node,
     * but not both.
     */
    @Property(handler = StringArrayProperty.class)
    Object tooltipPosition;
    /**
     * Id of a data store component containing potential values for the field.e.g.SelectItemStore
     */
    @Property(handler = DojoRefProperty.class)
    Object store;

}
