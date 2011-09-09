/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component;

import org.dojoserverfaces.build.annotation.Property;

/**
 * It is mapping to the _ItemBase in dojo.A base class for item classes (e.g.
 * ListItem, IconItem, ToolbarButton,etc.)
 * 
 */
public abstract class ItemBase extends WidgetBase {
    /**
     * A callback function that is called when the transition has been finished.
     * A function reference, or name of a function in context.
     */
    @Property
    Object callback;
    /**
     * If true, this item becomes clickable even if a transition destination
     * (moveTo, etc.) is not specified.
     */
    @Property
    Boolean clickable;
    /**
     * A URL of another web page to go to.
     */
    @Property
    String href;
    /**
     * A target that specifies where to open a page specified by href. The value
     * will be passed to the 2nd argument of window.open().
     */
    @Property
    String hrefTarget;
    /**
     * An icon to display at the left of the item. The value can be either a
     * path for an image file or a class name of a DOM button. If icon is not
     * specified, the iconBase parameter of the parent widget is used.
     */
    @Property
    String icon;
    /**
     * The position of an aggregated icon. IconPos is comma separated values
     * like top,left,width,height (ex. "0,0,29,29"). If iconPos is not
     * specified, the iconPos parameter of the parent widget is used.
     */
    @Property
    String iconPos;
    /**
     * A label of the item. If the label is not specified, innerHTML is used as
     * a label.
     */
    @Property
    String label;
    /**
     * The id of the transition destination view which resides in the current
     * page. If you add the hash sign ('#') before the id, the view transition
     * updates the hash in the browser URL so that the user can bookmark the
     * destination view. The user can also use the browser's back/forward button
     * to navigate through the views in the browser history.
     */
    @Property
    String moveTo;
    /**
     * The name of a scene. Used from dojox.mobile.app.
     */
    @Property
    String scene;
    /**
     * If true, XHR for the view content specified with the url parameter is
     * performed synchronously. If false, it is done asynchronously and the
     * progress indicator is displayed while loading the content. This parameter
     * is effective only when the url parameter is used.
     */
    @Property
    Object sync;
    /**
     * If true, the item acts like a toggle button.
     */
    @Property
    Boolean toggle;
    /**
     * A type of animated transition effect. You can choose from the standard
     * transition types, "slide", "fade", "flip", or from the extended
     * transition types, "cover", "coverv", "dissolve", "flip2", "reveal",
     * "revealv", "scaleIn", "scaleOut", "slidev", "swirl", "zoomIn", "zoomOut".
     * If "none" is specified, transition occurs immediately without animation.
     */
    @Property
    String transition;
    /**
     * The transition direction. If 1, transition forward. If -1, transition
     * backward. For example, the slide transition slides the view from right to
     * left when dir == 1, and from left to right when dir == -1.
     */
    @Property
    Number transitionDir;
    /**
     * A URL of an html fragment page or JSON data that represents a new view
     * content (See examples below). The view content is loaded with XHR and
     * inserted in the current page. Then a view transition occurs to the newly
     * created view. The view is cached so that subsequent requests would not
     * load the content again.
     */
    @Property
    String url;

}
