/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html.grid;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.component.behavior.BehaviorBase;
import org.dojoserverfaces.widget.DojoWidget;

abstract class GridBehaviorBase extends BehaviorBase {
    protected GridBehaviorBase() {
        super();
    }

    private String target;

    /**
     * Id of a datagrid component to act on
     * 
     * 
     */
    @Attribute(required = true)
    public String getTarget() {
        return target;
    }

    /**
     * Setter for id of a datagrid component to act on
     * 
     * 
     */
    public void setTarget(String targetvalue) {
        this.target = targetvalue;
    }

    /**
     * 
     * @param sb
     * @param methodOwner
     * @param parameters
     * @param method
     * @return
     */
    protected StringBuilder appendMethodWithOwner(StringBuilder sb,
            String parameters, String methodOwner, String method) {
        appendGetDijit(sb, target);
        sb.append(".").append(methodOwner).append(".").append(method)
                .append("(").append(parameters).append(");");
        return sb;
    }

    /**
     * 
     * @param sb
     * @param parameters
     * @param method
     * @return
     */
    protected StringBuilder appendMethod(StringBuilder sb, String parameters,
            String method) {
        appendGetDijit(sb, target);
        sb.append(".").append(method).append("(").append(parameters)
                .append(");");
        return sb;
    }
/**
 * get the clientId of the component
 * @param id  the input client id
 * @param behaviorContext
 * @return
 */
    protected String getFullClientId(String id,ClientBehaviorContext behaviorContext) {
        if (null != id) {
            UIComponent targetComp = behaviorContext.getComponent()
                    .findComponent(id);
            if (null != targetComp && targetComp instanceof DojoWidget) {
                return targetComp.getClientId();
            }else
            {
                log("It is not a widget or");
                logComponentNotFound(id);
                return "";
            }
        }
        else {
            log("The input id is null");
            return null;
        }

      
    }
}