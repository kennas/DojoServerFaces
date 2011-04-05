/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.data.datagrid;

import org.dojoserverfaces.tests.selenium.SeleniumSetupSuite;
import org.dojoserverfaces.tests.selenium.dojoserverfaces.LayoutComponentSelenium;
import junit.framework.Test;
import junit.framework.TestSuite;

public class DataGridSelenium extends LayoutComponentSelenium {

    public DataGridSelenium() {
        this.widgetValues = new DataGridValues();
        this.widgetInteraction = new DataGridInteraction(widgetValues);
    }

    private static SeleniumSetupSuite seleniumSetupSuite;

    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                DataGridSelenium.class));
        return seleniumSetupSuite;
    }

    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium.open("http://localhost:8080/eclipse-dojoserverfaces-library-test-selenium/dojoserverfaces/data/datagrid/index.jsf");
        }
    }

    public void testSelfProperties() throws Exception {
        waitForDojoReady();
        verifyEquals(
                "The element 'selectable' is not present",
                "true",
                selenium.getEval("window.dijit.byId('widgetSimple').get('selectable')"));
        System.out
                .println("selectable ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('selectable')"));
        verifyEquals(
                "The element 'selectable' is not present",
                "false",
                selenium.getEval("window.dijit.byId('widgetSimple2').get('selectable')"));
        System.out
                .println("selectable ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple2').get('selectable')"));

        verifyEquals(
                "The element 'selectionMode' is not present",
                "single",
                selenium.getEval("window.dijit.byId('widgetSimple').get('selectionMode')"));
        System.out
                .println("selectionMode ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('selectionMode')"));

        verifyEquals(
                "The element 'selectionMode' is not present",
                "multiple",
                selenium.getEval("window.dijit.byId('widgetSimple2').get('selectionMode')"));
        System.out
                .println("selectionMode ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple2').get('selectionMode')"));
        verifyEquals(
                "The element 'loadingMessage' is not present",
                "loading....",
                selenium.getEval("window.dijit.byId('widgetSimple').get('loadingMessage')"));
        System.out
                .println("loadingMessage ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('loadingMessage')"));
        verifyEquals(
                "The element 'autoHeight' is not present",
                "3",
                selenium.getEval("window.dijit.byId('widgetSimple').get('autoHeight')"));
        System.out
                .println("autoHeight ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('autoHeight')"));
        verifyEquals(
                "The element 'singleClickEdit' is not present",
                "true",
                selenium.getEval("window.dijit.byId('widgetSimple').get('singleClickEdit')"));
        System.out
                .println("singleClickEdit ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('singleClickEdit')"));
        verifyEquals(
                "The element 'singleClickEdit' is not present",
                "false",
                selenium.getEval("window.dijit.byId('widgetSimple2').get('singleClickEdit')"));
        System.out
                .println("singleClickEdit ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple2').get('singleClickEdit')"));

        verifyEquals(
                "The element 'rowSelector' is not present",
                "20px",
                selenium.getEval("window.dijit.byId('widgetSimple').get('rowSelector')"));
        System.out
                .println("rowSelector ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('rowSelector')"));
        verifyEquals(
                "The element 'defaultcell options' is not present",
                "countries,continent,city",
                selenium.getEval("window.dijit.byId('widgetSimple').get('structure')[0].defaultCell.options"));
        System.out
                .println("defaultCell options ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('structure')[0].defaultCell.options"));
        verifyEquals(
                "The element 'defaultCell field' is not present",
                "id",
                selenium.getEval("window.dijit.byId('widgetSimple').get('structure')[0].defaultCell.field"));
        System.out
                .println("defaultCell field ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('structure')[0].defaultCell.field"));
        verifyEquals(
                "The element 'defaultCell name' is not present",
                "countrycode",
                selenium.getEval("window.dijit.byId('widgetSimple').get('structure')[0].defaultCell.name"));
        System.out
                .println("defaultCell name ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('structure')[0].defaultCell.name"));
        verifyEquals(
                "The element 'defaultCell editable' is not present",
                "true",
                selenium.getEval("window.dijit.byId('widgetSimple').get('structure')[0].defaultCell.editable"));
        System.out
                .println("defaultCell editable ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('structure')[0].defaultCell.editable"));
        verifyEquals(
                "The element 'defaultCell width' is not present",
                "200px",
                selenium.getEval("window.dijit.byId('widgetSimple').get('structure')[0].defaultCell.width"));
        System.out
                .println("defaultCell width ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('structure')[0].defaultCell.styles"));
        verifyEquals(
                "The element 'defaultCell styles' is not present",
                "text-align: right;",
                selenium.getEval("window.dijit.byId('widgetSimple').get('structure')[0].defaultCell.styles"));
        System.out
                .println("defaultcell styles ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('structure')[0].defaultCell.styles"));

        verifyEquals(
                "The element 'cell field' is not present",
                "name",
                selenium.getEval("window.dijit.byId('widgetSimple').get('structure')[0].cells[1].field"));
        System.out
                .println("cell field ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('structure')[0].cells[1].field"));
        verifyEquals(
                "The element 'cell name' is not present",
                "countryname",
                selenium.getEval("window.dijit.byId('widgetSimple').get('structure')[0].cells[1].name"));
        System.out
                .println("cell name ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('structure')[0].cells[1].name"));
        verifyEquals(
                "The element 'cell editable' is not present",
                "false",
                selenium.getEval("window.dijit.byId('widgetSimple').get('structure')[0].cells[0].editable"));
        System.out
                .println("cell editable ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('structure')[0].cells[0].editable"));
        verifyEquals(
                "The element 'cell width' is not present",
                "200px",
                selenium.getEval("window.dijit.byId('widgetSimple').get('structure')[0].cells[2].width"));
        System.out
                .println("cell width ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('structure')[0].cells[2].width"));
        verifyEquals(
                "The element 'cell styles' is not present",
                "text-align: left;",
                selenium.getEval("window.dijit.byId('widgetSimple').get('structure')[0].cells[0].styles"));
        System.out
                .println("cell styles ----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('structure')[0].cells[0].styles"));

        verifyEquals(
                "The element 'view noscroll' is not present",
                "true",
                selenium.getEval("window.dijit.byId('widgetSimple').get('structure')[0].noscroll"));
        System.out
                .println("view noscroll----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('widgetSimple').get('structure')[0].noscroll"));

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