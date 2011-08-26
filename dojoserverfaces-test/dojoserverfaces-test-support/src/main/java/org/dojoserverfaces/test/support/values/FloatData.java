/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.values;

public class FloatData {
    private Float data;

    public FloatData() {
        //
    }

    public FloatData(Float data) {
        this.data = data;
    }

    public FloatData(Object data) {
        if (data instanceof Float)
            this.data = (Float) data;
    }

    public Float getData() {
        return data;
    }

    public void setData(Float data) {
        this.data = data;
    }
}