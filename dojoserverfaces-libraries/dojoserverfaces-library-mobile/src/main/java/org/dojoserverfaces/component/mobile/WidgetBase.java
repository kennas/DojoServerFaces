/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.mobile;

import org.dojoserverfaces.build.annotation.Property;
/**
 * 
 * it is base class of all mobile widgets
 *
 */
public abstract class WidgetBase {

    
    /**
     * The CSS style to associate with the rendered HTML element.
     */
    @Property
    String style;

    /**
     * The CSS class to associate with the rendered HTML element.
     */
    @Property(name = "class")
    String styleClass;

    /**
     * The label to display for a given component. This is interchangeable with
     * the 'label' parameter, as some components already have a use for the
     * 'label', and this can be used instead to avoid conflicts.
     */
    @Property
    String title;
    /**
     * When this widget's title attribute is used to for a tab label, accordion
     * pane title, etc., this specifies the tooltip to appear when the mouse is
     * hovered over that text
     */
    @Property
    String tooltip;
}
