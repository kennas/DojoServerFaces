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
 * This behavior will allow to set the value an element on the client.
 * 
 */
@Behavior
public class Set extends BehaviorBase {

    public Set() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        if (null != target && null != value) {
            if (value.startsWith(PARAM_EVENT)) {
                // just pass through as is
                // TODO for dijit events should we handle conversion to getter
                // perhaps if property is not standard event property the make
                // getter
                // example the Calendar onValueChange sends a date as the event
                // object
                value = value.substring(1);
            }
            else {
                // assume first node is id of a component
                UIComponent component = null;
                int beginIndex = value.startsWith("@") ? 1 : 0;
                int endIndex = value.indexOf('.');
                if (value.startsWith(PARAM_THIS)) {
                    component = behaviorContext.getComponent();
                }
                else {
                    // TODO if there was a preceding @ we are skipping it,
                    // should we?
                    component = findComponent(
                            behaviorContext,
                            endIndex < 0 ? value.substring(beginIndex) : value
                                    .substring(beginIndex, endIndex));
                }
                if (null != component) {
                    StringBuilder valueScript = new StringBuilder();
                    appendGetElement(valueScript, component);
                    // TODO should we figure out when to convert to getXxxx()
                    valueScript.append(endIndex < 0 ? ".value" : value
                            .substring(endIndex));
                    value = valueScript.toString();
                }
                else {
                    // TODO hmmm, just use as is? report warning? throw
                    // exception?
                }
            }
            // assume first node of target is id of a component
            UIComponent component = null;
            int beginIndex = target.startsWith("@") ? 1 : 0;
            int endIndex = target.indexOf('.');
            if (target.startsWith(PARAM_THIS)) {
                component = behaviorContext.getComponent();
            }
            else {
                // TODO if there was a preceding @ we are skipping it, should
                // we?
                component = findComponent(
                        behaviorContext,
                        endIndex < 0 ? target.substring(beginIndex) : target
                                .substring(beginIndex, endIndex));
            }
            if (null != component) {
                StringBuilder script = new StringBuilder(
                        "console.log('set called');");
                appendGetElement(script, component);
                // TODO should we figure out when to convert to setXxxx()
                if (component instanceof DojoWidget) {
                    if (endIndex < 0) {
                        script.append(".set('value',");
                    }
                    else {
                        // TODO assuming only one node deep
                        script.append(".set('")
                                .append(target.substring(endIndex + 1))
                                .append("',");
                    }
                    script.append(value).append(");");
                }
                else {
                    if (endIndex < 0) {
                        script.append(".value=");
                    }
                    else {
                        // TODO assuming only one node deep
                        script.append(target.substring(endIndex)).append('=');
                    }
                    script.append(value).append(";");
                }
                return script.append("return true;").toString();
            }
            else {
                // TODO we should log some error i think
                return target;
            }
        }
        // TODO throw exception
        return null;
    }

    private String value = null;
    private String target = null;

    /**
     * component id of element to set on client or dom element id
     */
    @Attribute
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * component id of element for which to extract a value or a client side
     * expression
     */
    @Attribute
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}