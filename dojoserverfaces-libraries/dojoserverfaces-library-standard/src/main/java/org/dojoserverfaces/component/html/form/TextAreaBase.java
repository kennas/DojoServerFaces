/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;

class TextAreaBase extends InputBase {

	/**
	 * The maximum length of input to be allowed by the client.
	 */
	@Property
	Integer maxLength;

	/**
	 * Indication of whether or not leading and trailing whitespace are trimmed
	 * from the input field on the client.
	 */
	@Property
	Boolean trim;

	/**
	 * The event handler script to execute when text in the field is selected.
	 */
	@Event
	String onSelect;

	/**
	 * The width of the text area.
	 */
	@Property
	Integer cols;

	/**
	 * Indication that all text should be selected when field receives focus with mouse
	 */
	@Property
	Boolean selectOnClick;

}
