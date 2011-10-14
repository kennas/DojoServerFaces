/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.constants.RenderPosition;
import org.dojoserverfaces.mobile.component.WidgetBase;
import org.dojoserverfaces.mobile.property.TransitionProperty;

/**
 * Heading is a widget that represents a navigation bar, which usually appears
 * at the top of an application. It usually displays the title of the current
 * view and can contain a navigational control. If you use it with
 * dojox.mobile.ScrollableView, it can also be used as a fixed header bar or a
 * fixed footer bar. In such cases, specify the fixed="top" attribute to be a
 * fixed header bar or the fixed="bottom" attribute to be a fixed footer bar.
 * Heading can have one or more ToolBarButton widgets as its children.
 */
@Container(dojoType = "dojox.mobile.Heading", requiredCss = "dojox/mobile/themes/{theme}/Heading.css", renderPosition = RenderPosition.EN_CODE_BEGIN)
class Heading extends WidgetBase {
    /**
     * A label for the navigational control to return to the previous View.
     */
    @Property
    String back;

    /**
     * A URL to open when the navigational control is pressed.
     */
    @Property
    String href;

    /**
     * An id of a View to which the current view moves when the navigational
     * control is pressed.
     */
    @Property
    String moveTo;

    /**
     * A type of animated transition effect. You can choose from the standard
     * transition types, "slide", "fade", "flip", or from the extended
     * transition types, "cover", "coverv", "dissolve", "flip2", "reveal",
     * "revealv", "scaleIn", "scaleOut", "slidev", "swirl", "zoomIn", "zoomOut".
     * If "none" is specified, transition occurs immediately without animation.
     */
    @Property(handler = TransitionProperty.class)
    String transition;

    /**
     * A title text of the heading. If the label is not specified, the innerHTML
     * of the node is used as a label.
     */
    @Property
    String label;

    /**
     * The default icon path for child items. If a child item does not have its
     * own icon parameter specified, this value is used as its icon path. This
     * parameter is especially useful when all or most of the icons are the
     * same, or you use CSS sprite icons, where you specify an aggregated icon
     * image with this parameter and an icon position for each icon.
     */
    @Property
    String iconBase;
}
