/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.library.test.data.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DateTextBox {
    private Date date = new Date(1263945600000L);

    private static final DateFormat DF = new SimpleDateFormat(
            "MM/dd/yyyy HH:mm:ss z");
    static {
        DF.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        System.out.println("[DateTextBox.setDate]: date=" + DF.format(date)
                + ", time=" + date.getTime());
        this.date = date;
    }
}
