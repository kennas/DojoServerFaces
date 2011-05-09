/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.store;

import org.dojoserverfaces.build.annotation.Property;

public class StoreBase {
    /**
     * URL of data to fetch.
     */
    // TODO we should create Resource Property handler that
    // would take advantage of JSF's resource handling
    @Property
    String url;

}
