/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.gadget.menu;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class MenuSelenium extends SeleniumTestCase {

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                MenuSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            selenium
                    .open("http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/gadget/menu/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The element 'popupDelay' is not present",
                "50",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('popupDelay')"));
        System.out
                .println("PopupDelay ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('popupDelay')"));
        verifyEquals(
                "The element 'style' is not present",
                "width: 50px; height: 100px;",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
        System.out
                .println("Style ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
        verifyEquals(
                "The element 'contextMenuForWindow' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('contextMenuForWindow')"));
        System.out
                .println("ContextMenuForWindow ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('contextMenuForWindow')"));
        verifyEquals(
                "The element 'leftClickToOpen' is not present",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('leftClickToOpen')"));
        System.out
                .println("LeftClickToOpen ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('leftClickToOpen')"));
        verifyEquals(
                "The element 'refocus' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('refocus')"));
        System.out
                .println("Refocus ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('refocus')"));
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