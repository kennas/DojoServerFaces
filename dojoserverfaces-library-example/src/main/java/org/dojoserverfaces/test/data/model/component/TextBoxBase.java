package org.dojoserverfaces.test.data.model.component;

public abstract class TextBoxBase extends InputBase {
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

	public String getPlaceHolder() {
		return (String) getAttribute("placeHolder");
	}

	public void setPlaceHolder(String placeHolder) {
		setAttribute("placeHolder", placeHolder);
	}

	public Boolean getSelectOnClick() {
		return (Boolean) getAttribute("selectOnClick");
	}

	public void setSelectOnClick(Boolean selectOnClick) {
		setAttribute("selectOnClick", selectOnClick);
	}

	public String getOnSelect() {
		return (String) getAttribute("onSelect");
	}

	public void setOnSelect(String onSelect) {
		setAttribute("onSelect", onSelect);
	}

}
