/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.gadget.togglebutton;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class ToggleButtonSelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                ToggleButtonSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/gadget/togglebutton/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The element 'label' is not present",
                "toggle me off",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('label')"));
        System.out
                .println("Label ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('label')"));
        verifyEquals(
                "The element 'checked' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('checked')"));
        System.out
                .println("Checked ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('checked')"));
    }

    public void testAjaxRefresh() throws Exception {
        waitForDojoReady();
        String labelBeforeClick = selenium
                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('label')");
        System.out
                .println("Label Before Click-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('label')"));
        selenium.click("form:ajaxRefresh:widgetAjaxCall");
        System.out.println("*********Button Got Clicked**********");
        String labelAfterClick = selenium
                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('label')");
        System.out
                .println("Label After Click-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('label')"));
        if ((!(labelBeforeClick.equals(labelAfterClick))))
            System.out.println("******Testcase Passed.******");
        else
            System.out.println("******Testcase Failed.******");
    }
}