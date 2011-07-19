/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.gadget;

import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.widget.property.ElementIdArrayProperty;

/**
 * A context menu you can assign to multiple components.
 * 
 */
@Gadget(dojoType = "dijit.Menu")
class Menu extends MenuBase {

    /**
     * String[] or String containing a space separated list of component ids to
     * which to attach the menu.
     */
    @Property(name = "targetNodeIds", handler = ElementIdArrayProperty.class)
    Object connectTo;

    /**
     * If true, right clicking anywhere on the window will cause this context
     * menu to open. Default is false.
     */
    @Property
    Boolean contextMenuForWindow;

    /**
     * If true, menu will open on left click instead of right click, similiar to
     * a file menu. Default is false.
     */
    @Property
    Boolean leftClickToOpen;

    /**
     * When the menu closes, set focus back to the compoentn which had focus
     * before it was opened. Default is true.
     */
    @Property
    Boolean refocus;

}
