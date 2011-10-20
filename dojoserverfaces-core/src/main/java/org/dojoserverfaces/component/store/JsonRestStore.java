/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.store;

import org.dojoserverfaces.build.annotation.DojoObject;
import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;

/**
 * JsonRestStore is a lightweight DataStore implementation of an HTTP-based (RFC
 * 2616) client with RESTful data interaction capabilities. It provides full
 * read, write, and notification capabilities through standards based HTTP/REST
 * interaction with the server using GET, PUT, POST, and DELETE commands.
 * 
 */
@DojoObject(dojoType = "dojox.data.JsonRestStore")
public class JsonRestStore {
    /**
     * This is the target URL for this Service store. This may be used in place
     * of a service parameter to connect directly to RESTful URL without using a
     * dojox.rpc.Service object.
     */
    @Property
    String target;
    /**
     * Defaults to 'id'. The name of the attribute that holds an objects id.
     * This can be a preexisting id provided by the server. If an ID isn't
     * already provided when an object is fetched or added to the store, the
     * autoIdentity system will generate an id for it and add it to the index.
     */
    @Property
    String idAttribute;
    /**
     * The event handler script to execute on new an item.
     */
    @Event
    String onNew;
    /**
     * The event handler script to execute on delete an item.
     */
    @Event
    String onDelete;
    /**
     * The event handler script to execute on .
     */
    @Event
    String onSet;

}
