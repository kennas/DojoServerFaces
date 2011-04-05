/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Select extends SelectStoreBase {
    private final Map<String, String> jsFrameworks = new HashMap();
    {
        jsFrameworks.put("", "");
        jsFrameworks.put("Dojo", "Dojo");
        jsFrameworks.put("jQuery", "jQuery");
        jsFrameworks.put("Prototype", "Prototype");
    }

    private String favouriteFwk;

    public Map<String, String> getJsFrameworks() {
        return jsFrameworks;
    }

    public String getFavouriteFwk() {
        return favouriteFwk;
    }

    public void setFavouriteFwk(String favouriteFwk) {
        this.favouriteFwk = favouriteFwk;
    }
}
