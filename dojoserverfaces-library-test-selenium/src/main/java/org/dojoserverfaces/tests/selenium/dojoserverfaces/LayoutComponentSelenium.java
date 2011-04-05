/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.selenium.dojoserverfaces;

import org.dojoserverfaces.tests.selenium.SeleniumTestCase;
import org.dojoserverfaces.tests.widget.values.WidgetValues;

public abstract class LayoutComponentSelenium extends SeleniumTestCase {

    protected WidgetValues widgetValues;

    /**
     * Test if the initial values of components bound to managed bean are
     * reflected properly in the output.
     * 
     * @throws Exception
     */
    public void testSelfProperties() throws Exception {
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
        verifyEquals(
                "The attribute 'region' could was not set as expected",
                "right",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('region')"));
        System.out
                .println("Region is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('region')"));
        verifyEquals(
                "The attribute 'splitter' could was not set as expected",
                "true",
                selenium
                        .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('splitter')"));
        System.out
                .println("Splitter is----->>>>"
                        + selenium
                                .getEval("window.dijit.byId('form:initialValues:widgetSimple').get('splitter')"));
    }

    public void testAjaxRefresh() throws Exception {
        
    };
}