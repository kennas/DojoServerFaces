/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.form;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;

/**
 * Base Class of TextBox
 * 
 */
abstract class TextBoxBase extends InputBase {
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
     * Help text displayed inside the input field.
     */
    @Property
    String placeHolder;

    /**
     * Indication that all text should be selected when field receives focus
     * with mouse
     */
    @Property
    Boolean selectOnClick;

    /**
     * The event handler script to execute when text in the field is selected.
     */
    @Event
    String onSelect;

}
