package org.dojoserverfaces.test.data.model.component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TextBox extends TextBoxBase {
	public String getForceCase() {
		Object value = getAttribute("forceCase");
		return (String) value;
	}

	public void setForceCase(String forceCase) {
		setAttribute("forceCase", forceCase);
	}
}
