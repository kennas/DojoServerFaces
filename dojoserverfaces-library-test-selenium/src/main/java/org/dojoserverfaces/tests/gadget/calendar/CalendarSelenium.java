/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.gadget.calendar;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import org.dojoserverfaces.tests.widget.values.VariableName;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

import junit.framework.Test;
import junit.framework.TestSuite;

public class CalendarSelenium extends SeleniumTestCase {

    protected WidgetValues widgetValues;
    
    public CalendarSelenium() {
        this.widgetValues = new CalendarValues();
        this.widgetInteraction = new CalendarInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                CalendarSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-jsfdojo-library-test-selenium/dojoserverfaces/gadget/calendar/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The element 'dayWidth' is not present",
                "abbr",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('dayWidth')"));
        System.out
                .println("DayWidth ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('dayWidth')"));
    }

    public void testAjaxRefresh() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The value of the component having f:ajax call did not match",
                widgetValues.getSeleniumValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:ajaxRefresh:widgetAjax"));
        // Verify Ajax call to update bean value.
        widgetInteraction.setDisplayedValue("form:ajaxRefresh:widgetAjax",
                VariableName.SECOND);
        selenium.click("form:ajaxRefresh:button");
        verifyEquals(
                "The component's value did not change even after entering new value",
                widgetValues.getSeleniumValues(VariableName.SECOND),
                widgetInteraction
                        .getDisplayedValue("form:ajaxRefresh:widgetAjax"));
        waitForTextToChange(
                "The Ajax call to update bean value was not successful",
                widgetValues.getValues(VariableName.SECOND),
                "form:ajaxRefresh:ajaxCall");
    }
}