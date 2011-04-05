/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.layout;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;

/**
 * A grid containing any kind of objects and acting like web portals.
 * 
 * This component inherits of all features of GridContainerLite plus: resize
 * columns, add / remove columns and fix columns at left or at right.
 */
@Container(dojoType = "dojox.layout.GridContainer")
class GridContainer extends GridContainerLite {
    /**
     * Allow or not resizing of columns by a grip handle. Defaults to true.
     */
    @Property
    Boolean hasResizableColumns;

    /**
     * Specifies whether columns resize as you drag (true) or only upon
     * mouseup (false). Defaults to false.
     */
    @Property
    Boolean liveResizeColumns;

    /**
     * Minimum column width in percentage. Default is 20.
     */
    @Property
    Integer minColWidth;

    /**
     * Minimum children width in pixel (only used for IE6 which doesn't handle
     * min-width css property). Default is 150.
     */
    @Property
    Integer minChildWidth;

    /**
     * Location to add/remove columns, must be set to 'left' or 'right'
     * (default).
     */
    @Property
    String mode;

    /**
     * Define if the last right column is fixed. Used when you add or remove
     * columns by calling setColumns method. Defaults to false.
     */
    @Property
    Boolean isRightFixed;

    /**
     * Define if the last left column is fixed. Used when you add or remove
     * columns by calling setColumns method. Defaults to false.
     */
    @Property
    Boolean isLeftFixed;
}
