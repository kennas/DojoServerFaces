package org.dojoserverfaces.tests.behavior.updateprogressbar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

@ManagedBean(name = "updateProgressBarBean")
@SessionScoped
public class UpdateProgressBarBean {

    private String maximum;
    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    private String url = new StringBuilder()
    .append(((ServletContext) FacesContext.getCurrentInstance()
            .getExternalContext().getContext()).getContextPath())
    .append("/rest/progress/value").toString();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    };
}
