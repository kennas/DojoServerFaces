/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.form;

import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.constants.HtmlElementType;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.property.EnumPropertyBase;
import org.dojoserverfaces.widget.property.ValueProperty;

/**
 * A non-templated Slider widget similar to the HTML5 INPUT type=range.
 * 
 */
@EditableValueHolder(dojoType = "dojox.mobile.Slider", requiredCss = { "dojox/mobile/themes/{theme}/Slider.css" }, elementType = HtmlElementType.INPUT_TEXT)
public class Slider extends InputBase {

    static class NumberValue extends ValueProperty {

        public NumberValue() {
            super();
        }

        public NumberValue(String string, String string2) {
            this();
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            if (component instanceof javax.faces.component.EditableValueHolder) {
                // if editableValueHolder then the value could be from alternate
                // variables
                javax.faces.component.EditableValueHolder editableValue = 
                    (javax.faces.component.EditableValueHolder) component;
                Object submittedValue = editableValue.getSubmittedValue();
                if (null != submittedValue) {
                    // if there is a submitted value we'll not try to make a
                    // date
                    if (submittedValue instanceof String) {
                        // just return current "submitted" value
                        return Helper.makeStringVar((String) submittedValue);
                    }
                    else {
                        // TODO consider handling this as an err?
                        return Helper.makeStringVar(submittedValue.toString());
                    }
                }
                else if (editableValue.isLocalValueSet()) {
                    return getAsJavascriptNumber(Helper.getConvertedValue(
                            component, editableValue.getLocalValue()));
                }
            }
            return getAsJavascriptNumber(Helper.getConvertedValue(component,
                    ((ValueHolder) component).getValue()));
        }

        String getAsJavascriptNumber(String valueAsString) {
            return valueAsString;
        }
    }
    /**
     * The value, a number, for this component.
     */
    @Property(handler = NumberValue.class)
    Number value;


    /**
     * The first value the slider can be set to.
     */
    @Property
    Integer min;
    /**
     * The last value the slider can be set to.
     */
    @Property
    Integer max;
    /**
     * The delta from 1 value to another. This causes the slider handle to
     * snap/jump to the closest possible value. A value of 0 means continuous
     * (as much as allowed by pixel resolution).
     */
    @Property
    Integer step;
    /**
     * Specifies if the slider should change its default: ascending <-->
     * descending.
     */
    @Property
    Boolean flip;

    static protected class OrientationProperty extends EnumPropertyBase {
        private static String[] validValues = { "H", "V", "auto" };

        protected OrientationProperty(String name, String propertyName) {
            super(name, propertyName, validValues);
        }
    }

    /**
     * The slider direction. "H": horizontal "V": vertical "auto": use
     * width/height comparison at instantiation time (default is "H" if
     * width/height are 0)
     */
    @Property(handler = OrientationProperty.class)
    String orientation;
    /**
     * Size of the boundary that extends beyond the edges of the slider to make
     * it easier to touch.
     */
    @Property
    Integer halo;
}
