/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * The class works as a base class for the TestSuite which require Selenium
 * server to start and stop before and after execution of each class present in
 * the suite.
 * 
 * @author "jatin.varshney@in.ibm.com"
 * 
 */
public abstract class SeleniumTestSuite {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        SeleniumServerManager.getInstance().startSeleniumServer();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        SeleniumServerManager.getInstance().stopSeleniumServer();
    }
}