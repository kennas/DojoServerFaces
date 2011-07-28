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

/**
 * This behavior will allow you to toggle any property between its initial value
 * and a given value.
 */
@Behavior
public class ToggleProperty extends BehaviorBase {

    public ToggleProperty() {
        super();
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();

        UIComponent targetComp = null;
        if (PARAM_THIS.equals(target)) {
            targetComp = behaviorContext.getComponent();
        }
        else {
            targetComp = behaviorContext.getComponent().findComponent(target);
        }

        if (targetComp != null) {
            script.append("if(").append(Helper.makeStringVar(compareValue))
                    .append("===");
            appendGetElementAttr(script, targetComp, name);
            script.append("){");
            appendSetElementAttr(script, targetComp, name,
                    Helper.makeStringVar(initialValue));
            script.append("}else{");
            appendSetElementAttr(script, targetComp, name,
                    Helper.makeStringVar(compareValue));
            script.append("}");
        }
        else {
            logComponentNotFound(target);
            // TODO: need to support plain dom node? How to get its initial
            // value?
        }
        return script.toString();
    }

    private String target;

    private String name;

    private String initialValue;

    private String compareValue;

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
     * if the current value of the property equals to compareValue then set to
     * initialValue
     */
    @Attribute(required = true)
    public String getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(String initialValue) {
        this.initialValue = initialValue;
    }

    /**
     * target component's attribute name
     */
    @Attribute(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * a value used to compare with the current value of the property, if equals
     * then set to initialValue else set to compareValue
     */
    @Attribute(required = true)
    public String getCompareValue() {
        return compareValue;
    }

    public void setCompareValue(String compareValue) {
        this.compareValue = compareValue;
    }
}