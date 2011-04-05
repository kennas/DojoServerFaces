/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html.grid;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;

/**
 * This behavior will allow you to make a row the top row of a datagrid.
 */

public class GridScrollToRow extends SimpleGridOperationBase {
	public GridScrollToRow() {
		super("scrollToRow");
	}

	@Override
	protected void appendParameterString(ClientBehaviorContext behaviorContext,StringBuilder sb) {
		sb.append(rowIndex);
	}

	/**
	 * New top row for the datagrid.
	 * 
	 */
	@Attribute(required = true)
	public String getRowIndex() {
		return rowIndex;
	}

	/**
	 * Setter for rowIndex.
	 */
	public void setRowIndex(String rowIndexValue) {
		this.rowIndex = rowIndexValue;
	}

	private String rowIndex;
}
