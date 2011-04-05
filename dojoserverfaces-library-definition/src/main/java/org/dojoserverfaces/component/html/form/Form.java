/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
/**
 * 
 */
package org.dojoserverfaces.component.html.form;

import java.util.Map;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.NavigationCase;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.GeneratedComponent;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;
import org.dojoserverfaces.constants.HtmlElementType;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.PostBackHandler;
import org.dojoserverfaces.widget.property.ClientIdProperty;
import org.dojoserverfaces.widget.property.StringProperty;

/**
 * Form container for user input. Forms can be generated that will be processed
 * as a faces post request or as a generic get request (faces or non-faces). It
 * provides for running field validation.
 */
@GeneratedComponent(dojoType = "dijit.form.Form", baseClassName = "javax.faces.component.UIForm", 
        elementType = HtmlElementType.DIV_JSF_FORM, postBackHandler = Form.FormPostBackHandler.class)
class Form extends WidgetBase {

    public static class FormPostBackHandler implements PostBackHandler {
        @Override
        public void retrievePostBackValue(FacesContext context,
                UIComponent component) {
            Map<String, String> requestParams = context.getExternalContext()
                    .getRequestParameterMap();
            String key = new StringBuilder(component.getClientId(context))
                    .append("Submitted").toString();
            if (requestParams.containsKey(key)) {
                ((UIForm) component).setSubmitted(true);
                // TODO: do we need to do anything for "partial" processing?
            }
            else {
                ((UIForm) component).setSubmitted(false);
            }
        }

        @Override
        public Object convertPostBackValue(FacesContext context,
                UIComponent component, Object value) {
            // a form should not be asked for converted value
            // TODO: probably should throw exception
            return null;
        }
    }

    public static class ActionProperty extends StringProperty {

        public ActionProperty(String name, String propertyName) {
            super(name, propertyName);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            // TODO if method=GET should we use bookmarkable
            // TODO if method=GET should we have an "outcome" attribute (e.g.
            // resource)
            FacesContext context = FacesContext.getCurrentInstance();
            String outcome = (String) getAttributeValue(component);
            if (null == outcome) {
                // this will be a post request back to this page
                outcome = context
                        .getApplication()
                        .getViewHandler()
                        .getActionURL(context,
                                context.getViewRoot().getViewId());
            }
            else {
                ConfigurableNavigationHandler navigationHandler = (ConfigurableNavigationHandler) context
                        .getApplication().getNavigationHandler();
                NavigationCase navigationCase = navigationHandler
                        .getNavigationCase(context, null, outcome);

                if (null == navigationCase) {
                    // TODO: likely a programming error and we should throw
                    // exception (or log error)
                    context.getExternalContext().log(
                            "invalid " + getName() + " value");
                    return null;
                }
                // TODO should we enforce that nav rule must be a "redirect"?
                outcome = context
                        .getApplication()
                        .getViewHandler()
                        .getBookmarkableURL(context,
                                navigationCase.getToViewId(context),
                                navigationCase.getParameters(), // add any
                                                                // view-param
                                                                // elements
                                navigationCase.isIncludeViewParams());
            }
            return new StringBuilder("\"").append(outcome).append('"')
                    .toString();
        }
    }

    public static class MethodProperty extends StringProperty {

        public MethodProperty(String name, String propertyName) {
            super(name, propertyName);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            return new StringBuilder("\"")
                    .append(null == Helper.getAttributeValue(component,
                            "navigateTo") ? "post" : "get").append('"')
                    .toString();
        }
    }

    /**
     * Name of form for scripting.
     */
    @Property(exposed = false, handler = ClientIdProperty.class)
    String name;

    /**
     * An "outcome" to be processed by the JSF navigation processor to generate
     * a URL for a GET request to a faces or non-faces resource. This request
     * will also be a bookmarkable URL. If the value resolves to no navigation
     * case then it will be treated as a local faces page (e.g. "detailsView" will
     * result in detailsView.faces). If this value is not set the default will
     * be to generate a Faces POST request back to the page being rendered.
     */
    @Property(name = "action", handler = ActionProperty.class)
    String navigateTo;

    /**
     * HTTP method used to submit the form, either "GET" or "POST".
     */
    @Property(exposed = false, handler = MethodProperty.class)
    String method;

    /**
     * Encoding type for the form, ex: application/x-www-form-urlencoded.
     */
    @Property
    String encType;

    /**
     * List of supported charsets.
     * 
     * @Property(name = "\\\"accept-charset\\\"", handler =
     *                ElementIdProperty.class) String acceptCharset;
     * 
     *                /** List of MIME types for file upload.
     */
    @Property
    String accept;

    /**
     * Target frame for the document to be opened in.
     */
    @Property
    String target;

    /**
     * Called when the form is to be submitted. A return value of true allows
     * the submission process to continue.
     */
    @Event
    Boolean onSubmit;

    /**
     * Called when the form is to be "reset". A return value of true allows the
     * reset process to continue.
     */
    @Event
    Boolean onReset;

}
