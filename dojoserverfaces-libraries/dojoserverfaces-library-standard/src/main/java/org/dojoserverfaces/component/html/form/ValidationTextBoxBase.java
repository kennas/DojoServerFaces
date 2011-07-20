/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;


import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.widget.property.StringArrayProperty;

/**
 * 
 * A base class for textBox widgets with validation.
 * 
 */
class ValidationTextBoxBase extends TextBoxBase {

	/**
	 * Indicates a value is required to be submitted for this component.
	 */
	@Property(handler = RequiredProperty.class)
	Boolean required;
	// TODO: seems like required is not retrieved from base implementation

	/**
	 * If defined, display this hint string immediately on focus to the textbox.
	 * Think of this like a tooltip that tells the user what to do, not an error
	 * message that tells the user what they've done wrong.
	 * 
	 * Message disappears when user starts typing.
	 */
	@Property
	String promptMessage;

	/**
	 * The message to display if value is invalid. Set to "" to use the
	 * promptMessage instead.
	 */
	@Property(name = "invalidMessage")
	String validatorMessage; // overriding standard UIInput attr

	/**
	 * The message to display if value is empty and the field is required. Set
	 * to "" to use the invalidMessage instead.
	 */
	@Property(name = "missingMessage")
	String requiredMessage; // overriding standard UIInput attr

	/**
	 * Currently error/prompt message. When using the default tooltip
	 * implementation, this will only be displayed when the field is focused.
	 */
	@Property
	String message;
	// TODO how does this work with the tooltip feature?

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

}
