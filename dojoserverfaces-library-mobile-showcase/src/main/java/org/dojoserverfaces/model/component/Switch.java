/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.model.component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "switchComp")
@SessionScoped
public class Switch extends WigdetBase {
    private Double volume = 0.6;
    private String changeWithButtons = "on";
    private String wifi = "off";
    private String enable3G = "on";
    private String cellularData = "off";

    public String getChangeWithButtons() {
        return changeWithButtons;
    }

    public void setChangeWithButtons(String changeWithButtons) {
        this.changeWithButtons = changeWithButtons;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getEnable3G() {
        return enable3G;
    }

    public void setEnable3G(String enable3g) {
        enable3G = enable3g;
    }

    public String getCellularData() {
        return cellularData;
    }

    public void setCellularData(String cellularData) {
        this.cellularData = cellularData;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public int getDisplayedVolume() {
        return (int) Math.round(volume * 100);
    }
}
