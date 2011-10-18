/*******************************************************************************
 *   Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *   Available via Academic Free License >= 2.1 OR the modified BSD license.
 *   see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import java.util.Collection;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.dojoserverfaces.widget.DojoWidget;

/**
 * Property that references a Dojo data store.
 */

public class DataStoreRefProperty extends DojoRefProperty implements Validator {
     public DataStoreRefProperty(String name) {
          super(name);
     }

     public DataStoreRefProperty(String attributeName, String propertyName) {
          super(attributeName, propertyName);
     }

     /*
      * @see
      * javax.faces.validator.Validator#validate(javax.faces.context.FacesContext
      * , javax.faces.component.UIComponent, java.lang.Object)
      */
     @Override
     public void validate(FacesContext context, UIComponent comp,
               Object value) throws ValidatorException {
          String storeId = (String) comp.getAttributes().get(this.getName());
          if (storeId == null || value == null)
               return;

          UIComponent storeComp = context.getViewRoot()
          .findComponent(storeId);
          if (storeComp != null && (storeComp instanceof DojoWidget)) {
               Validator validator = getDataStoreValidator((DojoWidget) storeComp);
               if (validator != null) {
                    validator.validate(context, (UIComponent) storeComp, value);
               }
          }
     }

     private Validator getDataStoreValidator(DojoWidget selectItemStore) {
          Collection<org.dojoserverfaces.widget.property.Property> propertyHandlers = selectItemStore
          .getPropertyHandlers();
          for (org.dojoserverfaces.widget.property.Property property : propertyHandlers) {
               if ("data".equals(property.getName())
                         && property instanceof Validator) {
                    return (Validator) property;
               }
          }
          return null;
     }
}
