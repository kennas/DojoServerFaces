/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.values;

import java.util.LinkedHashSet;
import java.util.Set;

public class StringSetData {
    private Set<String> data;

    public StringSetData() {
        this.data = new LinkedHashSet<String>();
    }

    public StringSetData(Set<String> data) {
        this.data = data;
    }

    public StringSetData(String dataItem) {
        this.data = new LinkedHashSet<String>();
        this.data.add(dataItem);
    }

    public Set<String> getData() {
        return data;
    }

    public void setData(Set<String> data) {
        this.data = data;
    }

    public String getDataValues() {
        if (this.data != null) {
            StringBuilder str = new StringBuilder("");
            for (String item : data) {
                str.append(item).append(" ");
            }
            return str.toString().trim();
        }
        return "";
    }
}