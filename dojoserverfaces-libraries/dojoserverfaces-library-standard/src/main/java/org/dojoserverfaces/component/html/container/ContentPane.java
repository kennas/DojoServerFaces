/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;

/**
 * A component that can be used as a stand alone component or as a child of
 * other components. It handles replacement of document fragment using either
 * external uri or javascript generated markup or DOM content, instantiating
 * components within that content. Don't confuse it with an iframe, it only
 * needs/wants document fragments. It's useful as a child TabContainer. But note
 * that those classes can contain any component as a child.
 * 
 */
@Container(dojoType = "dijit.layout.ContentPane", isContainer = false)
class ContentPane extends ContentPaneBase {

    /**
     * When this widget's title attribute is used to for a tab label, accordion
     * pane title, etc., this specifies the tooltip to appear when the mouse is
     * hovered over that text.
     */
    @Property
    String tooltip;

    /**
     * Parameter for children of dijit.layout.StackContainer or subclasses. If
     * true, change the size of my currently displayed child to match my size
     */
    @Property
    Boolean doLayout;

}