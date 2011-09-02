/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.mobile;

import org.dojoserverfaces.build.annotation.ActionSource;
import org.dojoserverfaces.build.annotation.Property;

/**
 * ToolBarButton is a button that is placed in the Heading widget. Unlike
 * Button, it has basically the same capability as ListItem or IconItem, such as
 * icon support, transition, etc.
 * 
 */
@ActionSource(dojoType = "dojox.mobile.ToolBarButton", requiredCss = { "dojox/mobile/themes/{theme}/ToolBarButton.css" })
public class ToolBarButton extends ItemBase {

    /**
     * If true, the button is in the selected status.
     */
    @Property
    Object selected;

}
