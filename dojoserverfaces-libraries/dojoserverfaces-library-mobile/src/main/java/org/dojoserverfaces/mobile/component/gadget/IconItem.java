/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.gadget;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.mobile.component.ItemBase;

/**
 * IconItem represents an item that has an application component and its icon
 * image. You can tap the icon to open the corresponding application component.
 * You can also use the icon to move to a different view by specifying either of
 * the moveTo, href or url parameters.
 * 
 */
@Gadget(dojoType = "dojox.mobile.IconItem", requiredCss = { "dojox/mobile/themes/{theme}/IconItem.css" })
public class IconItem extends ItemBase {
    /**
     * If true, the content of the item, which includes dojo markup, is
     * instantiated lazily. That is, only when the icon is opened by the user,
     * the required modules are loaded and dojo widgets are instantiated.
     */
    @Property
    Boolean lazy;
    /**
     * Comma-separated required module names to be loaded. All the modules
     * specified with dojoType and their depending modules are automatically
     * loaded by the IconItem. If you need other extra modules to be loaded, use
     * this parameter. If lazy is true, the specified required modules are
     * loaded when the user opens the icon for the first time.
     */
    @Property
    String requires;
    /**
     * Duration of highlight in seconds.
     */
    @Property
    String timeout;
    /**
     * A class name of a DOM button to be used as a close button.
     */
    @Property
    String closeBtnClass;
    /**
     * Properties for the close button.
     */
    @Property
    String closeBtnProp;
    /**
     * The event handler script to execute when the icon is Opened.
     */
    @Event
    String onOpen;
    /**
     * The event handler script to execute when the icon is closed.
     */
    @Event
    String onClose;
    /**
     * To-Do javadoc.
     */
    @Event
    String onMouseDownIcon;
    /**
     * The event handler script to execute when the icon is clicked.
     */
    @Event
    String onError;
    /**
     * The event handler script to execute when the icon is clicked.
     */
    @Event
    String onClick;

}
