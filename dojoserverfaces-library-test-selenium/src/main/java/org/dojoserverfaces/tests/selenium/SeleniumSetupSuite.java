/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.selenium;

import junit.extensions.TestSetup;
import junit.framework.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

/**
 * This class serves as a helper class for Selenium based testcase of a
 * component. The class provides the ability to open the browser only once
 * before any test function of a class starts and kills the browser after all
 * the test functions of the class have been executed.
 * 
 * @author "jatin.varshney@in.ibm.com"
 * 
 */
public class SeleniumSetupSuite extends TestSetup {

    private Selenium selenium;

    public SeleniumSetupSuite(Test test) {
        super(test);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        if (selenium == null) {
            selenium = new DefaultSelenium("localhost", 4444, "*chrome",
                    "http://localhost:8080/");
            selenium.start();
            selenium.windowMaximize();
        }
    }

    public Selenium getSelenium() {
        return selenium;
    }

    @Override
    protected void tearDown() throws Exception {
        if (selenium != null) {
            selenium.stop();
            selenium = null;
        }
        super.tearDown();
    }
}