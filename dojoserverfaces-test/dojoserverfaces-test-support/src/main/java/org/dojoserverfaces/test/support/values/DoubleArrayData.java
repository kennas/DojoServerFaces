/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.values;

public class DoubleArrayData {
    private Double[] data;

    public DoubleArrayData() {
        //
    }

    public DoubleArrayData(Double[] data) {
        this.data = data;
    }

    public DoubleArrayData(Double dataItem) {
        Double[] arr = new Double[3];
        arr[0] = dataItem;
        this.data = arr;
    }

    public Double[] getData() {
        return data;
    }

    public void setData(Double[] data) {
        this.data = data;
    }

    public String getDataValues() {
        if (this.data != null) {
            StringBuilder str = new StringBuilder("");
            for (Double item : data) {
                str.append(item).append(" ");
            }
            return str.toString().trim();
        }
        return "";
    }
}