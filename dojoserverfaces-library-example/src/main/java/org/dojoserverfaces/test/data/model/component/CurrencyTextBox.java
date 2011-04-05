package org.dojoserverfaces.test.data.model.component;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CurrencyTextBox extends NumberInputBase {
	public String getCurrency() {
		return (String) getAttribute("currency");
	}

	public void setCurrency(String currency) {
		setAttribute("currency", currency);
	}

	public String getSymbol() {
		return (String) getAttribute("symbol");
	}

	public void setSymbol(String symbol) {
		setAttribute("symbol", symbol);
	}

	public Boolean getFractional() {
		return (Boolean) getAttribute("fractional");
	}

	public void setFractional(Boolean fractional) {
		setAttribute("fractional", fractional);
	} 
}
