/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.behavior.disabledreadonly;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class DisabledReadOnlySelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                DisabledReadOnlySelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/behavior/setdisabledreadonly/setdisabledreadonly.jsf");
        }
    }

    public void testReadOnly() throws Exception {
        waitForDojoReady();
        selenium.click("form:initialValues:textBoxReadOnly");
        verifyEquals(
                "The attribute 'readOnly' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:textB').get('readOnly')"));
        selenium.click("form:initialValues:textBoxWritable");
        verifyEquals(
                "The attribute 'readOnly' could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:textB').get('readOnly')"));
    }

    public void testDisabled() throws Exception {
        waitForDojoReady();
        selenium.click("form:initialValues:textBoxDisable");
        verifyEquals(
                "The attribute 'disabled' for textbox could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:textB').get('disabled')"));
        selenium.click("form:initialValues:textBoxEnable");
        verifyEquals(
                "The attribute 'disabled' for textbox could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:textB').get('disabled')"));
        selenium.click("form:initialValues:buttonDisable");
        verifyEquals(
                "The attribute 'disabled' for button could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:buttonA').get('disabled')"));
        selenium.click("form:initialValues:buttonEnable");
        verifyEquals(
                "The attribute 'disabled' for button could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:buttonA').get('disabled')"));
    }
}