/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html.grid;

import org.dojoserverfaces.build.annotation.Behavior;

/**
 * This behavior will allow you to add a new row to a datagrid. You identify the
 * fields to set and the components from which to retrieve their initial values.
 * 
 */
@Behavior
public class GridAddRow extends GridDataBehaviorBase {
	public GridAddRow() {
		super("store", "newItem");
	}
}
