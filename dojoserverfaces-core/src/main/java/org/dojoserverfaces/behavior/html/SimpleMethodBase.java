/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.component.behavior.BehaviorBase;
import org.dojoserverfaces.widget.DojoWidget;

/**
 * This base class handles invoking a simple method on a targeted set of
 * components.
 */
public class SimpleMethodBase extends BehaviorBase {
    private String methodName = null;
    private boolean acceptsNonDijit = false;

    /**
     * @param methodName
     *            name of method to invoke as "method()"
     * @param acceptsNonDijit
     *            will apply to non dijit components
     */
    public SimpleMethodBase(String methodName, boolean acceptsNonDijit) {
        super();
        this.methodName = methodName;
        this.acceptsNonDijit = acceptsNonDijit;
    }

    /**
     * @param methodName
     *            name of method to invoke as "method()"
     */
    public SimpleMethodBase(String methodName) {
        this(methodName, false);
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        if (null != target) {
            UIComponent targetComp = behaviorContext.getComponent()
                    .findComponent(target);

            if (null != targetComp && targetComp instanceof DojoWidget) {
                // TODO: some dojo widget do not have a "hide" function,
                // need to check
                script.append("dijit.byId(");
                target = targetComp.getClientId();
            }
            else if (acceptsNonDijit) {
                if (targetComp == null) {
                    logComponentNotFound(target);
                }
                else {
                    target = targetComp.getClientId();
                }
                script.append("dojo.byId(");
            }
            else {
                logComponentNotFound(target);
                return null;
            }
            script.append('"').append(target).append("\").").append(methodName)
                    .append("(");
            appendParameterString(behaviorContext, script);
            script.append(");");
        }
        return script.toString();
    }

    /**
     * Append the parameters for the method. Default is to append no parameters.
     */
    protected void appendParameterString(ClientBehaviorContext behaviorContext,
            StringBuilder script) {
    }

    private String target = null;

    /**
     * component id to act on.
     */
    @Attribute
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

}