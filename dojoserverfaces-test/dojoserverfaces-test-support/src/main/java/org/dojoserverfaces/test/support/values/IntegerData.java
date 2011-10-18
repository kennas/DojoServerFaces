/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.values;

public class IntegerData {
    private Integer data;

    public IntegerData() {
        //
    }

    public IntegerData(Integer data) {
        this.data = data;
    }

    public IntegerData(Object data) {
        if (data instanceof Integer)
            this.data = (Integer) data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}