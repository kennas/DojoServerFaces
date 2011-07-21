/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.layout;

import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;

public class ContainerBase extends WidgetBase {
    /**
     * When this component's title attribute is used to for a tab label, accordion
     * pane title, etc., this specifies the tooltip to appear when the mouse is
     * hovered over that text.
     */
    @Property
    String tooltip;
}
