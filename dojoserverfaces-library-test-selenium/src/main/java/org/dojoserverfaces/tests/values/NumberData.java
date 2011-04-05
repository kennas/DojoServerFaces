/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.values;

public class NumberData {
    private Number data;

    public NumberData() {
        //
    }

    public NumberData(Number data) {
        this.data = data;
    }

    public NumberData(Object data) {
        if (data instanceof Number)
            this.data = (Number) data;
    }

    public Number getData() {
        return data;
    }

    public void setData(Number data) {
        this.data = data;
    }
}