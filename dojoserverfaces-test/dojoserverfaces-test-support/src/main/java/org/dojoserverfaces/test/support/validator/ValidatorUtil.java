/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.validator;

import java.util.Collection;

public class ValidatorUtil {

    /**
     * Validates if the <code>object</code> is equal to or contains one of its
     * value as <code>value</code>
     * 
     * @param object
     * @param value
     * @return - returns true if <code>value</code> is found inside
     *         <code>object</code>, false otherwise
     */
    public static boolean validateObjectContainsValue(Object object,
            Object value) {
        if (object == null || value == null)
            return false;

        if (object.getClass().equals(value.getClass()) && object.equals(value))
            return true;

        else if (object instanceof Object[]) {
            Object[] objArr = (Object[]) object;
            for (Object obj : objArr) {
                if (obj.getClass().equals(value.getClass())
                        && obj.equals(value)) {
                    return true;
                }
            }
        }

        else if (object instanceof Collection<?>) {
            Collection<?> collection = (Collection<?>) object;
            for (Object obj : collection) {
                if (obj.getClass().equals(value.getClass())
                        && obj.equals(value)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Validates if the <code>object</code> is equal to or has only one value as
     * <code>value</code>
     * 
     * @param object
     * @param value
     * @return - returns true if <code>value</code> is found inside
     *         <code>object</code>, false otherwise
     */
    public static boolean validateObjectHasOnlyValue(Object object, Object value) {

        if (object == null || value == null)
            return false;

        if (object.getClass().equals(value.getClass()) && object.equals(value))
            return true;

        else if (object instanceof Object[]) {
            Object[] objArr = (Object[]) object;
            if (objArr.length == 1
                    && objArr[0].getClass().equals(value.getClass())
                    && objArr[0].equals(value)) {
                return true;
            }
        }

        else if (object instanceof Collection<?>) {
            Collection<?> collection = (Collection<?>) object;
            if (collection.size() == 1)
                for (Object obj : collection) {
                    if (obj.getClass().equals(value.getClass())
                            && obj.equals(value)) {
                        return true;
                    }
                }
        }
        return false;
    }
}