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
 * This behavior will allow you to set the css "display" value of an element
 */
public abstract class SetStyleBase extends BehaviorBase {

    private String style = null;

    public SetStyleBase(String style) {
        super();
        this.style = style;
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != target) {
            UIComponent targetComp = behaviorContext.getComponent()
                    .findComponent(target);
            // if target could not be found, assume it is a plain DOM
            // node
            if (targetComp == null) {
                logComponentNotFound(target);
                appendGetElement(script, target);
            }
            else {
                if (targetComp instanceof DojoWidget) {
                    appendGetDijit(script, targetComp.getClientId()).append(
                            ".domNode");
                }
                else {
                    appendGetElement(script, targetComp.getClientId());
                }
            }
            script.append(".style.").append(style).append("='").append(value)
                    .append("';");
        }
        return script.toString();
    }

    private String value;

    /**
     * Style value
     */
    protected String getValueString() {
        return value;
    }

    protected void setValue(String string) {
        this.value = string;
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