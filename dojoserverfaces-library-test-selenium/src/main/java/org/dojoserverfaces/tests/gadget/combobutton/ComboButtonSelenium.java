/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.gadget.combobutton;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class ComboButtonSelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                ComboButtonSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/gadget/combobutton/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The element 'label' is not present",
                "Click",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('label')"));
        System.out
                .println("Label ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('label')"));
        verifyEquals(
                "The element 'showLabel' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('showLabel')"));
        System.out
                .println("ShowLabel ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('showLabel')"));
        verifyEquals(
                "The element 'style' is not present",
                "width: 100px; height: 20px;",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
        System.out
                .println("Style ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
    }

    public void testAjaxRefresh() throws Exception {
        waitForDojoReady();
        String valueBeforeClick = selenium
                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML");
        System.out
                .println("Value Before Click-------->>>>>"
                        + selenium
                                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML"));
        selenium.click("form:ajaxRefresh:menuitem1");
        System.out.println("*********Button Got Clicked**********");
        String valueAfterClick = selenium
                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML");
        System.out
                .println("Value After Click-------->>>>>"
                        + selenium
                                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML"));
        if ((!(valueBeforeClick.equals(valueAfterClick))))
            System.out.println("******Testcase Passed.******");
        else
            System.out.println("******Testcase Failed.******");
    }
}