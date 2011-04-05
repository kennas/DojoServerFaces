/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.dojoserverfaces.tests.widget.values.WidgetValues;

public class DojoServerFacesUtil {

    /**
     * The function returns the instance of the widgetValues bound to a bean in
     * a <code>context</code>, using the value expression written in the
     * component like <jd:textBox value="#{textBoxBean.beanBoundValue}"/>
     * 
     * This function assumes that the bean name is written in the value
     * attribute of the component and is in the form as written above.
     * 
     * @param context
     * @param component
     * @return
     */
    public static WidgetValues getWidgetValuesInstance(FacesContext context,
            UIComponent component) {
        WidgetValues widgetValues = null;
        String expressionString = component.getValueExpression("value")
                .getExpressionString();
        if (expressionString.startsWith("#{")) {
            // find the name of the managed bean with which this component has
            // bound its value
            expressionString = expressionString.substring(2, expressionString
                    .indexOf("."));
            Object bean = context.getApplication().getELResolver().getValue(
                    context.getELContext(), null, expressionString);
            Class<?> cls = bean.getClass();
            try {
                // A bean class is supposed to have the getWidgetValues method
                Method method = cls.getMethod("getWidgetValues");
                try {
                    if (method != null) {
                        widgetValues = (WidgetValues) method.invoke(bean);
                    }
                }
                catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            catch (SecurityException e) {
                e.printStackTrace();
            }
            catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return widgetValues;
    }
}