/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.form;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.form.NumberInputBase.NumberValue;
import org.dojoserverfaces.constants.HtmlElementType;

/**
 * An component that allows one to select a value with a horizontally draggable
 * handle. Labels and rule marks are provided by separate components:
 * HorizontalRuleLabels and HarizontalRule.
 */
@EditableValueHolder(dojoType = "dijit.form.HorizontalSlider", elementType = HtmlElementType.DIV)
public class HorizontalSlider extends InputBase {

    // magically the dijit creates a hidden input field with the appropriate
    // name so that a value is submitted as expected.

    /**
     * The value, a number, for this component.
     */
    @Property(handler = NumberValue.class)
    Number value;

    /**
     * Flag controlling the showing of the increment/decrement buttons at the
     * ends of the slider. Default is true.
     */
    @Property
    Boolean showButtons;

    /**
     * The minimum value the slider can be set to. Default is 0
     */
    @Property
    Integer minimum;

    /**
     * The maximum value the slider can be set to. Default is 100.
     */
    @Property
    Integer maximum;

    /**
     * If specified, indicates that the slider handle has only 'discreteValues'
     * possible positions, and that after dragging the handle, it will snap to
     * the nearest possible position. Thus, the slider has only 'discreteValues'
     * possible values.
     * 
     * For example, if minimum=10, maximum=30, and discreteValues=3, then the
     * slider handle has three possible positions, representing values 10, 20,
     * or 30.
     * 
     * If discreteValues is not specified or if it's value is higher than the
     * number of pixels in the slider bar, then the slider handle can be moved
     * freely, and the slider's value will be computed/reported based on pixel
     * position (in this case it will likely be fractional, such as 123.456789).
     */
    @Property
    Integer discreteValues;

    /**
     * If discreteValues is also specified, this indicates the amount of clicks
     * (that is snap positions) that the slider handle is moved via page up/page
     * down keys. If discreteValues is not specified, it indicates the number of
     * pixels. Default is 2
     */
    @Property
    Integer pageIncrement;

    /**
     * Flag to indicate if clicking the slider bar changes the value or not.
     */
    @Property
    Boolean clickSelect;

    /**
     * The time in ms to take to animate the slider handle from 0% to 100%, when
     * clicking the slider bar to make the handle move.
     */
    @Property
    Integer slideDuration;

}
