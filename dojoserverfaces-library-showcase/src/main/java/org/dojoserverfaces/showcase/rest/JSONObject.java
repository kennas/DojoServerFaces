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
