/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.application;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextFactory;

/**
 * Testcase specific ExternalContextFactory
 * 
 * @author "jatin.varshney@in.ibm.com"
 * 
 */
public class TestExternalContextFactory extends ExternalContextFactory {
    private ExternalContextFactory parent;

    public TestExternalContextFactory(ExternalContextFactory factory) {
        super();
        this.parent = factory;
    }

    @Override
    public ExternalContext getExternalContext(Object context, Object request,
            Object response) throws FacesException {
        return new TestExternalContext(parent.getExternalContext(context,
                request, response));
    }
}