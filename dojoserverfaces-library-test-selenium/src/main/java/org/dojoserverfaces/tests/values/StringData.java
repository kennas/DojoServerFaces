/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.values;

public class StringData {
    private String data;

    public StringData() {
        //
    }

    public StringData(String data) {
        this.data = data;
    }

    public StringData(Object data) {
        if (data instanceof String)
            this.data = (String) data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}