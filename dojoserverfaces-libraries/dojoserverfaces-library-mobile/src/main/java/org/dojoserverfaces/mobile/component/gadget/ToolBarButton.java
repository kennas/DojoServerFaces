/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.gadget;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.mobile.component.ItemBase;

/**
 * ToolBarButton is a button that is placed in the Heading widget. Unlike
 * Button, it has basically the same capability as ListItem or IconItem, such as
 * icon support, transition, etc.
 * 
 */
@Gadget(dojoType = "dojox.mobile.ToolBarButton", requiredCss = { "dojox/mobile/themes/{theme}/ToolBarButton.css","dojox/mobile/themes/common/domButtons.css" })
public class ToolBarButton extends ItemBase {

    /**
     * If true, the button is in the selected status.
     */
    @Property
    Object selected;
    /**
     * The event handler script to execute when the button is clicked.
     */
    @Event(isDefault = true)
    String onClick;

}
