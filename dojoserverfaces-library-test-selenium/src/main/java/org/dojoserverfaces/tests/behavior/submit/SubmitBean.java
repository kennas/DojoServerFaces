/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.behavior.submit;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "submitBean")
@SessionScoped
public class SubmitBean {
    private String name = "DojoServerFaces";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}