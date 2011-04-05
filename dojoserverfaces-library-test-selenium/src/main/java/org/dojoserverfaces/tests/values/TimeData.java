/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.values;

public class TimeData {
    private Long data;

    public TimeData() {
        //
    }

    public TimeData(Long data) {
        this.data = data;
    }

    public TimeData(Object data) {
        if (data instanceof Long)
            this.data = (Long) data;
    }

    public TimeData(String data) {
        try {
            this.data = Long.valueOf(data);
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }
}