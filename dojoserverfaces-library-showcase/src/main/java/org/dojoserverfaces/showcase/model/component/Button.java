/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Button extends WigdetBase {
    private String label = "Click Me!";
    private Boolean showLabel = true;
    private String iconClass = "dijitEditorIcon dijitEditorIconCut";

    private final Map<String, String> iconClasses = new LinkedHashMap<String, String>();
    {
        iconClasses.put("", "");
        iconClasses.put("dijitEditorIconCut",
                "dijitEditorIcon dijitEditorIconCut");
        iconClasses.put("dijitEditorIconCopy",
                "dijitEditorIcon dijitEditorIconCopy");
        iconClasses.put("dijitEditorIconPaste",
                "dijitEditorIcon dijitEditorIconPaste");
        iconClasses.put("dijitCheckBoxIcon", "dijitCheckBoxIcon");
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getShowLabel() {
        return showLabel;
    }

    public void setShowLabel(Boolean showLabel) {
        this.showLabel = showLabel;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public Map<String, String> getIconClasses() {
        return iconClasses;
    }
}
