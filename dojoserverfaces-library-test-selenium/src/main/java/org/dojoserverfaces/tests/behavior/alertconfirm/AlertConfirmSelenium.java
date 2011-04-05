/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.behavior.alertconfirm;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AlertConfirmSelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                AlertConfirmSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/behavior/alertconfirm/alertconfirm.jsf");
        }
    }

    public void testAlert() throws Exception {
        waitForDojoReady();
        verifyFalse(selenium.isAlertPresent());
        selenium.click("form:initialValues:alertbutton");
        verifyTrue(selenium.isAlertPresent());
        verifyEquals("Hello DojoServerFaces", selenium.getAlert());
    }

    public void testConfirm() throws Exception {
        waitForDojoReady();
        selenium.click("form:initialValues:confirmbutton");
        verifyTrue(selenium.getConfirmation().matches(
                "^Are you sure to close[\\s\\S]$"));
        verifyEquals("Closing, please wait...", selenium.getAlert());
        selenium.chooseCancelOnNextConfirmation();
        selenium.click("form:initialValues:confirmbutton");
        verifyTrue(selenium.getConfirmation().matches(
                "^Are you sure to close[\\s\\S]$"));
        verifyEquals("Close canceled.", selenium.getAlert());
    }
}