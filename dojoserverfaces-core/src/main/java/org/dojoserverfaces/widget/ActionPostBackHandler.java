/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.event.ActionEvent;

public class ActionPostBackHandler implements PostBackHandler {
    @Override
    public void retrievePostBackValue(FacesContext context,
            UIComponent component) {
        Map<String, String> requestParams = context.getExternalContext()
                .getRequestParameterMap();

        PartialViewContext pvContext = context.getPartialViewContext();
        if (pvContext.isPartialRequest() && pvContext.isAjaxRequest()) {
            String sourceId = requestParams.get("javax.faces.source");
            if (!component.getClientId(context).equals(sourceId))
                return;

            // TODO: need more condition to determine weather need to create an
            // action event or not for "partial" processing
            component.queueEvent(new ActionEvent(component));
        }
        else if (requestParams.containsKey(component.getClientId(context))) {
            component.queueEvent(new ActionEvent(component));
            // TODO: do we need to do anything for "partial" processing?
        }
    }

    @Override
    public Object convertPostBackValue(FacesContext context,
            UIComponent component, Object value) {
        // a simple button should not be asked for converted value
        // TODO: probably should throw exception
        return null;
    }
}
