/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;

public abstract class WidgetBase {
    /**
     * The CSS style to associate with the rendered HTML element.
     */
    @Property
    String style;

    /**
     * The CSS class to associate with the rendered HTML element.
     */
    @Property(name="class")
    String styleClass;

    /**
     * The label to display for a given component. This is interchangeable with
     * the 'label' parameter, as some components already have a use for the
     * 'label', and this can be used instead to avoid conflicts.
     */
    @Property
    String title;

    // TODO - figure these "parent" properties out (i.e. where do they belong)

    /**
     * Parameter for children of BorderContainer. Values: "top",
     * "bottom", "leading", "trailing", "left", "right", "center". See the
     * BorderContainer description for details.
     */
    @Property
    String region;

    /**
     * The number of columns this widget should span.
     */
    @Property
    Integer colspan;

    /**
     * Column of the grid to place the widget for use with the 
     * GridContainerLite.
     */
    @Property
    String column;

    /**
     * CSS class specifying icon to use in label associated with this pane.
     */
    @Property
    String iconClass;

    /**
     * When true, display the title of this component as tab label etc., 
     * rather than just using the icon specified in iconClass
     */
    @Property
    Boolean showTitle;

    /**
     * Specifies a minimum size (in pixels) for this widget when resized 
     * by a splitter (e.g. when used as a child of BorderContainer)
     */
    @Property
    Integer minSize;

    /**
     * When the component is a child of a BorderContainer and set to
     * true, it will enable users to resize the component by putting a
     * draggable splitter between this component and the component 
     * with region=center. This cannot be used when the component
     * is the center childe (e.g. region="center"). 
     */
    @Property
    Boolean splitter;

    /**
     * When this component is used as a child of various container components it 
     * specifies that this component should be the initially displayed pane.
     */
    @Property
    Boolean selected;

    /**
     * When this component is used as a child of various container components it 
     * specifies that it can be closed. For example, clicking the X on the tab.
     */
    @Property
    Boolean closable;

    /**
     * When this component is used as a child of a GridContainer 
     * specifies that the widget is not to be "draggable".
     */
    @Property
    Boolean dragRestriction;

    /**
     * Setting spanLabel to true makes the widget take up both the label and
     * value cells. Defaults to false.
     */
    @Property
    Boolean spanLabel;

    /*
     * Mouse events
     */

    /**
     * The event handler script to execute on a mouse click. The event object
     * contains coordinates.
     */
    @Event
    String onClick;

    /**
     * The event handler script to execute on a mouse double click. The event
     * object contains coordinates.
     */
    @Event
    String onDblClick;

    /**
     * The event handler script to execute on a mouse button press. The event
     * object contains coordinates.
     */
    @Event
    String onMouseDown;

    /**
     * The event handler script to execute on a mouse pointer move. The event
     * object contains coordinates.
     */
    @Event
    String onMouseMove;

    /**
     * The event handler script to execute when mouse pointer moves out of an
     * element. The event object contains coordinates.
     */
    @Event
    String onMouseOut;

    /**
     * The event handler script to execute when mouse pointer moves over an
     * element. The event object contains coordinates.
     */
    @Event
    String onMouseOver;

    /**
     * The event handler script to execute on a mouse button release. The event
     * object contains coordinates.
     */
    @Event
    String onMouseUp;

    /*
     * Keyboard events
     */

    /**
     * The event handler script to execute when a key is pressed.
     */
    @Event
    String onKeyDown;

    /**
     * The event handler script to execute when a key is pressed and released.
     */
    @Event
    String onKeyPress;

    /**
     * The event handler script to execute when a key is released.
     */
    @Event
    String onKeyUp;

    // TODO - do onShow and onHide belong here?

    /**
     * Called when the component becomes the selected pane in various
     * container components. Or is a component being displayed (e.g. a Dialog).
     */
    @Event
    String onShow;

    /**
     * Called when the component becomes a hidden pane in various
     * container components. Or is a component being hidden (e.g. a Dialog).
     */
    @Event
    String onHide;

}
