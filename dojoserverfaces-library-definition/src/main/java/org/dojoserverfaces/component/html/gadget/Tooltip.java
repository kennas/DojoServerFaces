/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.gadget;

import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;
import org.dojoserverfaces.widget.property.ElementIdArrayProperty;
import org.dojoserverfaces.widget.property.StringArrayProperty;

/**
 * A component that pops up a tooltip (a help message) when you hover over a
 * component.
 */
@Gadget(dojoType = "dijit.Tooltip")
class Tooltip extends WidgetBase {

	/**
	 * Text to display in the tooltip. This may contain simple html markup.
	 */
	@Property
	String label;
	/*
	 * TODO perhaps we need to support CDATA in this attribute otherwise the
	 * user will not be able to specify markup in the facelet file itself but
	 * only through a value expression.
	 */

	/**
	 * Number of milliseconds to wait after hovering over/focusing on the
	 * object, before the tooltip is displayed. Default is 400.
	 */
	@Property
	Integer showDelay;

	/**
	 * String[] or String containing a space separated list of component ids to
	 * to which to attach the tooltip. When user hovers over any of the
	 * specified components, the tooltip will appear.
	 */
	@Property(name = "connectId", handler = ElementIdArrayProperty.class)
	Object connectTo;

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
	Object position;
}
