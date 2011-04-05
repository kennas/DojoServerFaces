/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.gadget.richtexteditor;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.dojoserverfaces.LayoutComponentSelenium;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RichTextEditorSelenium extends LayoutComponentSelenium {

    public RichTextEditorSelenium() {
        this.widgetValues = new RichTextEditorValues();
        this.widgetInteraction = new RichTextEditorInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                RichTextEditorSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/gadget/richtexteditor/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The attribute 'inheritWidth' could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('inheritWidth')"));
        System.out
                .println("InheritWidth is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('inheritWidth')"));
        verifyEquals(
                "The attribute 'name' could was not set as expected",
                "description",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('name')"));
        System.out
                .println("Name is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('name')"));
        verifyEquals(
                "The attribute 'height' could was not set as expected",
                "300px",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('height')"));
        System.out
                .println("Height is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('height')"));
        verifyEquals(
                "The attribute 'minHeight' could was not set as expected",
                "100px",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('minHeight')"));
        System.out
                .println("MinHeight is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('minHeight')"));
        verifyEquals(
                "The attribute 'isTabIndent' could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('isTabIndent')"));
        System.out
                .println("IsTabIndent is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('isTabIndent')"));
        verifyEquals(
                "The attribute 'disableSpellCheck' could was not set as expected",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('disableSpellCheck')"));
        System.out
                .println("DisableSpellCheck is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('disableSpellCheck')"));
        verifyEquals(
                "The attribute 'customUndo' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('customUndo')"));
        System.out
                .println("CustomUndo is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('customUndo')"));
        verifyEquals(
                "The attribute 'editActionInterval' could was not set as expected",
                "5",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('editActionInterval')"));
        System.out
                .println("EditActionInterval is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('editActionInterval')"));
        verifyEquals(
                "The attribute 'style' could was not set as expected",
                "width: 500px",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
        System.out
                .println("Style is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
    }

    public void testAjaxRefresh() throws Exception {
        waitForDojoReady();
        String valueBeforeClick = selenium
                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('value')");
        System.out
                .println("Value Before Click-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('value')"));
        selenium.click("form:ajaxRefresh:toTextAreaButton");
        System.out.println("*********Button1 Got Clicked**********");
        selenium.click("form:ajaxRefresh:toEditorButton");
        System.out.println("*********Button2 Got Clicked**********");
        String valueAfterClick = selenium
                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('value')");
        System.out
                .println("Value After Click-------->>>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:ajaxRefresh:widgetAjaxCall').get('value')"));
        if ((!(valueBeforeClick.equals(valueAfterClick))))
            System.out.println("******Testcase Passed.******");
        else
            System.out.println("******Testcase Failed.******");
    }
}