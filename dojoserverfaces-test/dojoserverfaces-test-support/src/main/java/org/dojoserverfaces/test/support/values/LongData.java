/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.values;

public class LongData {
    private Long data;

    public LongData() {
        //
    }

    public LongData(Long data) {
        this.data = data;
    }

    public LongData(Object data) {
        if (data instanceof Long)
            this.data = (Long) data;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }
}