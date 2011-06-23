/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.widget;

/**
 * The enum class for Variable names.
 * 
 * @author "jatin.varshney@in.ibm.com"
 * 
 */
public enum VariableName {
    FIRST(0), SECOND(1), THIRD(2), FOURTH(3), BAD(4);
    private int value;

    VariableName(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}