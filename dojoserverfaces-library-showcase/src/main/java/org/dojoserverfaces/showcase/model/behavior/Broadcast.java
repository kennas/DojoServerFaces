/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.behavior;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Broadcast {
    private static final String[] COLORS = { "red", "orange", "green", "blue",
            "indigo", "purple" };

    private int buttonTextColorIdx;
    private int currentBgColorIdx;

    public String getButtonTextColor() {
        buttonTextColorIdx = getNextColorIndex(buttonTextColorIdx);
        return COLORS[buttonTextColorIdx];
    }

    public String getTextBoxColor() {
        return COLORS[buttonTextColorIdx];
    }

    public String getBgColor() {
        currentBgColorIdx = getNextColorIndex(currentBgColorIdx);
        return COLORS[currentBgColorIdx];
    }

    private int getNextColorIndex(int except) {
        int idx = (int) (Math.random() * COLORS.length);
        while (idx == except) {
            idx = (int) (Math.random() * COLORS.length);
        }
        return idx;
    }
}
