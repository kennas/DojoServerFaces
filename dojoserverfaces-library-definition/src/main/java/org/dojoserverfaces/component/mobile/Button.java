package org.dojoserverfaces.component.mobile;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;

@Gadget(dojoType = "dojox.mobile.Button", requiredCss = { "dojox/mobile/themes/{theme}/Button.css" })
public class Button {

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
     * 
     * 
     */
    @Property
    String style;

    /**
     * 
     */
    @Property(name="class")
    String styleClass;
    
    /**
     * The event handler script to execute when the button is clicked.
     */
    @Event(isDefault = true)
    String onClick;

}
