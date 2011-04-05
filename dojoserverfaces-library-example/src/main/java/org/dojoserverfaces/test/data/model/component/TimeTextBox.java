package org.dojoserverfaces.test.data.model.component;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TimeTextBox extends TextBoxBase {
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

	public String getLocale() {
		return (String) getAttribute("locale");
	}

	public void setLocale(String locale) {
		setAttribute("locale", locale);
	}

	public String getPattern() {
		return (String) getAttribute("pattern");
	}

	public void setPattern(String pattern) {
		setAttribute("pattern", pattern);
	}

	public String getClickableIncrement() {
		return (String) getAttribute("clickableIncrement");
	}

	public void setClickableIncrement(String clickableIncrement) {
		setAttribute("clickableIncrement", clickableIncrement);
	}

	public String getVisibleIncrement() {
		return (String) getAttribute("visibleIncrement");
	}

	public void setVisibleIncrement(String visibleIncrement) {
		setAttribute("visibleIncrement", visibleIncrement);
	}

	public String getVisibleRange() {
		return (String) getAttribute("visibleRange");
	}

	public void setVisibleRange(String visibleRange) {
		setAttribute("visibleRange", visibleRange);
	}
}
