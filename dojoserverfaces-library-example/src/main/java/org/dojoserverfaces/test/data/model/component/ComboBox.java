package org.dojoserverfaces.test.data.model.component;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ComboBox extends TextBoxBase {

    public Boolean getAutoComplete() {
		return (Boolean) getAttribute("autoComplete");
	}

	public void setAutoComplete(Boolean autoComplete) {
		setAttribute("autoComplete", autoComplete);
	}

	public String getHighlightMatch() {
		return (String) getAttribute("highlightMatch");
	}

	public void setHighlightMatch(String highlightMatch) {
		setAttribute("highlightMatch", highlightMatch);
	}

	public Boolean getIgnoreCase() {
		return (Boolean) getAttribute("ignoreCase");
	}

	public void setIgnoreCase(Boolean ignoreCase) {
		setAttribute("ignoreCase", ignoreCase);
	}

	public Boolean getHasDownArrow() {
		return (Boolean) getAttribute("hasDownArrow");
	}

	public void setHasDownArrow(Boolean hasDownArrow) {
		setAttribute("hasDownArrow", hasDownArrow);
	}

	public Integer getSearchDelay() {
		return (Integer) getAttribute("searchDelay");
	}

	public void setSearchDelay(Integer searchDelay) {
		setAttribute("searchDelay", searchDelay);
	}
}