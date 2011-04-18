/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html;
import java.lang.reflect.Field;
/**
 * Java reflection using on JsfDataStore
 * 
 */
public class JavaReflection {
    /**
     * 
     * @param obj
     * @param property
     * @return
     * 
     */
    public Object getPrivateValue(Object obj, String property) {
        Object value = new Object();
        try {
            Class<? extends Object> objClass = obj.getClass();
            Field field = objClass.getDeclaredField(property);
            field.setAccessible(true);
            value = field.get(obj);
            return value;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return value;
        }

    }
/**
 * Get all properties of an Object
 * @param obj
 * @return
 */
    public String[] getAllProperties(Object obj) {
        String[] value;
        boolean addcoma = false;
        StringBuilder properties = new StringBuilder();
        try {
            Class<? extends Object> objClass = obj.getClass();
            Field[] fields = objClass.getDeclaredFields();
            for (Field fd : fields) {
                if (addcoma) {
                    properties.append(",");
                }
                properties.append(fd.getName());
                addcoma = true;
            }
            value = properties.toString().split(",");
            return value;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
