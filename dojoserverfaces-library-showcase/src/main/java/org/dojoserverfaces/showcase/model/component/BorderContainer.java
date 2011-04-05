/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BorderContainer extends WigdetBase {
    private String design = "headline";
    private Boolean gutters = true;
    private Boolean liveSplitters = true;
    private Boolean persist = false;

    private final Map<String, String> designs = new LinkedHashMap<String, String>();
    {
        designs.put("headline", "headline");
        designs.put("sidebar", "sidebar");
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public Boolean getGutters() {
        return gutters;
    }

    public void setGutters(Boolean gutters) {
        this.gutters = gutters;
    }

    public Boolean getLiveSplitters() {
        return liveSplitters;
    }

    public void setLiveSplitters(Boolean liveSplitters) {
        this.liveSplitters = liveSplitters;
    }

    public Boolean getPersist() {
        return persist;
    }

    public void setPersist(Boolean persist) {
        this.persist = persist;
    }

    public Map<String, String> getDesigns() {
        return designs;
    }
}
