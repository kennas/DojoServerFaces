/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.gadget;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;

public class ButtonBase extends WidgetBase {

    /**
     * Whether or not this component is disabled.
     */
    @Property
    Boolean disabled;

    /**
     * Text to display in the button. If the label is hidden (showLabel=false) then
     * and no title has been specified, then label is also set as title
     * attribute of icon.
     */
    @Property
    String label;

    /**
     * Set this to false to hide the label text and display only the icon. (If
     * showLabel=false then iconClass must be specified.) Especially useful for
     * toolbars. If showLabel=true, the label will become the title (a.k.a.
     * tooltip/hint) of the button.
     * 
     * The exception case is for computers in high-contrast mode, where the
     * label will still be displayed, since the icon doesn't appear.
     * 
     */
    @Property
    Boolean showLabel;

    /**
     * Class to apply in button to make it display an icon
     */
    @Property
    String iconClass;
    
    /**
     * The event handler script to execute when the button is clicked.
     */
    @Event(isDefault = true)
    String onClick;


}
