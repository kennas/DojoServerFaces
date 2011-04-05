/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.behavior.showhide;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class ShowHideSelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                ShowHideSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/behavior/showhide/showhide.jsf");
        }
    }

    public void testShow() throws Exception {
        waitForDojoReady();
        verifyEquals("false", selenium.isVisible("form:initialValues:dialog"));
        selenium.click("form:initialValues:buttonA");
        verifyEquals("true", selenium.isVisible("form:initialValues:dialog"));
    }

    public void testHide() throws Exception {
        waitForDojoReady();
        verifyEquals("true", selenium.isVisible("form:initialValues:dialog"));
        selenium.click("form:initialValues:buttonB");
        verifyEquals("false", selenium.isVisible("form:initialValues:dialog"));
    }
}