/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NumberTextBox extends NumberInputBase {
	private String type = "decimal";
	private Double min = 0D;
	private Double max = 10000D;
	private String places = "2";
	private String pattern = "#,##0.##";

	private Boolean selectOnClick = true;
	private Boolean trim = true;
	private Boolean required = true;

	private String placeHolder = "Numbers between (" + min + ", " + max + ")";
	private String rangeMessage = "Out of range";

	private Double value = 2010.88;

	private final Map<String, String> showcaseTypes = new HashMap<String, String>();
	{
		showcaseTypes.put("decimal", "decimal");
		// showcaseTypes.put("percent", "percent");
		// showcaseTypes.put("currency", "currency");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public String getPlaces() {
		return places;
	}

	public void setPlaces(String places) {
		this.places = places;
	}

	public String getPlaceHolder() {
		return placeHolder;
	}

	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getRangeMessage() {
		return rangeMessage;
	}

	public void setRangeMessage(String rangeMessage) {
		this.rangeMessage = rangeMessage;
	}

	public Boolean getSelectOnClick() {
		return selectOnClick;
	}

	public void setSelectOnClick(Boolean selectOnClick) {
		this.selectOnClick = selectOnClick;
	}

	public Boolean getTrim() {
		return trim;
	}

	public void setTrim(Boolean trim) {
		this.trim = trim;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Map<String, String> getShowcaseTypes() {
		return showcaseTypes;
	}
}
