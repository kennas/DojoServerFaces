package org.dojoserverfaces.test.data.model.component;

import javax.faces.bean.ManagedBean;


/**
 * 
A select field component where the possible options will be narrowed by the user typing in the field.
The options for this select field are defined using the <f:selectItem> and <f:selectItems> tags.

<pre>
<code>
  <dojo:filteringSelect value="#{store.record.state}" >
    <f:selectItems value="#{store.states}"/>
  </dojo:filteringSelect>
</code
</pre>
 *
 */
@ManagedBean
public class FilteringSelect extends SelectStoreBase {
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

}
