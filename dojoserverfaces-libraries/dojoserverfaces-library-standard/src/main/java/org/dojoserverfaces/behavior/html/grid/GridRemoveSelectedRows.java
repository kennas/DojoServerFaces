/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html.grid;


import org.dojoserverfaces.build.annotation.Behavior;

/**
 * This behavior will allow you to remove the selected rows of a datagrid.
 */
@Behavior
public class GridRemoveSelectedRows extends SimpleGridOperationBase {
    public GridRemoveSelectedRows() {
        super("removeSelectedRows");
    }

}
