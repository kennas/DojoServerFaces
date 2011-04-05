/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.container.titlepane;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.dojoserverfaces.LayoutComponentSelenium;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TitlePaneSelenium extends LayoutComponentSelenium {

    public TitlePaneSelenium() {
        this.widgetValues = new TitlePaneValues();
        this.widgetInteraction = new TitlePaneInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                TitlePaneSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/container/titlePane/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The attribute 'duration' could was not set as expected",
                "80",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('duration')"));
        System.out
                .println("Duration is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('duration')"));
        verifyEquals(
                "The attribute 'open' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('open')"));
        System.out
                .println("Open is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('open')"));
        verifyEquals(
                "The element 'tooltip' is not present",
                "This is Title Pane.",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltip')"));
        System.out
                .println("Tooltip ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltip')"));
        verifyEquals(
                "The attribute 'toggleable' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('toggleable')"));
        System.out
                .println("Toggleable is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('toggleable')"));
        verifyEquals(
                "The attribute 'errorMessage' could was not set as expected",
                "TitlePane couldn't be loaded",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('errorMessage')"));
        System.out
                .println("ErrorMessage is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('errorMessage')"));
        verifyEquals(
                "The attribute 'loadingMessage' could was not set as expected",
                "TitlePane is Loading",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('loadingMessage')"));
        System.out
                .println("LoadingMessage is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('loadingMessage')"));
        verifyEquals(
                "The attribute 'extractContent' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('extractContent')"));
        System.out
                .println("ExtractContent is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('extractContent')"));
        verifyEquals(
                "The attribute 'preLoad' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('preLoad')"));
        System.out
                .println("PreLoad is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('preLoad')"));
        verifyEquals(
                "The attribute 'preventCache' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('preventCache')"));
        System.out
                .println("PreventCache is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('preventCache')"));
        verifyEquals(
                "The attribute 'refreshOnShow' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('refreshOnShow')"));
        System.out
                .println("RefreshOnShow is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('refreshOnShow')"));
    }

    public void testInheritedLayoutComponentsProperties() {
        waitForDojoReady();
        verifyEquals(
                "The attribute 'title' could was not set as expected",
                widgetValues.getSimpleValue(),
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('title')"));
        System.out
                .println("Title is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('title')"));
        verifyEquals(
                "The attribute 'style' could was not set as expected",
                "width: 400px; height: 100px;",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
        System.out
                .println("Style is----->>>>"
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
        selenium.click("form:ajaxRefresh:myButton1");
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