/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.values;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateData {
    private Date data;
    DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

    public DateData() {
        //
    }

    public DateData(Object data) {
        if (data instanceof Date)
            this.data = (Date) data;
    }

    /**
     * @param data
     *            - Date data in a format yyyy-mm-dd
     */
    public DateData(String data) {
        try {
            this.data = (Date) formatter.parse(data);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}