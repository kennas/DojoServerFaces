/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.property;

import javax.faces.application.ProjectStage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * Enum property type base class. Constructor takes valid values array.
 */
public abstract class EnumPropertyBase extends Property {

    private String[] validValues;

    protected EnumPropertyBase(String name, String propertyName,
            String[] validValues) {
        super(name, propertyName);
        this.validValues = validValues;
    }

    @Override
    public String getAsPropertyValue(UIComponent component) {
        Object value = getAttributeValue(component);
        if (null != value) {
            // if dev stage lets validate property value
            if (FacesContext.getCurrentInstance().isProjectStage(
                    ProjectStage.Development)) {
                for (String s : validValues) {
                    if (s.equals(value)) {
                        return quoteString(value);
                    }
                }
                log(component, "illegal value");
                return null;
            }
            return quoteString(value);
        }
        return null;
    }
    
    private String quoteString(Object o){
        return new StringBuilder("\"").append(o.toString()).append('"')
        .toString();
    }

}
