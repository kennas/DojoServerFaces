package org.dojoserverfaces.test.data.model.component;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ComponentTest implements Serializable {
	private static final long serialVersionUID = 1972393608194249102L;
	private Boolean enableAjax = Boolean.TRUE;

	public Boolean getEnableAjax() {
		return enableAjax;
	}

	public void setEnableAjax(Boolean enableAjax) {
		this.enableAjax = enableAjax;
	}
}
