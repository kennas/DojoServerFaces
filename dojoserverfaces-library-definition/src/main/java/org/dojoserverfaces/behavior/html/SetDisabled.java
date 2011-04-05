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
public class SetDisabled extends BehaviorBase {

    public SetDisabled() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != target) {
            UIComponent targetComp = behaviorContext.getComponent()
                    .findComponent(target);

            if (targetComp != null) {
                appendSetElementAttr(script, targetComp, "disabled",
                        value.toString());
            }
            else {
                logComponentNotFound(target);
                appendSetElementAttr(script, target, "disabled",
                        value.toString());
            }
        }
        return script.toString();
    }

    private String target;

    private Boolean value = false;

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

    /**
     * a boolean value: <code>true</code> means disabled, <code>false</code>
     * means enabled
     */
    @Attribute(required = true)
    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}