/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.behavior.html.grid;

import org.dojoserverfaces.build.annotation.Behavior;

/**
 * This behavior will allow for filtering the content of a datagrid. You
 * identify the fields to filter on and the components from which to retrieve
 * filer values which can contain wildcards (e.g. "*").
 * 
 */
@Behavior
public class GridFilter extends GridDataBehaviorBase {
	public GridFilter() {
		super("filter");
	}
}
