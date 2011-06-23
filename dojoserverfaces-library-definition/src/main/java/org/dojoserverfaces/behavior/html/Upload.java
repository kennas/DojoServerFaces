/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.util.Helper;

/**
 * This behavior will allow you the invoke upload method of dojox.form.Uploader.
 */
@Behavior
public class Upload extends SimpleMethodBase {

    public Upload() {
        super("upload");
    }

    @Override
    protected void appendParameterString(ClientBehaviorContext behaviorContext,
            StringBuilder script) {
        String params = getParams();
        if (params != null) {
            script.append("{");
            String[] splited = params.split(",");
            boolean addComma = false;
            for (String param : splited) {
                UIComponent comp = behaviorContext.getComponent()
                        .findComponent(param);
                if (comp != null && comp instanceof ValueHolder) {
                    if (addComma) {
                        script.append(",");
                    }
                    addComma = true;
                    script.append(comp.getClientId())
                            .append(":")
                            .append(Helper.quote(((ValueHolder) comp)
                                    .getValue().toString()));
                }
            }
            script.append("}");
        }
    }

    /**
     * extra params to post to server
     */
    private String params;

    @Attribute
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

}