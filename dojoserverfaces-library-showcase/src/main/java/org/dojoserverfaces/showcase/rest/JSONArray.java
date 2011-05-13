package org.dojoserverfaces.showcase.rest;

import java.util.ArrayList;
import java.util.Iterator;

public class JSONArray {
    private ArrayList<JSONObject> list = new ArrayList<JSONObject>();

    public void add(JSONObject obj) {
        list.add(obj);
    }

    public Iterator<JSONObject> iterator() {
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

    public Object get(int index) {
        return list.get(index);
    }

    public void remove(Object obj) {
        list.remove(obj);
    }

    public int size() {
        return list.size();
    }

    public void set(int index, JSONObject obj) {
        list.set(index, obj);
    }
}
