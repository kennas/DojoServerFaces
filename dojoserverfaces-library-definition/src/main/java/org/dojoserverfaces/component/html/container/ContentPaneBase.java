/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.container;

import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;
import org.dojoserverfaces.widget.property.HrefProperty;

/**
 * A class containing common properties to ContentPane based widgets.
 * 
 */
abstract class ContentPaneBase extends WidgetBase {

    /**
     * When this widget's title attribute is used to for a tab label, accordion
     * pane title, etc., this specifies the tooltip to appear when the mouse is
     * hovered over that text.
     */
    @Property
    String tooltip;

    /**
     * An href or an "outcome" to be processed by the JSF navigation processor
     * to generate a URL to the content to display. By default the container
     * will load the data when the pane is shown. Set preload to true to load it
     * immediately. If this value is not set use set behavior to set it on
     * client. If the value resolves to no navigation case then it will be
     * treated as a local faces page (e.g. "detailsView" will result in
     * detailsView.faces).
     */
    // TODO - do we need a better name to reflect the use of navigation rules?
    @Property(handler = HrefProperty.class)
    String href; 
    
    /**
     * Message that shows if an error occurs.
     */
    @Property
    String errorMessage;

    /**
     * Message that shows while loading content.
     */
    @Property
    String loadingMessage;

    /**
     * Extract visible content from inside of <body> .... </body>. I.e., strip
     * <html> and <head> (and it's contents) from the href
     */
    @Property
    Boolean extractContent;

    /**
     * Force load of data on initialization even if pane is hidden.
     */
    @Property
    Boolean preLoad;

    // TODO support parseOnLoad? Parse content and create the widgets, if any.

    /**
     * Prevent caching of data from href's by appending a timestamp to the href.
     */
    @Property
    Boolean preventCache;

    /**
     * Refresh (re-download) content when pane goes from hidden to shown}
     */
    @Property
    Boolean refreshOnShow;

    // TODO - onloadDeferred ?

    // TODO - ioArgs ?

}