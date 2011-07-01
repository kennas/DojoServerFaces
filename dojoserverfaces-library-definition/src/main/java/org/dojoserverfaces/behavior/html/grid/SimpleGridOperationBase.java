/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html.grid;

import javax.faces.component.behavior.ClientBehaviorContext;

abstract class SimpleGridOperationBase extends GridBehaviorBase {
    private String operationTarget;
    private String methodName;

    protected SimpleGridOperationBase(String methodName) {
        this(null, methodName);
    }

    /**
     * 
     * @param operationTarget
     *            attribute of DataGrid like "store", "selection" etc. Could be
     *            <code>null</code> which means the DataGrid itself.
     * @param methodName
     *            name of method to invoke as "method()"
     */
    protected SimpleGridOperationBase(String operationTarget, String methodName) {
        this.operationTarget = operationTarget;
        this.methodName = methodName;
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder sb = new StringBuilder();

        appendGetDijit(sb, getClientId(getTarget(), behaviorContext));
        if (operationTarget != null) {
            sb.append(".").append(operationTarget);
        }
        sb.append(".").append(methodName).append("(");
        appendParameterString(behaviorContext, sb);
        sb.append(");");

        return sb.toString();
    }

    /**
     * Append the parameters for the method. Default is to append no parameters.
     */
    protected void appendParameterString(ClientBehaviorContext behaviorContext,
            StringBuilder script) {
    }
}
