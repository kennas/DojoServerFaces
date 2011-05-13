/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.rest;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple JSONObject
 * 
 */
public class JSONObject {
    private Map<Object, Object> jsonObj = new HashMap<Object, Object>();

    void put(Object key, Object value) {
        jsonObj.put("\"" + key + "\"", "\"" + value + "\"");
    }

    public String toString() {
        return jsonObj.toString().replace("=", ":");
    }

    Object get(Object key) {
        return jsonObj.get(key);
    }

}
