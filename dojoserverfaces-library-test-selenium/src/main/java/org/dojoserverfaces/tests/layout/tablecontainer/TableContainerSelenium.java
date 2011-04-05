/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.layout.tablecontainer;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.widget.values.VariableName;
import org.dojoserverfaces.tests.selenium.dojoserverfaces.LayoutComponentSelenium;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TableContainerSelenium extends LayoutComponentSelenium {

    public TableContainerSelenium() {
        this.widgetValues = new TableContainerValues();
        this.widgetInteraction = new TableContainerInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                TableContainerSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/layout/tableContainer/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The element 'cols' is not present",
                "1",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('cols')"));
        System.out
                .println("Cols ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('cols')"));
        verifyEquals(
                "The element 'labelWidth' is not present",
                "20%",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('labelWidth')"));
        System.out
                .println("LabelWidth ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('labelWidth')"));
        verifyEquals(
                "The element 'showLabels' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('showLabels')"));
        System.out
                .println("ShowLabels ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('showLabels')"));
        verifyEquals(
                "The element 'orientation' is not present",
                "horiz",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('orientation')"));
        System.out
                .println("Orientation ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('orientation')"));
        verifyEquals(
                "The element 'spacing' is not present",
                "1",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('spacing')"));
        System.out
                .println("Spacing ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('spacing')"));
        verifyEquals(
                "The element 'tooltip' is not present",
                "This is Table Container.",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltip')"));
        System.out
                .println("Tooltip ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltip')"));
        verifyEquals(
                "The element 'colspan' is not present",
                "2",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('colspan')"));
        System.out
                .println("Colspan ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('colspan')"));
        verifyEquals(
                "The element 'spanLabel' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('spanLabel')"));
        System.out
                .println("SpanLabel ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('spanLabel')"));
    }

    public void testInheritedLayoutComponentsProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The attribute 'style' could was not set as expected",
                "width: 400px; height: 100px;",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
        System.out
                .println("Style ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('style')"));
    }

    public void testAjaxRefresh() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The value of the component having f:ajax call did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction.getDisplayedValue("form:ajaxRefresh:textBox"));
        // Verify Ajax call to update bean value.
        widgetInteraction.setDisplayedValue("form:ajaxRefresh:textBox",
                VariableName.SECOND);
        selenium.click("getFocusBtn");
        verifyEquals(
                "The component's value did not change even after entering new value",
                widgetValues.getSeleniumValues(VariableName.SECOND),
                widgetInteraction.getDisplayedValue("form:ajaxRefresh:textBox"));
        waitForTextToChange(
                "The Ajax call to update bean value was not successful",
                widgetValues.getValues(VariableName.SECOND),
                "form:ajaxRefresh:outputAjaxCall");
    }
}