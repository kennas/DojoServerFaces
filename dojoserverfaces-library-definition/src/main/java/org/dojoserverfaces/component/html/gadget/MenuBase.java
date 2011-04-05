/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.gadget;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;

public class MenuBase extends WidgetBase {

    /**
     * Number of milliseconds before hovering (without clicking) causes the
     * popup to automatically open. Default is 500.
     */
    @Property
    Integer popupDelay;

    /**
     * The event handler script to execute when a child item is clicked.
     */
    @Event
    String onItemClick;

}
