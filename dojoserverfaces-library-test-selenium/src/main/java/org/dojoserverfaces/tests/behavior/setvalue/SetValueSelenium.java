/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.behavior.setvalue;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SetValueSelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                SetValueSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/behavior/setvalue/setvalue.jsf");
        }
    }

    public void testSetValue() throws Exception {
        waitForDojoReady();
        verifyEquals("", selenium.getValue("form:initialValues:holder"));
        verifyEquals("", selenium.getValue("form:initialValues:hholder"));
        selenium.click("form:initialValues:buttonA");
        verifyEquals("Hello DojoServerFaces!", selenium.getValue("form:initialValues:holder"));
        verifyEquals("Hello DojoServerFaces!", selenium.getValue("form:initialValues:hholder"));
        selenium.click("form:initialValues:buttonB");
        verifyEquals("", selenium.getValue("form:initialValues:holder"));
        verifyEquals("", selenium.getValue("form:initialValues:hholder"));
    }
}