/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;

/**
 * 
 * 
 */
@Container(dojoType = "dojox.highlight.Code")
class SyntaxHighlight extends WidgetBase {
	/*
	 * TODO - 
	 * maybe we should emit <code> ... </code> 
	 * setting lang should add a dojo.require, e.g. lang="html" then
	 * dojo.require("dojox.highlight.languages.html")
	 */

	/**
	 * Code language: xml, js ...
	 */
	@Property
	String lang;

}