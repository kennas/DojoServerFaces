/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.gadget;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;

public class MenuItemBase extends WidgetBase {

    /**
     * Text to display for the item.
     */
    @Property
    String label;

    /**
     * Class to apply to display an icon.
     */
    @Property
    String iconClass;

    /**
     * The event handler script to execute when the component is clicked
     * (keyboard or mouse).
     */
    @Event(isDefault = true)
    String onClick;

    /**
     * The event handler script to execute when the component loses focus.
     */
    @Event
    String onBlur;

    /**
     * The event handler script to execute when the component gains focus.
     */
    @Event
    String onFocus;

    /**
     * Whether or not this component is disabled.
     */
    @Property
    Boolean disabled;

    /**
     * The tab index for this component.
     */
    @Property
    Integer tabIndex;

}
