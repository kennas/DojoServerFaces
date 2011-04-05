/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class VerticalRule extends HorizontalRule {
    String ruleStyle = "width:7px;";
    String container = "rightDecoration";

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getRuleStyle() {
        return ruleStyle;
    }

    public void setRuleStyle(String ruleStyle) {
        this.ruleStyle = ruleStyle;
    }
}
