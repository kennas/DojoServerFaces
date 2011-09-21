/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.mobile.component.WidgetBase;
import org.dojoserverfaces.mobile.property.TransitionProperty;
import org.dojoserverfaces.widget.property.EnumPropertyBase;

/**
 * RoundRectList is a rounded rectangle list, which can be used to display a
 * group of items. Each item must be dojox.mobile.ListItem.
 */
@Container(dojoType = "dojox.mobile.RoundRectList", requiredCss = "dojox/mobile/themes/{theme}/RoundRectList.css")
class RoundRectList extends WidgetBase {
    static class SelectionModeProperty extends EnumPropertyBase {
        private static String[] validValues = { "single", "multiple", "" };

        protected SelectionModeProperty(String name, String propertyName) {
            super(name, propertyName, validValues);
        }
    }

    /**
     * The default animated transition effect for child items. If a child item
     * does not have its own transition parameter specified, this value is used
     * as its animated transition type. You can choose from the standard
     * transition types, "slide", "fade", "flip", or from the extended
     * transition types, "cover", "coverv", "dissolve", "flip2", "reveal",
     * "revealv", "scaleIn", "scaleOut", "slidev", "swirl", "zoomIn", "zoomOut".
     * If "none" is specified, transition occurs immediately without animation.
     * Defaults to "slide".
     */
    @Property(handler = TransitionProperty.class)
    String transition;

    /**
     * The default icon path for child items. If a child item does not have its
     * own icon parameter specified, this value is used as its icon path. This
     * parameter is especially useful when all or most of the icons are the
     * same, or you use CSS sprite icons, where you specify an aggregated icon
     * image with this parameter and an icon position for each icon. Defaults to
     * "".
     */
    @Property
    String iconBase;

    /**
     * The default icon position for child items. This parameter is especially
     * useful when all or most of the icons are the same. Defaults to "".
     */
    @Property
    String iconPos;

    /**
     * Selection mode of the list. The check mark is shown for the selected list
     * item(s). The value can be "single", "multiple", or "". If "single", there
     * can be only one selected item at a time. If "multiple", there can be
     * multiple selected items at a time. Defaults to "".
     */
    @Property
    String select;

    /**
     * If true, the last selected item remains highlighted. Defaults to false.
     */
    @Property
    Boolean stateful;
}
