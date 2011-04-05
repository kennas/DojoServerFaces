/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.behavior;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Submit {
    private static final String[] COLORS = { "red", "orange", "yellow",
            "green", "blue", "indigo", "purple" };

    private final List<Pair> showcaseColors = new ArrayList<Pair>();
    {
        for (String c : COLORS) {
            showcaseColors.add(new Pair(c, Boolean.FALSE));
        }
    }

    public static class Pair {
        private String key;
        private Boolean value;

        public Pair() {
        }

        public Pair(String key, Boolean value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Boolean getValue() {
            return value;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void setValue(Boolean value) {
            this.value = value;
        }
    }

    public String getFavouriteColor() {
        for (Pair c : showcaseColors) {
            if (c.getValue())
                return c.getKey();
        }
        return null;
    }

    public List<Pair> getShowcaseColors() {
        return showcaseColors;
    }
}
