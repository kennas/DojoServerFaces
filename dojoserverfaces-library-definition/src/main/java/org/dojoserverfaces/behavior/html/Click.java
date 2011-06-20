/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.component.behavior.BehaviorBase;

/**
 * This behavior will allow you to make an element disabled.
 */
@Behavior
public class Click extends BehaviorBase {

    public Click() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != target) {
            UIComponent targetComp = behaviorContext.getComponent()
                    .findComponent(target);

            String method = "onclick";
            script.append("var t=");
            if (targetComp != null) {
                method = "onClick";
                appendGetDijit(script, targetComp.getClientId());
            }
            else {
                logComponentNotFound(target);
                appendGetElement(script, target);
            }
            script.append(";t[\"").append(method).append("\"].call(t,event);");
        }
        return script.toString();
    }

    private String target;

    /**
     * component id or DOM element id of element
     */
    @Attribute(required = true)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}