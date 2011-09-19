/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.gadget;

import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.mobile.component.WidgetBase;

/**
 * A category header for a rounded rectangle list.
 * 
 */
@Gadget(dojoType = "dojox.mobile.RoundRectCategory", requiredCss = "dojox/mobile/themes/{theme}/RoundRectCategory.css")
public class RoundRectCategory extends WidgetBase {
    /**
     * A label text for the widget.
     */
    @Property
    String label;
}
