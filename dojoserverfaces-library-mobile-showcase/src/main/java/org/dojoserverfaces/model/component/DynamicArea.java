package org.dojoserverfaces.model.component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DynamicArea {
    String value = "Try to enter some text, \nI will expand automatically with input.";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
