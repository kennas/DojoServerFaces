/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.gadget;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;

/**
 * A button that can be in two states (checked or not).
 * 
 */
@Gadget(displayName = "Toggle Button", dojoType = "dojox.mobile.ToggleButton",requiredCss = "dojox/mobile/themes/{theme}/ToggleButton.css")
class ToggleButton extends ButtonBase {
    /**
     * The status of the toggle button.
     */
    @Property
    Boolean checked;

    /**
     * The event handler script to execute when the toggle status is changed.
     */
    @Event
    String onChange;
}
