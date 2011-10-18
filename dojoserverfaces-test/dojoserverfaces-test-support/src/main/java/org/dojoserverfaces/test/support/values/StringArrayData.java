/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.values;

public class StringArrayData {
    private String[] data;

    public StringArrayData() {
        //
    }

    public StringArrayData(String[] data) {
        this.data = data;
    }

    public StringArrayData(String dataItem) {
        String[] arr = { dataItem };
        this.data = arr;
    }

    public StringArrayData(Object[] data) {
        if (data != null) {
            this.data = new String[data.length];
            for (int i = 0; i < data.length; i++) {
                if (data[i] instanceof String)
                    this.data[i] = (String) data[i];
            }
        }
    }

    public StringArrayData(Object dataItem) {
        if (dataItem instanceof String) {
            String[] arr = { (String) dataItem };
            this.data = arr;
        }
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
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