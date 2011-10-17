/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.mobile.component;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.widget.property.DojoRefProperty;

/**
 * It is a base class of data list widgets
 * 
 */
public abstract class DataListBase extends ListBase {
    /**
     * Reference to data provider object
     */
    @Property(handler = DojoRefProperty.class)
    Object store;
    /**
     * A query that can be passed to 'store' to initially filter the items.
     */
    @Property
    Object query;
    /**
     * An optional parameter for the query.
     */
    @Property
    Object queryOptions;
    /**
     * An handler that is called after the fetch completes.
     */
    @Event
    String onComplete;
    /**
     * An error handler.
     */
    @Event
    String onError;
    /**
     * "new" event handler
     */
    @Event
    String onNew;
    /**
     * "delete" event handler
     */
    @Event
    String onDelete;
    /**
     * "set" event handler
     */
    @Event
    String onSet;
}
