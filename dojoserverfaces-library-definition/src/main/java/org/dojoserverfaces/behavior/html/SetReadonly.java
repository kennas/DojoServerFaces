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
import org.dojoserverfaces.widget.DojoWidget;

/**
 * This client side behavior will allow you to set the readonly attribute of an
 * element.
 */
@Behavior
public class SetReadonly extends BehaviorBase {

    public SetReadonly() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != target) {
            UIComponent targetComp = behaviorContext.getComponent()
                    .findComponent(target);
            if (targetComp != null && targetComp instanceof DojoWidget) {
                appendSetDijitAttr(script, targetComp.getClientId(),
                        "readOnly", value.toString());
            }
            else {
                if (targetComp == null) {
                    logComponentNotFound(target);
                }
                else {
                    target = targetComp.getClientId();
                }
                // note no camel case attr
                appendSetElementAttr(script, target, "readonly",
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
    @Attribute
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * a boolean value: <code>true</code> means readonly, <code>false</code>
     * means writable.
     */
    @Attribute
    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}