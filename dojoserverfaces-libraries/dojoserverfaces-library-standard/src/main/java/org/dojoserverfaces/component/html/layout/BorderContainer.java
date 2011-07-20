/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.layout;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;

/**
 * A BorderContainer is a box with a specified size, such as
 * style="width: 500px; height: 500px;", that contains a child widget marked
 * region="center" and optionally children widgets marked region equal to "top",
 * "bottom", "leading", "trailing", "left" or "right". Children along the edges
 * will be laid out according to width or height dimensions and may include
 * optional splitters (splitter="true") to make them resizable by the user. The
 * remaining space is designated for the center region.
 * 
 * The outer size must be specified on the BorderContainer node. Width must be
 * specified for the sides and height for the top and bottom, respectively. No
 * dimensions should be specified on the center; it will fill the remaining
 * space. Regions named "leading" and "trailing" may be used just like "left"
 * and "right" except that they will be reversed in right-to-left environments.
 * 
 * For complex layouts, multiple children can be specified for a single region.
 * In this case, the layoutPriority flag on the children determines which child
 * is closer to the edge (low layoutPriority) and which child is closer to the
 * center (high layoutPriority). layoutPriority can also be used instead of the
 * design attribute to conrol layout precedence of horizontal vs. vertical
 * panes.
 * 
 * A height must be set specified (e.g. style="height:400px").
 * 
 */
@Container(dojoType = "dijit.layout.BorderContainer")
class BorderContainer extends ContainerBase{

    /**
     * design to use for the layout: - "headline" (default) where the top and
     * bottom extend the full width of the container - "sidebar" where the left
     * and right sides extend from top to bottom.
     */
    @Property
    String design;

    /**
     * Give each pane a border and margin. Margin determined by
     * domNode.paddingLeft. When false, only resizable panes have a gutter (i.e.
     * draggable splitter) for resizing.
     */
    @Property
    Boolean gutters;

    /**
     * Specifies whether splitters resize as you drag (true) or only upon
     * mouseup (false)
     */
    @Property
    Boolean liveSplitters;

    /**
     * Save splitter positions in a cookie.
     */
    @Property
    Boolean persist;

}
