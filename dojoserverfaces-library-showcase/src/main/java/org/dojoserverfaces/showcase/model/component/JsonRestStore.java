package org.dojoserverfaces.showcase.model.component;


import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
@ManagedBean
public class JsonRestStore {
    private String target=new StringBuilder()
    .append(((ServletContext) FacesContext.getCurrentInstance()
            .getExternalContext().getContext()).getContextPath())
    .append("/rest/datastore/countries/").toString();;

    public String getTarget() {
       
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

 
}
