/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Editor {
	Boolean inheritWidth;
	String name;
	String styleSheets;
	String height;
	String minHeight;
	Boolean isTabIndent;
	Boolean disableSpellCheck;
	Object plugins = "cut copy paste bold italic underline strikethrough";

	public Boolean getInheritWidth() {
		return inheritWidth;
	}

	public void setInheritWidth(Boolean inheritWidth) {
		this.inheritWidth = inheritWidth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyleSheets() {
		return styleSheets;
	}

	public void setStyleSheets(String styleSheets) {
		this.styleSheets = styleSheets;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(String minHeight) {
		this.minHeight = minHeight;
	}

	public Boolean getIsTabIndent() {
		return isTabIndent;
	}

	public void setIsTabIndent(Boolean isTabIndent) {
		this.isTabIndent = isTabIndent;
	}

	public Boolean getDisableSpellCheck() {
		return disableSpellCheck;
	}

	public void setDisableSpellCheck(Boolean disableSpellCheck) {
		this.disableSpellCheck = disableSpellCheck;
	}

	public Object getPlugins() {
		return plugins;
	}

	public void setPlugins(Object plugins) {
		this.plugins = plugins;
	}

	public Boolean getCustomUndo() {
		return customUndo;
	}

	public void setCustomUndo(Boolean customUndo) {
		this.customUndo = customUndo;
	}

	public Integer getEditActionInterval() {
		return editActionInterval;
	}

	public void setEditActionInterval(Integer editActionInterval) {
		this.editActionInterval = editActionInterval;
	}

	Boolean customUndo;
	Integer editActionInterval;
}
