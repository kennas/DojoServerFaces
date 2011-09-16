/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.constants.RendersChildren;
import org.dojoserverfaces.mobile.component.WidgetBase;
import org.dojoserverfaces.mobile.property.TransitionProperty;

/**
 * IconContainer is a container widget that holds multiple icons each of which
 * represents application component.
 */
@Container(dojoType = "dojox.mobile.IconContainer", requiredCss = "dojox/mobile/themes/{theme}/IconContainer.css", rendersChildren = RendersChildren.YES_USE_ADD_CHILD)
public class IconContainer extends WidgetBase {
    /**
     * The default fall-back icon, which is displayed only when the specified
     * icon has failed to load.
     */
    @Property
    String defaultIcon;
    /**
     * A type of animated transition effect. You can choose from the standard
     * transition types, "slide", "fade", "flip", or from the extended
     * transition types, "cover", "coverv", "dissolve", "flip2", "reveal",
     * "revealv", "scaleIn", "scaleOut", "slidev", "swirl", "zoomIn", "zoomOut".
     * If "none" is specified, transition occurs immediately without animation.
     * If "below" is specified, the application contents are displayed below the
     * icons.
     */
    @Property(handler = TransitionProperty.class)
    String transition;
    /**
     * The opacity of the pressed icon image.
     */
    @Property
    Number pressedIconOpacity;
    /**
     * The default icon path for child items.
     */
    @Property
    String iconBase;
    /**
     * The default icon position for child items.
     */
    @Property
    String iconPos;
    /**
     * A label for the navigational control.
     */
    @Property
    String back;
    /**
     * A title text of the heading.
     */
    @Property
    String label;
    /**
     * If true, only one icon content can be opened at a time.
     */
    @Property
    Boolean single;
}
