/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.gadget.tooltip;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import org.dojoserverfaces.tests.widget.values.VariableName;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TooltipSelenium extends SeleniumTestCase {

    protected WidgetValues widgetValues;
    
    public TooltipSelenium() {
        this.widgetValues = new TooltipValues();
        this.widgetInteraction = new TooltipInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                TooltipSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/gadget/tooltip/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The element 'label' is not present",
                "This is DojoServerFaces Tooltip.",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('label')"));
        System.out
                .println("Label ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('label')"));
        verifyEquals(
                "The element 'showDelay' is not present",
                "400",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('showDelay')"));
        System.out
                .println("ShowDelay ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('showDelay')"));
        verifyEquals(
                "The element 'position' is not present",
                "above",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('position')"));
        System.out
                .println("Position ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('position')"));
        verifyEquals(
                "The element 'style' is not present",
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
        String valueBeforeClick = selenium
                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML");
        System.out
                .println("Value Before Click-------->>>>>"
                        + selenium
                                .getEval("window.document.getElementById('form:ajaxRefresh:text1').innerHTML"));
        verifyEquals(
                "The value of the component having f:ajax call did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction.getDisplayedValue("form:ajaxRefresh:textBox"));
        widgetInteraction.setDisplayedValue("form:ajaxRefresh:textBox",
                VariableName.SECOND);
        selenium.click("form:ajaxRefresh:apply");
        System.out.println("*********Button Got Clicked**********");
        verifyEquals(
                "The component's value did not change even after entering new value",
                widgetValues.getSeleniumValues(VariableName.SECOND),
                widgetInteraction.getDisplayedValue("form:ajaxRefresh:textBox"));
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