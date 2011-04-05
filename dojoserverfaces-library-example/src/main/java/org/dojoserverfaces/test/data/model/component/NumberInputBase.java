package org.dojoserverfaces.test.data.model.component;


public class NumberInputBase extends TextBoxBase {

    public String getRangeMessage() {
		return (String) getAttribute("rangeMessage");
	}

	public void setRangeMessage(String rangeMessage) {
		setAttribute("rangeMessage", rangeMessage);
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

	public String getPlaces() {
		return (String) getAttribute("places");
	}

	public void setPlaces(String places) {
		setAttribute("places", places);
	}

	public Boolean getStrict() {
		return (Boolean) getAttribute("strict");
	}

	public void setStrict(Boolean strict) {
		setAttribute("strict", strict);
	}

	public String getType() {
		return (String) getAttribute("type");
	}

	public void setType(String type) {
		setAttribute("type", type);
	}

}
