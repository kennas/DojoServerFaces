/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.behavior.broadcast;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class BroadcastSelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                BroadcastSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/behavior/broadcast/broadcast.jsf");
        }
    }

    public void testBroadcast() throws Exception {
        waitForDojoReady();
        verifyFalse(selenium.isAlertPresent());
        selenium.click("form:initialValues:buttonA");
        verifyTrue(selenium.isAlertPresent());
        verifyEquals("Hello DojoServerFaces!", selenium.getAlert());
    }
}