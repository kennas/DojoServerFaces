/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.constants;

/**
 * Constants of where calling addInitScriptBlock. This is mainly used for
 * Container Components
 * 
 */
public enum RenderPosition {
    /*
     * Call addInitScriptBlock at enCodeBegin method
     */
    EN_CODE_BEGIN,
    /*
     * Call addInitScriptBlock at enCodeEnd method
     */
    EN_CODE_END,
    /*
     * Call addInitScriptBlock at enCodeChildren method
     * May be used in the future?
     */
    EN_CODE_CHILDREN
}
