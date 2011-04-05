/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.layout.gridcontainer;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.dojoserverfaces.LayoutComponentSelenium;
import junit.framework.Test;
import junit.framework.TestSuite;

public class GridContainerSelenium extends LayoutComponentSelenium {

    public GridContainerSelenium() {
        this.widgetValues = new GridContainerValues();
        this.widgetInteraction = new GridContainerInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                GridContainerSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/layout/gridContainer/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The element 'hasResizableColumns' is not present",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('hasResizableColumns')"));
        System.out
                .println("HasResizableColumns ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('hasResizableColumns')"));
        verifyEquals(
                "The element 'liveResizeColumns' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('liveResizeColumns')"));
        System.out
                .println("LiveResizeColumns ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('liveResizeColumns')"));
        verifyEquals(
                "The element 'minColWidth' is not present",
                "50",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('minColWidth')"));
        System.out
                .println("MinColWidth ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('minColWidth')"));
        verifyEquals(
                "The element 'mode' is not present",
                "left",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('mode')"));
        System.out
                .println("Orientation ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('mode')"));
        verifyEquals(
                "The element 'isRightFixed' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('isRightFixed')"));
        System.out
                .println("IsRightFixed ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('isRightFixed')"));
        verifyEquals(
                "The element 'isLeftFixed' is not present",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('isLeftFixed')"));
        System.out
                .println("IsLeftFixed ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('isLeftFixed')"));
        verifyEquals(
                "The element 'autoRefresh' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('autoRefresh')"));
        System.out
                .println("AutoRefresh ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('autoRefresh')"));
        verifyEquals(
                "The element 'dragHandleClass' is not present",
                "jd:titlePane",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('dragHandleClass')"));
        System.out
                .println("DragHandleClass ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('dragHandleClass')"));
        verifyEquals(
                "The element 'nbZones' is not present",
                "3",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('nbZones')"));
        System.out
                .println("NbZones ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('nbZones')"));
        verifyEquals(
                "The element 'doLayout' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('doLayout')"));
        System.out
                .println("DoLayout ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('doLayout')"));
        verifyEquals(
                "The element 'isAutoOrganized' is not present",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('isAutoOrganized')"));
        System.out
                .println("IsAutoOrganized ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('isAutoOrganized')"));
        verifyEquals(
                "The element 'colWidths' is not present",
                "50",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('colWidths')"));
        System.out
                .println("ColWidths ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('colWidths')"));
        verifyEquals(
                "The element 'column' is not present",
                "4",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('column')"));
        System.out
                .println("column ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('column')"));
        verifyEquals(
                "The element 'dragRestriction' is not present",
                "false",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('dragRestriction')"));
        System.out
                .println("DragRestriction ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('dragRestriction')"));
        verifyEquals(
                "The element 'tooltip' is not present",
                "This is Grid Container.",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltip')"));
        System.out
                .println("Tooltip ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('tooltip')"));
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