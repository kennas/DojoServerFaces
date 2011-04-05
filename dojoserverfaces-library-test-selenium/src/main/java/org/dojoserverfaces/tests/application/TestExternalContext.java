/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.application;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextWrapper;

/**
 * Testcase specific ExternalContext, Its purpose is to return the
 * init-paramaters of the application from session if they are available there.
 * 
 * @author "jatin.varshney@in.ibm.com"
 * 
 */
public class TestExternalContext extends ExternalContextWrapper {

    ExternalContext parent;

    public TestExternalContext(ExternalContext externalContext) {
        super();
        this.parent = externalContext;
    }

    @Override
    public ExternalContext getWrapped() {
        return parent;
    }

    @Override
    public String getInitParameter(String name) {
        if ("javax.faces.VALIDATE_EMPTY_FIELDS".equals(name)
                || "javax.faces.INTERPRET_EMPTY_STRING_SUBMITTED_VALUES_AS_NULL"
                        .equals(name)
                || "javax.faces.PARTIAL_STATE_SAVING".equals(name)) {
            Map<String, Object> sessionMap = getSessionMap();
            if (sessionMap.containsKey(name)) {
                return (String) sessionMap.get(name);
            }
        }
        return parent.getInitParameter(name);
    }
}