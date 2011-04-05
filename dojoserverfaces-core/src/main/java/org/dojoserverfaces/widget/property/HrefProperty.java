/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.NavigationCase;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * href property where the href could be resolved by the jsf navigation handler.
 */
public class HrefProperty extends Property {

    public HrefProperty(String name, String propertyName) {
        super(name, propertyName);
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        Object value = getAttributeValue(component);
        if (null != value) {
            String ref = value.toString();
            if (ref.isEmpty()) {
                return null;
            }
            if (ref.startsWith("//")) {
                // if the ref resolved to a path beginning
                // with two slashes then assume server-relative
                // and remove extra slash
                ref = ref.substring(1);
                // TODO - is this needed, if so, document it
            }
            else {
                FacesContext context = FacesContext.getCurrentInstance();
                ConfigurableNavigationHandler navigationHandler = (ConfigurableNavigationHandler) context
                        .getApplication().getNavigationHandler();
                NavigationCase navigationCase = navigationHandler
                        .getNavigationCase(context, null, ref);

                if (null != navigationCase) {
                    ref = context
                            .getApplication()
                            .getViewHandler()
                            .getBookmarkableURL(context,
                                    navigationCase.getToViewId(context),
                                    // add any view-param elements
                                    navigationCase.getParameters(),
                                    navigationCase.isIncludeViewParams());
                }
                else {
                    log(component, "questionable value");
                }
            }
            return new StringBuilder("\"").append(ref).append('"').toString();
        }
        return null;
    }
}
