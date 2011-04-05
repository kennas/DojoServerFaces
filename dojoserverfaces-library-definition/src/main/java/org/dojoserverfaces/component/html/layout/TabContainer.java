/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.layout;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;

/**
 * Holds a set of panes where every pane's title is visible, but only one pane's
 * content is visible at a time, and switching between panes is visualized by
 * sliding the other panes up/down. 
 * A height must be set specified (e.g. style="height:400px".
 * 
 */
@Container(dojoType = "dijit.layout.TabContainer")
class TabContainer extends StackContainer {

    // TODO - controllerWidget
    // An optional parameter to override the widget used to display the tab
    // labels

    /**
     * If true, use styling for a TabContainer nested inside another
     * TabContainer. For tundra etc., makes tabs look like links, and hides the
     * outer border since the outer TabContainer already has a border.
     */
    @Property
    Boolean nested;

    /**
     * Defines where tabs go relative to tab content. "top", "bottom", "left-h",
     * "right-h"
     */
    @Property
    String tabPosition;

    /**
     * Defines whether the tablist gets an extra class for layouting, putting a
     * border/shading around the set of tabs.
     */
    @Property
    Boolean tabStrip;

    /**
     * True if a menu should be used to select tabs when they are too wide to
     * fit the TabContainer, false otherwise.
     */
    @Property
    Boolean useMenu;

    /**
     * True if a slider should be used to select tabs when they are too wide to
     * fit the TabContainer, false otherwise.
     */
    @Property
    Boolean useSlider;

}
