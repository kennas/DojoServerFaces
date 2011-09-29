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
 * ListItem represents an item of either RoundRectList or EdgeToEdgeList. There
 * are three ways to move to a different view, moveTo, href, and url. You can
 * choose only one of them.
 */
@Gadget(dojoType = "dojox.mobile.ListItem", requiredCss = { "dojox/mobile/themes/{theme}/ListItem.css" })
public class ListItem extends ItemBase {
    /**
     * A right-aligned text to display on the item.
     * 
     */
    @Property
    String rightText;
    /**
     * An icon to display at the right hand side of the item. The value can be
     * either a path for an image file or a class name of a DOM button.
     * 
     */
    @Property
    String rightIcon;
    /**
     * An icon to display at the left of the rightIcon. The value can be either
     * a path for an image file or a class name of a DOM button.
     */
    @Property
    String rightIcon2;
    /**
     * If true, the label text becomes a clickable anchor text. When the user
     * clicks on the text, the onAnchorLabelClicked handler is called. You can
     * override or connect to the handler and implement any action. The handler
     * has no default action.
     */
    @Property
    Boolean anchorLabel;
    /**
     * If true, the right hand side arrow is not displayed.
     */
    @Property
    Boolean noArrow;
    /**
     * If true, the item is highlighted to indicate it is selected.
     */
    @Property
    Boolean selected;
    /**
     * If true, a check mark is displayed at the right of the item.
     */
    @Property
    Boolean checked;
    /**
     * An icon to display as an arrow. The value can be either a path for an
     * image file or a class name of a DOM button.
     */
    @Property
    String arrowClass;
    /**
     * An icon to display as a check mark. The value can be either a path for an
     * image file or a class name of a DOM button.
     */
    @Property
    String checkClass;
    /**
     * If true, the height of the item varies according to its content. In dojo
     * 1.6 or older, the "mblVariableHeight" class was used for this purpose. In
     * dojo 1.7, adding the mblVariableHeight class still works for backward
     * compatibility.
     */
    @Property
    Boolean variableHeight;
    /**
     * An alt text for the right icon.
     */
    @Property
    String rightIconTitle;
    /**
     * An alt text for the right icon2.
     */
    @Property
    String rightIcon2Title;
    /**
     * The event handler script to execute when the widget is clicked.
     */
    @Event
    String onClick;
    /**
     * The event handler script to execute when the widget is
     * AnchorLabelClicked.
     */
    @Event
    String onAnchorLabelClicked;

}
