/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.widget.property.EnumPropertyBase;

/**
 * ScrollableView is a container widget that represents entire mobile device
 * screen, and has a touch scrolling capability. ScrollableView is a subclass of
 * View (=dojox.mobile.View). Unlike the base View class, ScrollableView's
 * domNode always stays at the top of the screen and its height is "100%" of the
 * screen. Inside this fixed domNode, containerNode scrolls. Browser's default
 * scrolling behavior is disabled, and the scrolling machinery is re-implemented
 * with JavaScript. Thus the user does not need to use the two-finger operation
 * to scroll an inner DIV (containerNode). The main purpose of this widget is to
 * realize fixed-positioned header and/or footer bars.
 */
@Container(dojoType = "dojox.mobile.ScrollableView", requiredCss = "dojox/mobile/themes/{theme}/ScrollableView.css")
class ScrollableView extends View {
    static class ScrollDirProperty extends EnumPropertyBase {
        private static String[] validValues = { "v", "h", "vh" };

        protected ScrollDirProperty(String name, String propertyName) {
            super(name, propertyName, validValues);
        }
    }

    /**
     * If true, scroll bar is displayed. Defaults to true.
     */
    @Property
    Boolean scrollBar;

    /**
     * Specify a scrolling direction. "v" for vertical, "h" for horizontal, or
     * "vh" for both. Defaults to "v".
     */
    @Property(handler = ScrollDirProperty.class)
    String scrollDir;

    /**
     * Use the fade animation to hide scroll bar. Defaults to true.
     */
    @Property
    Boolean fadeScrollBar;

    /**
     * Disable flashing of scroll bar when a view is shown. Defaults to false.
     */
    @Property
    Boolean disableFlashScrollBar;

    /**
     * Drag threshold value in pixels. The user needs to drag at least the
     * specified pixels before a real drag operation starts. Defaults to 4.
     */
    @Property
    Integer threshold;

    /**
     * Explicitly specified height of the widget (ex. "300px"). If "inherit" is
     * specified, the height is inherited from its offset parent. If "auto" is
     * specified, the content height, which could be smaller than the entire
     * screen height, is used. If nothing is specified, the entire screen height
     * is used.
     */
    @Property
    String height;
}
