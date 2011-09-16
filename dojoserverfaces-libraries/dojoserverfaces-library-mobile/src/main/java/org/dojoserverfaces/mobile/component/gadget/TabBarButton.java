/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component.gadget;

import org.dojoserverfaces.build.annotation.ActionSource;
import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.mobile.component.ItemBase;

/**
 * TabBarButton is a button that is placed in the TabBar widget. It is a
 * subclass of dojox.mobile._ItemBase just like ListItem or IconItem. So, unlike
 * Button, it has similar capability as ListItem or IconItem, such as icon
 * support, transition, etc.
 * 
 */
@ActionSource(dojoType = "dojox.mobile.TabBarButton", requiredCss = { "dojox/mobile/themes/{theme}/TabBarButton.css" })
public class TabBarButton extends ItemBase {
    /**
     * A path for the unselected (typically dark) icon. If icon is not
     * specified, the iconBase parameter of the parent widget is used.
     */
    @Property
    String icon1;
    /**
     * A path for the selected (typically highlight) icon. If icon is not
     * specified, the iconBase parameter of the parent widget or icon1 is used.
     */
    @Property
    String icon2;
    /**
     * The position of an aggregated unselected (typically dark) icon. IconPos1
     * is comma separated values like top,left,width,height (ex. "0,0,29,29").
     * If iconPos1 is not specified, the iconPos parameter of the parent widget
     * is used.
     */
    @Property
    String iconPos1;
    /**
     * The position of an aggregated selected (typically highlight) icon.
     * IconPos2 is comma separated values like top,left,width,height (ex.
     * "0,0,29,29"). If iconPos2 is not specified, the iconPos parameter of the
     * parent widget or iconPos1 is used.
     */
    @Property
    String iconPos2;
    /**
     * If true, the button is in the selected status.
     */
    @Property
    Boolean selected;
    /**
     * A name of html tag to create as domNode.
     */
    @Property
    String tag;
    /**
     * The event handler script to execute when the button is clicked.
     */
    @Event(isDefault = true)
    String onClick;

}
