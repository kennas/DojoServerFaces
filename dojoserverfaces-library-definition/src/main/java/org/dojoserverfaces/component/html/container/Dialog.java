/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.widget.property.ElementIdProperty;

/**
 * A component that can be used as a stand alone component or as a child of
 * other components. It handles replacement of document fragment using either
 * external uri or javascript generated markup or DOM content, instantiating
 * components within that content. Don't confuse it with an iframe, it only
 * needs/wants document fragments. It's useful as a child TabContainer. But note
 * that those classes can contain any component as a child.
 * 
 */
@Container(dojoType = "dijit.Dialog")
class Dialog extends ContentPaneBase {

    /**
     * The time in milliseconds it takes the dialog to fade in and out.
     */
    @Property
    Integer duration;

    /**
     * A Toggle to modify the default focus behavior of a Dialog, which is to
     * re-focus the element which had focus before being opened. False will
     * disable refocusing. Default is true
     */
    @Property
    Boolean refocus;

    /**
     * A flag to indicate setting of focus on the first dialog element after
     * opening the dialog. False will disable autofocusing. Default is true
     */
    @Property
    Boolean autofocus;

    /**
     * Toggles the movable aspect of the Dialog. If true, Dialog can be dragged
     * by it's title. If false it will remain centered in the viewport.
     */
    @Property
    Boolean draggable;

    /**
     * The id of the component containing the text that describes the dialog.
     * This usually will be the first component in the dialog.
     */
    // TODO - does this work?
    @Property(name = "aria-describedby", handler = ElementIdProperty.class)
    String ariaDescribedBy;
}