/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.values;

public class DoubleData {
    private Double data;

    public DoubleData() {
        //
    }

    public DoubleData(Double data) {
        this.data = data;
    }

    public DoubleData(Object data) {
        if (data instanceof Double)
            this.data = (Double) data;
    }

    public Double getData() {
        return data;
    }

    public void setData(Double data) {
        this.data = data;
    }
}