/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.data;

import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;
import org.dojoserverfaces.widget.property.DojoRefProperty;
import org.dojoserverfaces.widget.property.PropertyCollectionProperty;

public abstract class GridBase extends WidgetBase {
    /**
     * data store
     */
    @Property(handler = DojoRefProperty.class)
    Object store;

    /**
     * Set to true if you want to be able to select the text within the grid.
     */
    @Property
    Boolean selectable;
    /**
     * a row selector of that width to this grid.
     */
    @Property
    String rowSelector;
    /**
     * Set the selection mode of grid's Selection. Value must be 'single',
     * 'multiple', or 'extended'. Default is 'extended'.
     */
    @Property
    String selectionMode;

    /**
     * Message that shows while the grid is loading
     */
    @Property
    String loadingMessage;

    /**
     * Message that shows when the grid encounters an error loading
     */
    @Property
    String errorMessage;

    /**
     * structurer usage
     */
    @Property(handler = PropertyCollectionProperty.class)
    Object structure;
    /**
     * query usage
     */
    @Property
    String query;
    /**
     * if autoHeight is true, grid height is automatically set to fit the data.
     * If it is an integer, the height will be automatically set to fit the data
     * if there are fewer than that many rows - and the height will be set to
     * show that many rows if there are more
     */
    @Property
    Object autoHeight;
    /**
     * Number of rows to render at a time
     */
    @Property
    Object rowsPerPage;
    /**
     * A boolean value that defines whether a single or double click is needed
     * to enter cell editing mode.
     */
    @Property
    Boolean singleClickEdit;
}
