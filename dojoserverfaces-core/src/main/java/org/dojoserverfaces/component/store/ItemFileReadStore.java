/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.store;

import org.dojoserverfaces.build.annotation.DojoObject;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.widget.property.AsStringProperty;

/**
 * A store for fetching JSON formatted data.
 * 
 */
@DojoObject(dojoType = "dojo.data.ItemFileReadStore")
class ItemFileReadStore extends StoreBase {

    /**
     * json formated data definition string.
     */
    @Property(handler = AsStringProperty.class)
    String data;
}
