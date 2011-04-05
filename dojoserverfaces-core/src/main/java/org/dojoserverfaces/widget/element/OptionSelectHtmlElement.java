/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.element;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

import org.dojoserverfaces.util.Helper;

public class OptionSelectHtmlElement extends HtmlElement{
     @Override
     public String getElement(FacesContext context, UIComponent component) {
          StringBuilder elementMarkup = new StringBuilder("<select");
          elementMarkup.append(" id=\"").append(component.getClientId(context)).append("\">")
          .append(getSelectItems(context, component))
          .append("</select>");
          return elementMarkup.toString();
     }
     
     @Override
     public String getElementClose(FacesContext context,
               UIComponent component) {
          return null;
     }
     
     private String getSelectItems(FacesContext context, UIComponent component){
          List<UIComponent> children = component.getChildren();
          StringBuilder options = new StringBuilder();
          for (int i = 0; i < children.size(); i++) 
          {
               UIComponent child = (UIComponent) children.get(i);
               if (child instanceof UISelectItem){
                    append(component, options, (UISelectItem)child);
               }
               else if (child instanceof UISelectItems)
               {
                    Object value = ((UISelectItems)child).getValue();
                    if (value != null)
                    {
                         if (value instanceof SelectItem){
                              append(component, options, ((SelectItem)value));
                         } else if (value instanceof SelectItem[]){
                              for (SelectItem item : (SelectItem[])value){
                                   append(component, options, item);
                              }
                         } else if (value instanceof Collection){
                              try {
                                   for (Object item : (Collection<?>)value){
                                        append(component, options, (SelectItem)item);
                                   }
                              } catch (Exception e) {
                                   throw new IllegalArgumentException("Collection not of SelectItem objects");
                              }
                         } else if (value instanceof Map){
                              for (Map.Entry<?, ?> mapEntry : ((Map<?, ?>)value).entrySet()){
                                   append(component, options, mapEntry.getValue(), mapEntry.getKey().toString());
                              }
                         }
                    }
               }
          }
          return options.toString();
     }

     private void append(UIComponent component, StringBuilder optionStore, Object itemValue, String itemLabel) {
        if (null == itemLabel){
          itemLabel = itemValue.toString();
        }
        Converter converter = Helper.getConverter(component);
          optionStore.append("<option value=")
               .append(Helper.makeStringVar(null == converter ? itemValue.toString() : 
                    converter.getAsString(FacesContext.getCurrentInstance(), component, itemValue))).append(',')
               .append(">").append(itemLabel).append("</option>");
     }

     private void append(UIComponent component, StringBuilder optionStore, SelectItem selectItem) {
          if (!selectItem.isNoSelectionOption()){
               append(component, optionStore, selectItem.getValue(), selectItem.getLabel());
          }
     }

     private void append(UIComponent component, StringBuilder optionStore, UISelectItem selectItemComp) {
        Object value = selectItemComp.getValue();
        if (value == null){
          if (!selectItemComp.isNoSelectionOption()){
               append(component, optionStore, selectItemComp.getItemValue(), selectItemComp.getItemLabel());
          }
        } else if (value instanceof SelectItem){
               append(component, optionStore, (SelectItem)value);
        }
     }

}
