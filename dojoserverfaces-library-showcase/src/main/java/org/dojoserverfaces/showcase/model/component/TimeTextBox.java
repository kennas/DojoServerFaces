/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import java.text.DateFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TimeTextBox extends TextBoxBase {
	private String am;
	private String pm;
	private String locale;
	private String pattern = "HH:mm:ss";
	private String placeHolder = "Select a time";
	private String clickableIncrement = "T00:10:00";
	private String visibleIncrement = "T00:30:00";
	private String visibleRange = "T02:00:00";

	private Boolean selectOnClick = true;
	private Boolean required = true;

	private String timeValue = Long.toString((18 * 3600 + 30 * 60 + 30) * 1000);

	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getClickableIncrement() {
		return clickableIncrement;
	}

	public void setClickableIncrement(String clickableIncrement) {
		this.clickableIncrement = clickableIncrement;
	}

	public String getVisibleIncrement() {
		return visibleIncrement;
	}

	public void setVisibleIncrement(String visibleIncrement) {
		this.visibleIncrement = visibleIncrement;
	}

	public String getVisibleRange() {
		return visibleRange;
	}

	public void setVisibleRange(String visibleRange) {
		this.visibleRange = visibleRange;
	}

	public String getTimeValue() {
		return timeValue;
	}

	public void setTimeValue(String timeValue) {
		this.timeValue = timeValue;
	}

	public static final DateFormat DF = DateFormat.getTimeInstance();

	public String getFormattedTime() {
		long timeInSeconds = Long.valueOf(this.timeValue) / 1000;
		long s = timeInSeconds % 60;
		long m = (timeInSeconds / 60) % 60;
		long h = (timeInSeconds / 3600) % 24;

		StringBuilder formattedTime = new StringBuilder();
		if (h < 10)
			formattedTime.append("0");
		formattedTime.append(h).append(":");
		if (m < 10)
			formattedTime.append("0");
		formattedTime.append(m).append(":");
		if (s < 10)
			formattedTime.append("0");
		formattedTime.append(s);

		return formattedTime.toString();
	}

	public String getPlaceHolder() {
		return placeHolder;
	}

	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}

	public Boolean getSelectOnClick() {
		return selectOnClick;
	}

	public void setSelectOnClick(Boolean selectOnClick) {
		this.selectOnClick = selectOnClick;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}
}
