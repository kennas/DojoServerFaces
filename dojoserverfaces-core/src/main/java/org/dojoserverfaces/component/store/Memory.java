package org.dojoserverfaces.component.store;

/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.dojoserverfaces.build.annotation.DojoObject;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.util.Helper;

/**
 * 
 * This component is an object store wrapper for JavaScript/JSON available
 * directly with an array. This store implements the new Dojo Object Store API.
 */
@DojoObject(dojoType = "dojo.store.Memory")
public class Memory {

    public static class DataStoreProperty extends
            org.dojoserverfaces.widget.property.Property implements Validator {
        /**
         * the attribute name to use for finding matching selection
         */
        private String idProperty = "name";

        public DataStoreProperty(String name) {
            super(name);
        }

        public DataStoreProperty(String attributeName, String propertyName) {
            super(attributeName, propertyName); // ignoring attr name as this
                                                // type property
            // should not be exposed as attr
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            StringBuilder storeDeclaration = new StringBuilder("[");
            // idProperty =
            // component.getAttributes().get("idProperty").toString();
            getSelectItems(component, storeDeclaration);
            storeDeclaration.append("]");
            return storeDeclaration.toString();
        }

        @SuppressWarnings("unchecked")
        void getSelectItems(UIComponent component, StringBuilder optionStore) {
            List<UIComponent> children = component.getChildren();
            boolean addComma = false;
            for (int i = 0; i < children.size(); i++) {
                UIComponent child = (UIComponent) children.get(i);
                if (child instanceof UISelectItem) {
                    append(component, optionStore, addComma,
                            (UISelectItem) child);
                    addComma = true;
                }
                else if (child instanceof UISelectItems) {
                    Object value = ((UISelectItems) child).getValue();
                    if (value != null) {
                        if (value instanceof SelectItem) {
                            append(component, optionStore, addComma,
                                    ((SelectItem) value));
                            addComma = true;
                        }
                        else if (value instanceof SelectItem[]) {
                            for (SelectItem item : (SelectItem[]) value) {
                                append(component, optionStore, addComma, item);
                                addComma = true;
                            }
                        }
                        else if (value instanceof Collection) {
                            try {
                                for (SelectItem item : (Collection<SelectItem>) value) {
                                    append(component, optionStore, addComma,
                                            item);
                                    addComma = true;
                                }
                            }
                            catch (Exception e) {
                                throw new IllegalArgumentException(
                                        "Collection not of SelectItem objects");
                            }
                        }
                        else if (value instanceof Map) {
                            for (Map.Entry<Object, Object> mapEntry : ((Map<Object, Object>) value)
                                    .entrySet()) {
                                append(component, optionStore, addComma,
                                        mapEntry.getValue());
                                // TODO: is using escape true above correct for
                                // map?
                                addComma = true;
                            }
                        }

                        else if (value instanceof DataModel<?>) {
                            DataModel<?> dataModel = (DataModel<?>) value;

                            for (Iterator<?> it = dataModel.iterator(); it
                                    .hasNext();) {
                                Object bean = it.next();
                                PropertyDescriptor properties[];

                                // TODO: not great to have to do this, so think
                                // of
                                // something a little better performance-wise.

                                try {
                                    properties = Introspector.getBeanInfo(
                                            bean.getClass())
                                            .getPropertyDescriptors();
                                }

                                catch (Throwable e) {
                                    // TODO: handle.

                                    e.printStackTrace();

                                    return;
                                }

                                for (int j = 0; j < properties.length; ++j) {
                                    String name = properties[j].getName();
                                    if (!name.equals("class")) {
                                        Object propertyValue = null;

                                        try {
                                            propertyValue = properties[j]
                                                    .getReadMethod().invoke(
                                                            bean);
                                        }

                                        catch (Throwable ex) {
                                            // TODO: handle.

                                            ex.printStackTrace();

                                            return;
                                        }

                                        append(component, optionStore,
                                                addComma, propertyValue);

                                        addComma = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        void append(UIComponent component, StringBuilder optionStore,
                boolean needComma, Object itemValue) {
            if (needComma) {
                optionStore.append(',');
            }
            // TODO: handle escape setting?
            Converter converter = Helper.getConverter(component);
            optionStore
                    .append("{")
                    .append(idProperty)
                    .append(":")
                    .append(Helper.makeStringVar(null == converter ? itemValue
                            .toString() : converter.getAsString(
                            FacesContext.getCurrentInstance(), component,
                            itemValue))).append("}");
        }

        void append(UIComponent component, StringBuilder optionStore,
                boolean needComma, SelectItem selectItem) {
            // TODO: better handling of isNoSelectionOption and disabled
            if (!selectItem.isNoSelectionOption() && !selectItem.isDisabled()) {
                append(component, optionStore, needComma, selectItem.getValue());
            }
        }

        void append(UIComponent component, StringBuilder optionStore,
                boolean needComma, UISelectItem selectItemComp) {
            Object value = selectItemComp.getValue();
            if (value == null) {
                // TODO: better handling of isNoSelectionOption and disabled
                if (!selectItemComp.isNoSelectionOption()
                        && !selectItemComp.isItemDisabled()
                        && selectItemComp.isRendered()) {
                    append(component, optionStore, needComma,
                            selectItemComp.getItemValue());
                }
            }
            else if (value instanceof SelectItem) {
                append(component, optionStore, needComma, (SelectItem) value);
            }
        }

        @Override
        public void validate(FacesContext context, UIComponent comp,
                Object value) throws ValidatorException {
            if (!matchValue(context, comp, value)) {
                throw new ValidatorException(getInvalidMessage(comp));
            }
        }

        FacesMessage getInvalidMessage(UIComponent comp) {
            return new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    new StringBuilder(comp.getId()).append(
                            ": Validation Error: Invalid value").toString(),
                    null);
        }

        boolean matchValue(FacesContext context, UIComponent storeComp,
                Object value) {
            List<UIComponent> children = storeComp.getChildren();
            for (UIComponent child : children) {
                if (child instanceof UISelectItem) {
                    UISelectItem selectItemComp = (UISelectItem) child;
                    Object valueLocal = selectItemComp.getValue();
                    if (valueLocal == null) {
                        if (!selectItemComp.isNoSelectionOption()
                                && !selectItemComp.isItemDisabled()
                                && selectItemComp.isRendered()) {
                            return value.equals(selectItemComp.getItemValue());
                        }
                    }
                    else if (valueLocal instanceof SelectItem) {
                        return value.equals(valueLocal);
                    }
                    return false;
                }
                else if (child instanceof UISelectItems) {
                    return matchValue(context, (UISelectItems) child, value);
                }
            }
            return false;
        }

        boolean matchValue(FacesContext context, UISelectItems selectItemsComp,
                Object value) {
            Object valueLocal = selectItemsComp.getValue();
            if (valueLocal == null)
                return false;

            if (valueLocal instanceof SelectItem) {
                if (value.equals(((SelectItem) valueLocal).getValue()))
                    return true;
            }
            else if (valueLocal instanceof SelectItem[]) {
                for (SelectItem item : (SelectItem[]) valueLocal) {
                    if (value.equals(item.getValue()))
                        return true;
                }
            }
            else if (valueLocal instanceof SelectItemGroup) {
                for (SelectItem item : ((SelectItemGroup) valueLocal)
                        .getSelectItems()) {
                    if (value.equals(item.getValue()))
                        return true;
                }
            }
            else if (valueLocal instanceof Collection) {
                try {
                    for (SelectItem item : (Collection<SelectItem>) value) {
                        if (value.equals(item.getValue()))
                            return true;
                    }
                }
                catch (Exception e) {
                    throw new IllegalArgumentException(
                            "Collection not of SelectItem objects");
                }
            }
            else if (valueLocal instanceof Map) {
                return ((Map) valueLocal).containsValue(value);
            }
            else if (valueLocal instanceof DataModel) {
                // TODO: need to support?
            }
            return false;
        }
    }

    /**
     * If the store has a collection of cached objects, it can make this
     * available in this property. This is included so an additional layer could
     * add referential integrity cleanup on object deletion (which is a pain to
     * implement).
     */
    @Property(exposed = false, handler = DataStoreProperty.class)
    Object data;

    public static class IDProperty extends
            org.dojoserverfaces.widget.property.Property {
        private String idProperty = "name";

        protected IDProperty(String name, String propertyName) {
            super(name, propertyName);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            return Helper.quote(idProperty);
        }
    }

    /**
     * Name of the property to use as the identifier
     */
    @Property(exposed = false, handler = IDProperty.class)
    String idProperty;
}
