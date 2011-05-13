package org.dojoserverfaces.showcase.rest;

import java.util.HashMap;
import java.util.Map;

public class JSONObject {
    private Map<Object, Object> jsonObj = new HashMap<Object, Object>();

    public void put(Object key, Object value) {
        String skey = "\""+key+"\"";
        String sv = "\""+value+"\"";
        jsonObj.put(skey, sv);
    }
    public String toString(){
        return jsonObj.toString().replace("=", ":");
    }
    public Object get(Object key){
        return jsonObj.get(key);
    }

}
