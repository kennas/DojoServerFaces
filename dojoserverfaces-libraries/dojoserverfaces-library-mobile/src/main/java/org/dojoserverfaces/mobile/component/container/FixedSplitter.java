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
import org.dojoserverfaces.widget.property.EnumPropertyBase;

/**
 * FixedSplitter is a very simple container widget that layouts its child dom
 * nodes side by side either horizontally or vertically. An example usage of
 * this widget would be to realize the split view on iPad. There is no visual
 * splitter between the children, and there is no function to resize the child
 * panes with drag-and-drop. If you need a visual splitter, you can specify a
 * border of a child dom node with CSS. A child of the widget should be
 * FixedSplitterPane.
 */
@Container(dojoType = "dojox.mobile.FixedSplitter", requiredCss = "dojox/mobile/themes/common/FixedSplitter.css", renderPosition = RenderPosition.EN_CODE_BEGIN)
class FixedSplitter extends WidgetBase {
    static class OrientationProperty extends EnumPropertyBase {
        private static String[] validValues = { "H", "V" };

        protected OrientationProperty(String name, String propertyName) {
            super(name, propertyName, validValues);
        }
    }

    /**
     * The direction of split. If "H" is specified, panes are split
     * horizontally. If "V" is specified, panes are split vertically. Defaults
     * to "H".
     */
    @Property(handler = OrientationProperty.class)
    String orientation;
}
