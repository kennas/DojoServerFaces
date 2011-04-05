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
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.DojoWidget;

/**
 * This behavior will allow you to set a value of a component
 */
@Behavior
public class SetValue extends BehaviorBase {

    private static final String VALUE_ATTR = "value";

    public SetValue() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != target) {
            UIComponent targetComp = behaviorContext.getComponent()
                    .findComponent(target);
            if (targetComp == null) {
                logComponentNotFound(target);
                return script.toString();
            }
            // TODO: re-think using makeStringVar
            if (targetComp instanceof DojoWidget) {
                appendSetDijitAttr(script, targetComp.getClientId(),
                        VALUE_ATTR, Helper.makeStringVar(value));
//                script.append("dijit.byId('").append(targetComp.getClientId())
//                        .append("').set(").append(Helper.quote(VALUE_ATTR))
//                        .append(",").append(Helper.makeStringVar(value))
//                        .append(")");
            } else {
                appendSetElementAttr(script, targetComp.getClientId(),
                        VALUE_ATTR, Helper.makeStringVar(value));
            }
            script.append(";");
        }
        return script.toString();
    }

    private String target;

    private String value;

    /**
     * component id of element to set on client or dom element id
     */
    @Attribute(required = true)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * client side expression
     */
    @Attribute(required = true)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}