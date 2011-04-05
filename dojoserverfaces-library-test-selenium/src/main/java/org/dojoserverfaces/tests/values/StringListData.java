/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.values;

import java.util.ArrayList;
import java.util.List;

public class StringListData {
    private List<String> data;

    public StringListData() {
        //
    }

    public StringListData(List<String> data) {
        this.data = data;
    }

    public StringListData(String dataItem) {
        this.data = new ArrayList<String>();
        this.data.add(dataItem);
    }

    public boolean addItem(String dataItem) {
        return this.data.add(dataItem);
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
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