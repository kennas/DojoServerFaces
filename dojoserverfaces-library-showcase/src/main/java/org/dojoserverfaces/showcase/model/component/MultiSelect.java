/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MultiSelect extends HTMLInput {
    private String[] travels = { "" };

    public String[] getTravels() {
        return travels;
    }

    public void setTravels(String[] travels) {
        this.travels = travels;

        // This is Used to fix the bug that all items are selected when travels
        // is empty.
        if (this.travels == null || this.travels.length == 0) {
            this.travels = new String[] { "" };
        }
    }
}
