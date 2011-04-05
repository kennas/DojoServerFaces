package org.dojoserverfaces.test.data.model.component;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class DateTextBox extends TextBoxBase {
    public String getAm() {
		return (String) getAttribute("am");
	}

	public void setAm(String am) {
		setAttribute("am", am);
	}

	public String getPm() {
		return (String) getAttribute("pm");
	}

	public void setPm(String pm) {
		setAttribute("pm", pm);
	}

	public String getPattern() {
		return (String) getAttribute("pattern");
	}

	public void setPattern(String pattern) {
		setAttribute("pattern", pattern);
	}

	public String getFormatLength() {
		return (String) getAttribute("formatLength");
	}

	public void setFormatLength(String formatLength) {
		setAttribute("formatLength", formatLength);
	}

	public String getLocale() {
		return (String) getAttribute("locale");
	}

	public void setLocale(String locale) {
		setAttribute("locale", locale);
	}

	public String getSelector() {
		return (String) getAttribute("selector");
	}

	public void setSelector(String selector) {
		setAttribute("selector", selector);
	}

	public Boolean getStrict() {
		return (Boolean) getAttribute("strict");
	}

	public void setStrict(Boolean strict) {
		setAttribute("strict", strict);
	}

}