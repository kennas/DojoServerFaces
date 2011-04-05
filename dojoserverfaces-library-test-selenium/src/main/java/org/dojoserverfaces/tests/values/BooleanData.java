/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.values;

public class BooleanData {
    private Boolean data;

    public BooleanData() {
        //
    }

    public BooleanData(Boolean data) {
        this.data = data;
    }

    public BooleanData(Object data) {
        if (data instanceof Boolean)
            this.data = (Boolean) data;
    }

    public Boolean getData() {
        return data;
    }

    public void setData(Boolean data) {
        this.data = data;
    }
}