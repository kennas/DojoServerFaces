/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;

/**
 * A TitlePane is a pane that can be opened or collapsed, with a title on top.
 * The visibility of the pane's contents is toggled by activating an arrow
 * "button" on the title bar via the mouse or keyboard. It extends ContentPane.
 */
@Container(dojoType = "dijit.TitlePane")
class TitlePane extends ContentPaneBase {

    /**
     * The tooltip to appear when the mouse is
     * hovered over the title bar.
     */
    @Property
    String tooltip;

    /**
     * Whether pane is opened or closed. Default is true.
     */ 
    @Property
    Boolean open;
    
    /**
     * Whether pane can be opened or closed by clicking the title bar.
     */ 
    @Property
    Boolean toggleable;
    
    /**
     * Time in milliseconds to fade in/fade out
     */
    @Property
    Integer duration;

}
