/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.form;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.mobile.component.WidgetBase;
import org.dojoserverfaces.util.Helper;

/**
 * Switch is a toggle switch with a sliding knob. You can either tap or slide
 * the knob to toggle the switch. The onStateChanged handler is called when the
 * switch is manipulated.
 */
@EditableValueHolder(dojoType = "dojox.mobile.Switch", requiredCss = { "dojox/mobile/themes/{theme}/Switch.css" })
public class Switch extends WidgetBase {
    public static class NameProperty extends
            org.dojoserverfaces.widget.property.Property {

        public NameProperty(String name) {
            super(name);
        }

        public NameProperty(String name, String propertyName) {
            super(name, propertyName);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            return Helper.quote(component.getClientId());
        }

    }

    /**
     * A name for a hidden input field, which holds the current value.
     */
    @Property(exposed = false, handler = NameProperty.class)
    String name;
    /**
     * The left-side label of the switch.
     */
    @Property
    String leftLabel;
    /**
     * The right-side label of the switch.
     */
    @Property
    String rightLabel;
    /**
     * The event handler script to execute when the button is clicked.
     */
    @Event
    String onClick;
    /**
     * The event handler script to execute when the widget is click touchStart.
     */
    @Event
    String onTouchStart;
    /**
     * The event handler script to execute when the widget touchMove events.
     */
    @Event
    String onTouchMove;
    /**
     * The event handler script to execute when the widget is click touchStart.
     */
    @Event
    String onTouchEnd;
    /**
     * The event handler script to execute when the widget's stateChanged.
     */
    @Event
    String onStateChanged;
}
