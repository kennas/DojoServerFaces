/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.layout;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;

/**
 * The GridContainerLite is a container of child elements that are placed in a
 * kind of grid.
 * 
 * GridContainerLite displays the child elements by column (ie: the children
 * widths are fixed by the column width of the grid but the children heights are
 * free). Each child is movable by drag and drop inside the GridContainer. The
 * position of other children is automatically calculated when a child is moved.
 */
@Container(dojoType = "dojox.layout.GridContainerLite")
class GridContainerLite extends ContainerBase {

    /**
     * Enable the refresh of registered areas on drag start. Defaults to true.
     */
    @Property
    Boolean autoRefresh;

    /**
     * CSS class enabling a drag handle on a child.
     */
    // TODO - what?
    @Property
    String dragHandleClass;

    /**
     * The number of dropped zones, by default 1.
     */
    @Property
    Integer nbZones;

    /**
     * If true, change the size of my currently displayed child to match my
     * size. Defaults to true.
     */
    @Property
    Boolean doLayout;

    /**
     * If true, widgets are organized automatically, /** else the attribute
     * colum of child will define the right column. Defaults to true.
     */
    @Property
    Boolean isAutoOrganized;

    /**
     * The GridContainer will only accept the children that fit to the types.
     */
    // TODO - what?
//    @Property
//    String acceptTypes;

    /**
     * A comma separated list of column widths. If the column widths do not add
     * up to 100, the remaining columns split the rest of the width evenly
     * between them.
     */
    @Property
    String colWidths;

}
