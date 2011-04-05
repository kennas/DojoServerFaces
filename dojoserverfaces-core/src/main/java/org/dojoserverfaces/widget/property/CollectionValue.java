/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.model.SelectItem;

import org.dojoserverfaces.util.Helper;

/**
 * Property handler for EditableValueHolder components that deal 
 * with a collection of values.
 * 
 */
public class CollectionValue extends ValueProperty {

    public CollectionValue() {
        super();
    }

    public CollectionValue(String attributeName, String propertyName) {
        super(attributeName, propertyName);
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        if (component instanceof EditableValueHolder) {
            // if editableValueHolder then the value could be from alternate
            // variables
            EditableValueHolder editableValue = (EditableValueHolder) component;
            Object submittedValue = editableValue.getSubmittedValue();
            if (null != submittedValue) {
                // if there is a submitted value we'll not try to make a date
                if (submittedValue instanceof String) {
                    // just return current "submitted" value
                    return Helper.makeStringVar((String) submittedValue);
                }
                else {
                    // TODO consider handling this as an err?
                    return Helper.makeStringVar(submittedValue.toString());
                }
            }
            else if (editableValue.isLocalValueSet()) {
                return getAsJavascriptArray(component,
                        editableValue.getLocalValue());
            }
        }
        return getAsJavascriptArray(component,
                ((ValueHolder) component).getValue());
    }

    private String getAsJavascriptArray(UIComponent component, Object value) {
        if (value instanceof Object[]) {
            value = Arrays.asList((Object[]) value);
        }
        if (value instanceof Collection) {
            StringBuilder values = new StringBuilder("new Array(");
            boolean addComma = false;
            for (Object entry : (Collection<?>) value) {
                if (addComma) {
                    values.append(',');
                }
                else {
                    addComma = true;
                }
                values.append(Helper.makeStringVar(Helper.getConvertedValue(
                        component, entry)));
            }
            if (!addComma) {
                return null; // no entries were added
            }
            values.append(')');
            return values.toString();
        }
        return null;
    }

    @Override
    public void retrievePostBackValue(FacesContext context,
            UIComponent component) {
        String clientId = component.getClientId(context);
        Map<?, ?> reqParamValues = context.getExternalContext()
                .getRequestParameterValuesMap();
        if (reqParamValues.containsKey(clientId)) {
            ((EditableValueHolder) component)
                    .setSubmittedValue(decodeSubmittedValue(context,
                            reqParamValues.get(clientId)));
        }
        else {
            // TODO - set to empty array or null?
            ((EditableValueHolder) component)
                    .setSubmittedValue(decodeSubmittedValue(context,
                            new String[] {}));
        }
    }

    @Override
    public Object convertPostBackValue(FacesContext context,
            UIComponent component, Object submittedValue) {

        if (!(component instanceof EditableValueHolder)) {
            return null;
        }
        Class<?> valueType = null;
        ValueExpression ve = component.getValueExpression("value");
        if (null != ve) {
            valueType = ve.getType(context.getELContext());
        }
        if ((null == ve) || (null == valueType)) {
            // we're done, an array of String values
            return submittedValue;
        }
        Converter converter = ((ValueHolder) component).getConverter();
        if (valueType.isArray()) {
            Class<?> componentType = valueType.getComponentType();
            if (String.class.equals(componentType)) {
                // wahoo, we're done
                return submittedValue;
            }
            if (null == converter) {
                converter = context.getApplication().createConverter(
                        componentType);
            }
            if (converter == null) {
                // gotta have a converter
                throw new ConverterException("No converter found: "
                        + componentType.getSimpleName());
            }
            Object[] valueArray = (Object[]) Array.newInstance(componentType,
                    ((String[]) submittedValue).length);
            int i = 0;
            for (String value : (String[]) submittedValue) {
                valueArray[i++] = converter.getAsObject(context, component,
                        value);
            }
            return valueArray;
        }
        if (Collection.class.isAssignableFrom(valueType)) {
            if (null == converter) {
                converter = getConverterFromSelectItem(context, component);
            }
            try {
                if (null == converter) {
                    // assume no converter means its a collection of String
                    // objects
                    @SuppressWarnings("unchecked")
                    Collection<String> collection = (Collection<String>) valueType
                            .newInstance();
                    for (String value : (String[]) submittedValue) {
                        collection.add(value);
                    }
                    return collection;
                }
                else {
                    @SuppressWarnings("unchecked")
                    Collection<Object> collection = (Collection<Object>) valueType
                            .newInstance();
                    for (String value : (String[]) submittedValue) {
                        collection.add(converter.getAsObject(context,
                                component, value));
                    }
                    return collection;
                }
            }
            catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    private Converter getConverterFromSelectItem(FacesContext context,
            UIComponent component) {
        List<UIComponent> children = component.getChildren();
        for (int i = 0; i < children.size(); i++) {
            UIComponent child = (UIComponent) children.get(i);
            if (child instanceof UISelectItem) {
                if (!((UISelectItem) child).isNoSelectionOption()) {
                    Object value = ((UISelectItem) child).getValue();
                    if (value == null) {
                        return getConverterForValue(context,
                                ((UISelectItem) child).getItemValue());
                    }
                    else if (value instanceof SelectItem) {
                        if (!((SelectItem) value).isNoSelectionOption()) {
                            return getConverterForValue(context,
                                    ((SelectItem) value).getValue());
                        }
                    }
                }
            }
            else if (child instanceof UISelectItems) {
                Object value = ((UISelectItems) child).getValue();
                if (value != null) {
                    if (value instanceof SelectItem) {
                        if (!((SelectItem) value).isNoSelectionOption()) {
                            return getConverterForValue(context,
                                    ((SelectItem) value).getValue());
                        }
                    }
                    else if (value instanceof SelectItem[]) {
                        for (SelectItem item : (SelectItem[]) value) {
                            if (!item.isNoSelectionOption()) {
                                return getConverterForValue(context,
                                        item.getValue());
                            }
                        }
                    }
                    else if (value instanceof Collection) {
                        try {
                            for (Object item : (Collection<?>) value) {
                                if (!((SelectItem) item).isNoSelectionOption()) {
                                    return getConverterForValue(context,
                                            ((SelectItem) item).getValue());
                                }
                            }
                        }
                        catch (Exception e) {
                            throw new IllegalArgumentException(
                                    "Collection not of SelectItem objects");
                        }
                    }
                    else if (value instanceof Map) {
                        for (Object item : ((Map<?, ?>) value).values()) {
                            return getConverterForValue(context, item);
                        }
                    }
                }
            }
        }
        return null;
    }

    private Converter getConverterForValue(FacesContext context,
            Object itemValue) {
        return context.getApplication().createConverter(itemValue.getClass());
    }
}
