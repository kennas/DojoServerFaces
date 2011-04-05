/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.locale;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "language")
@SessionScoped
public class LocaleBean {

    private String locale;
    private Map<String, Object> countryMap;

    public LocaleBean() {
        countryMap = new LinkedHashMap<String, Object>();
        countryMap.put("English", new Locale("en"));
        countryMap.put("French", new Locale("fr", "FR"));
    }

    public Map<String, Object> getCountries() {
        return countryMap;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void localeChanged(ValueChangeEvent e) {

        String localeStr = e.getNewValue().toString();

        for (Map.Entry<String, Object> entry : countryMap.entrySet()) {
            if (entry.getValue().toString().equals(localeStr)) {
                Locale locale = (Locale) entry.getValue();
                FacesContext.getCurrentInstance().getViewRoot().setLocale(
                        locale);
            }
        }
    }
}