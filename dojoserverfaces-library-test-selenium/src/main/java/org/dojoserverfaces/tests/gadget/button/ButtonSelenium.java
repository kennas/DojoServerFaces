/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.gadget.button;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.dojoserverfaces.LayoutComponentSelenium;
import junit.framework.Test;
import junit.framework.TestSuite;

public class ButtonSelenium extends LayoutComponentSelenium {

    public ButtonSelenium() {
        this.widgetValues = new ButtonValues();
        this.widgetInteraction = new ButtonInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                ButtonSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/gadget/button/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The element 'label' is not present",
                "Submit",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('label')"));
        System.out
                .println("Label ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('label')"));
        verifyEquals(
                "The element 'type' is not present",
                "submit",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('type')"));
        System.out
                .println("Label ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('type')"));
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
        String titleBeforeClick = selenium
                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('title')");
        System.out
                .println("Title Before Click-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('title')"));
        selenium.click("form:ajaxRefresh:button");
        System.out.println("*********Button Got Clicked**********");
        String titleAfterClick = selenium
                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('title')");
        System.out
                .println("Title After Click-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('title')"));
        if ((!(titleBeforeClick.equals(titleAfterClick))))
            System.out.println("******Testcase Passed.******");
        else
            System.out.println("******Testcase Failed.******");
    }
}