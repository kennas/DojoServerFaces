/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html.grid;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Behavior;

/**
 * This behavior will allow you to select all the rows of a datagrid.
 */
@Behavior
public class GridSelectAll extends SimpleGridOperationBase {
    public GridSelectAll() {
        super("selection", "selectRange");
    }

    @Override
    protected void appendParameterString(ClientBehaviorContext behaviorContext,
            StringBuilder sb) {
        sb.append("0,");
        appendGetDijit(sb, getClientId(getTarget(), behaviorContext));
        sb.append(".rowCount");
    }
}
