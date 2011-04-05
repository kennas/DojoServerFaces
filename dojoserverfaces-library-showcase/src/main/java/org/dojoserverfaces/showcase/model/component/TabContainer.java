/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TabContainer extends StackContainer {
    private String tabPosition = "top";
    private Boolean useSlider;
    private Boolean useMenu;
    private Boolean tabStrip;
    private Boolean nested;

    public Boolean getNested() {
        return nested;
    }

    public void setNested(Boolean nested) {
        this.nested = nested;
    }

    public String getTabPosition() {
        return tabPosition;
    }

    public void setTabPosition(String tabPosition) {
        this.tabPosition = tabPosition;
    }

    public Boolean getUseSlider() {
        return useSlider;
    }

    public void setUseSlider(Boolean useSlider) {
        this.useSlider = useSlider;
    }

    public Boolean getUseMenu() {
        return useMenu;
    }

    public void setUseMenu(Boolean useMenu) {
        this.useMenu = useMenu;
    }

    public Boolean getTabStrip() {
        return tabStrip;
    }

    public void setTabStrip(Boolean tabStrip) {
        this.tabStrip = tabStrip;
    }
}
