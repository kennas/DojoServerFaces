/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CurrencyTextBox extends NumberInputBase {
	private String currency = "USD";
	private String symbol = "$";
	private String placeHolder = "Input an amount";
	private String rangeMessage = "Out of range";
	private String pattern = "¤ #,##0.##";

	private String places = "2";

	private Boolean selectOnClick = true;
	private Boolean trim = true;
	private Boolean required = true;

	private Double min = 0D;
	private Double max = 100000D;

	private Double amount = 1999.88D;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPlaceHolder() {
		return placeHolder;
	}

	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}

	public String getRangeMessage() {
		return rangeMessage;
	}

	public void setRangeMessage(String rangeMessage) {
		this.rangeMessage = rangeMessage;
	}

	public String getPlaces() {
		return places;
	}

	public void setPlaces(String places) {
		this.places = places;
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
}
