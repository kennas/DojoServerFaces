/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Menu {
    private Object connectTo;
    private Boolean contextMenuForWindow = true;
    private Boolean leftClickToOpen;

    public Object getConnectTo() {
        return connectTo;
    }

    public void setConnectTo(Object connectTo) {
        this.connectTo = connectTo;
    }

    private Boolean refocus;

    public Boolean getContextMenuForWindow() {
        return contextMenuForWindow;
    }

    public void setContextMenuForWindow(Boolean contextMenuForWindow) {
        this.contextMenuForWindow = contextMenuForWindow;
    }

    public Boolean getLeftClickToOpen() {
        return leftClickToOpen;
    }

    public void setLeftClickToOpen(Boolean leftClickToOpen) {
        this.leftClickToOpen = leftClickToOpen;
    }

    public Boolean getRefocus() {
        return refocus;
    }

    public void setRefocus(Boolean refocus) {
        this.refocus = refocus;
    }

}
