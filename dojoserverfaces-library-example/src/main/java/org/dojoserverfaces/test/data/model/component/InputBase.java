package org.dojoserverfaces.test.data.model.component;

public abstract class InputBase extends HTMLOutput {

    public String getOnBlur() {
		return (String) getAttribute("onBlur");
	}

	public void setOnBlur(String onBlur) {
		setAttribute("onBlur", onBlur);
	}

	public String getOnFocus() {
		return (String) getAttribute("onFocus");
	}

	public void setOnFocus(String onFocus) {
		setAttribute("onFocus", onFocus);
	}

	public String getOnChange() {
		return (String) getAttribute("onChange");
	}

	public void setOnChange(String onChange) {
		setAttribute("onChange", onChange);
	}

	public Boolean getDisabled() {
		return (Boolean) getAttribute("disabled");
	}

	public void setDisabled(Boolean disabled) {
		setAttribute("disabled", disabled);
	}

	public Boolean getReadOnly() {
		return (Boolean) getAttribute("readOnly");
	}

	public void setReadOnly(Boolean readOnly) {
		setAttribute("readOnly", readOnly);
	}

	public Integer getTabIndex() {
		return (Integer) getAttribute("tabIndex");
	}

	public void setTabIndex(Integer tabIndex) {
		setAttribute("tabIndex", tabIndex);
	}
	public void setRequired(Boolean required) {
		setAttribute("required", required);
	}

	public Boolean getRequired() {
		return (Boolean) getAttribute("required");
	}
}
