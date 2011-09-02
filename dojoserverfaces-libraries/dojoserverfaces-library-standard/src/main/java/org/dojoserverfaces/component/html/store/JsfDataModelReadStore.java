/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.store;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import javax.faces.application.ProjectStage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.dojoserverfaces.build.annotation.DojoObject;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.property.NullProperty;

/**
 * A dataStore used a java collection as its source
 * 
 */
@DojoObject(dojoType = "dojo.data.ItemFileReadStore")
public class JsfDataModelReadStore {
    static class DataJsonProperty extends
            org.dojoserverfaces.widget.property.Property {
        private static String DEFAULT_ID = "d_s_f";

        public DataJsonProperty(String name) {
            super(name);
        }

        public DataJsonProperty(String attributeName, String propertyName) {
            super(attributeName, propertyName);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            StringBuilder sb = new StringBuilder();
            StringBuilder items = new StringBuilder();
            boolean addComa = false;
            String[] properties = null;
            FacesContext context = FacesContext.getCurrentInstance();
            String identifier = DEFAULT_ID;
            if (null != Helper.getAttributeValue(component, "key")) {
                identifier = Helper.getAttributeValue(component, "key")
                        .toString();
            }
            StringBuilder propertyWithId = new StringBuilder();
            boolean addObjComa = false;
            String propertiesAttr = null;
            if (null != Helper.getAttributeValue(component, "properties")) {
                propertiesAttr = Helper.getAttributeValue(component,
                        "properties").toString();
            }

            if (propertiesAttr != null) {
                if (!propertiesAttr.contains(identifier)) {
                    propertyWithId.append(identifier).append(" ")
                            .append(propertiesAttr);
                }
                else {
                    propertyWithId.append(propertiesAttr);
                }
                properties = propertyWithId.toString().split("\\s");
            }
            Object value = getAttributeValue(component);
            if (value instanceof Collection) {
                for (Object obj : (Collection<?>) value) {
                    if (properties == null) {
                        properties = new String[1];
                        properties[0] = identifier;
                    }
                    if (addObjComa) {
                        items.append(",");
                    }
                    items.append("{");
                    addComa = false;
                    if (properties.length > 1) {
                        for (String propertyName : properties) {
                            if (addComa) {
                                items.append(",");
                            }

                            String propertyValue = getConvertedValue(
                                    this.getPropertyValue(obj, propertyName),
                                    context, component);
                            if (propertyName.contains(".")) {
                                items.append(propertyName.replace(".", "_"))
                                        .append(":")
                                        .append(Helper.quote(propertyValue));
                            }
                            else {
                                items.append(propertyName).append(":")
                                        .append(Helper.quote(propertyValue));
                            }
                            addComa = true;
                        }
                    }
                    // if the item is just an normal object like Date and Double
                    // and so on.
                    else {
                        String propertyValue = this.getConvertedValue(obj,
                                context, component);
                        items.append(properties[0]).append(":")
                                .append(Helper.quote(propertyValue));
                    }
                    items.append("}");
                    addObjComa = true;
                }
            }
            sb.append("{identifier:");
            sb.append(Helper.quote(identifier)).append(",label:")
                    .append(Helper.quote(identifier)).append(",items:[");
            sb.append(items.toString()).append("]}");
            return sb.toString();
        }

        private Object getPropertyValue(Object bean, String propertyName) {

            String handlePropertyName = propertyName;
            Object handleBean = bean;
            if (propertyName.contains(".")) {
                String[] subPropertyNames = propertyName.split("\\.");
                for (int i = 0; i < subPropertyNames.length - 1; i++) {
                    handleBean = getPropertyValue(handleBean,
                            subPropertyNames[i]);
                }
                handlePropertyName = subPropertyNames[subPropertyNames.length - 1];
            }
            PropertyDescriptor[] properties;
            try {
                properties = Introspector.getBeanInfo(handleBean.getClass())
                        .getPropertyDescriptors();

                for (PropertyDescriptor prop : properties) {
                    String name = prop.getName();
                    if (!"class".equals(handlePropertyName)) {
                        if (handlePropertyName.equals(name)) {
                            return prop.getReadMethod().invoke(handleBean);
                        }
                    }
                }
            }
            catch (IllegalAccessException e) {
                log(e.getMessage());
            }
            catch (InvocationTargetException e) {
                log(e.getMessage());
            }
            catch (IntrospectionException e) {
                log(e.getMessage());
            }
            return null;
        }

        /**
         * Log a message if the project stage is Development
         * 
         * @param msg
         */
        private void log(String msg) {
            FacesContext context = FacesContext.getCurrentInstance();
            if (context.isProjectStage(ProjectStage.Development)) {
                context.getExternalContext().log(
                        getClass().getName() + " - " + msg);
            }
        }

        private String getConvertedValue(Object value, FacesContext context,
                UIComponent component) {
            Converter converter = context.getApplication().createConverter(
                    value.getClass());
            if (null != converter) {
                return converter.getAsString(context, component, value);
            }
            return value.toString();

        }
    }

    /**
     * a java collection object used as the source
     */
    @Property(handler = DataJsonProperty.class)
    Object data;
    /**
     * The properties used for the DataStore the properties divided by the
     * space. it can be used "." to access the sub properties of a property,
     * such as Customer.Department.name
     * 
     */
    @Property(handler = NullProperty.class)
    String propeties;
    /**
     * The main item of dataStore like prime key of a table.
     */
    @Property(handler = NullProperty.class)
    String key;

}
