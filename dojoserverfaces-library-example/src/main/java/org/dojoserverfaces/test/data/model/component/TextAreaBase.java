package org.dojoserverfaces.test.data.model.component;


public class TextAreaBase extends InputBase {

	public Integer getMaxLength() {
		return (Integer) getAttribute("maxLength");
	}

	public void setMaxLength(Integer maxLength) {
		setAttribute("maxLength", maxLength);
	}

	public Boolean getTrim() {
		return (Boolean) getAttribute("trim");
	}

	public void setTrim(Boolean trim) {
		setAttribute("trim", trim);
	}

	public String getOnSelect() {
		return (String) getAttribute("onSelect");
	}

	public void setOnSelect(String onSelect) {
		setAttribute("onSelect", onSelect);
	}

	public Integer getCols() {
		return (Integer) getAttribute("cols");
	}

	public void setCols(Integer cols) {
		setAttribute("cols", cols);
	}

	public Boolean getSelectOnClick() {
		return (Boolean) getAttribute("selectOnClick");
	}

	public void setSelectOnClick(Boolean selectOnClick) {
		setAttribute("selectOnClick", selectOnClick);
	}

}
