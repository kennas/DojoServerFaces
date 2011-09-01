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
public class ToolBarButton extends AbstractItem {

    /**
     * If true, the button is in the selected status.
     */
    @Property
    Object selected;

}
