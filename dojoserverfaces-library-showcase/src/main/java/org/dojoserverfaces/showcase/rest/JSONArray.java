package org.dojoserverfaces.showcase.rest;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Simple JSONArray
 * 
 */
public class JSONArray {
    private ArrayList<JSONObject> list = new ArrayList<JSONObject>();

    void add(JSONObject obj) {
        list.add(obj);
    }

    Iterator<JSONObject> iterator() {
        return list.iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        boolean addcoma = false;
        for (JSONObject obj : list) {
            if (addcoma) {
                sb.append(",");
            }
            sb.append(obj.toString());
            addcoma = true;
        }
        sb.append("]");
        return sb.toString();
    }

    Object get(int index) {
        return list.get(index);
    }

    void remove(Object obj) {
        list.remove(obj);
    }

    int size() {
        return list.size();
    }

    void set(int index, JSONObject obj) {
        list.set(index, obj);
    }
}
