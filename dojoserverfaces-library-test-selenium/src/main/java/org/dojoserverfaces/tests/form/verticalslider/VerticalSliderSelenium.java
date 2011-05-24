/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.form.verticalslider;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import org.dojoserverfaces.tests.widget.values.VariableName;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

import junit.framework.Test;
import junit.framework.TestSuite;

public class VerticalSliderSelenium extends SeleniumTestCase {

    protected WidgetValues widgetValues;
    
    public VerticalSliderSelenium() {
        this.widgetValues = new VerticalSliderValues();
        this.widgetInteraction = new VerticalSliderInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                VerticalSliderSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/form/verticalslider/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The attribute 'style' could was not set as expected",
                "height: 300px;",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
        System.out
                .println("Style is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
        verifyEquals(
                "The attribute 'value' could was not set as expected",
                "10",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('value')"));
        System.out
                .println("Value is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('value')"));
        verifyEquals(
                "The attribute 'showButtons' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('showButtons')"));
        System.out
                .println("ShowButtons is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('showButtons')"));
        verifyEquals(
                "The attribute 'minimum' could was not set as expected",
                "0",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('minimum')"));
        System.out
                .println("Minimum is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('minimum')"));
        verifyEquals(
                "The attribute 'maximum' could was not set as expected",
                "100",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('maximum')"));
        System.out
                .println("Maximum is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('maximum')"));
        verifyEquals(
                "The attribute 'pageIncrement' could was not set as expected",
                "20",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('pageIncrement')"));
        System.out
                .println("PageIncrement is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('pageIncrement')"));
        verifyEquals(
                "The attribute 'clickSelect' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('clickSelect')"));
        System.out
                .println("ClickSelect is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('clickSelect')"));
        verifyEquals(
                "The attribute 'slideDuration' could was not set as expected",
                "500",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('slideDuration')"));
        System.out
                .println("SlideDuration is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('slideDuration')"));
        verifyEquals(
                "The attribute 'discreteValues' could was not set as expected",
                "21",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('discreteValues')"));
        System.out
                .println("DiscreteValues is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('discreteValues')"));
        verifyEquals(
                "The attribute 'style' could was not set as expected",
                "width: 1.2em; fontSize: 75%;",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:leftLabels').get('style')"));
        System.out
                .println("Style is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:leftLabels').get('style')"));
        verifyEquals(
                "The attribute 'count' could was not set as expected",
                "6",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:leftLabels').get('count')"));
        System.out
                .println("Count is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:leftLabels').get('count')"));
        verifyEquals(
                "The attribute 'numericMargin' could was not set as expected",
                "1",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:leftLabels').get('numericMargin')"));
        System.out
                .println("NumericMargin is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:leftLabels').get('numericMargin')"));
        verifyEquals(
                "The attribute 'container' could was not set as expected",
                "leftDecoration",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:leftLabels').get('container')"));
        System.out
                .println("Container is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:leftLabels').get('container')"));
        verifyEquals(
                "The attribute 'count' could was not set as expected",
                "6",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:leftRule').get('count')"));
        System.out
                .println("Count is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:leftRule').get('count')"));
        verifyEquals(
                "The attribute 'style' could was not set as expected",
                "width: 5px;",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:leftRule').get('style')"));
        System.out
                .println("Style is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:leftRule').get('style')"));
        verifyEquals(
                "The attribute 'container' could was not set as expected",
                "leftDecoration",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:leftRule').get('container')"));
        System.out
                .println("Container is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:leftRule').get('container')"));
        verifyEquals(
                "The attribute 'count' could was not set as expected",
                "5",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:rightRule').get('count')"));
        System.out
                .println("Count is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:rightRule').get('count')"));
        verifyEquals(
                "The attribute 'style' could was not set as expected",
                "width: 5px;",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:rightRule').get('style')"));
        System.out
                .println("Style is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:rightRule').get('style')"));
        verifyEquals(
                "The attribute 'container' could was not set as expected",
                "rightDecoration",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:rightRule').get('container')"));
        System.out
                .println("Container is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:rightRule').get('container')"));
        verifyEquals(
                "The attribute 'style' could was not set as expected",
                "width: 1em; fontSize: 75%;",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:rightLabels').get('style')"));
        System.out
                .println("Style is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:rightLabels').get('style')"));
        verifyEquals(
                "The attribute 'container' could was not set as expected",
                "rightDecoration",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:rightLabels').get('container')"));
        System.out
                .println("Container is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:rightLabels').get('container')"));
    }

    public void testAjaxRefresh() throws Exception {
        waitForDojoReady();
        String valueBeforeClick = selenium
                .getEval("window.document.getElementById('form:ajaxRefresh:outputAjaxCall').innerHTML");
        System.out
                .println("Value Before Click-------->>>>>"
                        + selenium
                                .getEval("window.document.getElementById('form:ajaxRefresh:outputAjaxCall').innerHTML"));
        verifyEquals(
                "The value of the component having f:ajax call did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction.getValue("form:ajaxRefresh:widgetAjaxCall"));
        widgetInteraction.setValue("form:ajaxRefresh:widgetAjaxCall",
                VariableName.SECOND);
        selenium.click("getFocusBtn");
        System.out.println("*********Button Got Clicked**********");
        verifyEquals(
                "The component's value did not change even after entering new value",
                widgetValues.getSeleniumValues(VariableName.SECOND),
                widgetInteraction.getValue("form:ajaxRefresh:widgetAjaxCall"));
        String valueAfterClick = selenium
                .getEval("window.document.getElementById('form:ajaxRefresh:outputAjaxCall').innerHTML");
        System.out
                .println("Value After Click-------->>>>>"
                        + selenium
                                .getEval("window.document.getElementById('form:ajaxRefresh:outputAjaxCall').innerHTML"));
        if ((!(valueBeforeClick.equals(valueAfterClick))))
            System.out.println("******Testcase Passed.******");
        else
            System.out.println("******Testcase Failed.******");
    }
}