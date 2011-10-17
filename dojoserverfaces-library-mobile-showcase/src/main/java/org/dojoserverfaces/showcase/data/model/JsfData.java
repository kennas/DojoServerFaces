/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.data.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class JsfData {
    Date dt;
    Long tim;

    public Long getTim() {
        return tim;
    }

    public void setTim(Long tim) {
        this.tim = tim;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

}
