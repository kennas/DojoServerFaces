package org.dojoserverfaces.test.data.model.component;

import javax.faces.bean.ManagedBean;


/**
 * A simple multi-line text input area.
 *
 */
@ManagedBean
public class TextArea extends TextAreaBase {

	public Integer getRows() {
		return (Integer) getAttribute("rows");
	}

	public void setRows(Integer rows) {
		setAttribute("rows", rows);
	}
}
