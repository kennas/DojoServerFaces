/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.mobile.component.WidgetBase;
import org.dojoserverfaces.widget.property.EnumPropertyBase;

/**
 * TabBar is a container widget that has typically multiple TabBarButtons which
 * controls visibility of views. It can be used as a tab container. There was
 * dojox.mobile.TabContainer in dojo-1.5, but it is obsolete. In dojo-1.6 or
 * later, use TabBar instead of TabContainer.
 */
@Container(dojoType = "dojox.mobile.TabBar", requiredCss = "dojox/mobile/themes/{theme}/TabBar.css")
class TabBar extends WidgetBase {
    static class BarTypeProperty extends EnumPropertyBase {
        private static String[] validValues = { "tabBar", "segmentedControl" };

        protected BarTypeProperty(String name, String propertyName) {
            super(name, propertyName, validValues);
        }
    }

    /**
     * The default icon path for child items. If a child item does not have its
     * own icon parameter specified, this value is used as its icon path. This
     * parameter is especially useful when all or most of the icons are the
     * same, or you use CSS sprite icons, where you specify an aggregated icon
     * image with this parameter and an icon position for each icon.
     */
    @Property
    String iconBase;

    /**
     * The default icon position for child items. This parameter is especially
     * useful when all or most of the icons are the same.
     */
    @Property
    String iconPos;

    /**
     * "tabBar" or "segmentedControl". Defauts to "tabBar".
     */
    @Property(handler = BarTypeProperty.class)
    String barType;
}
