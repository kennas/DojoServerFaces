/*******************************************************************************
 *   Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *   Available via Academic Free License >= 2.1 OR the modified BSD license.
 *   see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.selenium;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

/**
 * The DojoServerFacesSeleniumTestCase defines a Selenium test case used for
 * DojoServerFaces testing.
 */

public class DojoServerFacesSeleniumTestCase extends SeleneseTestCase {
     private static final String PARAM_BROWSER = "test.browser";
     private static final String PARAM_HOST_SELENIUM_SERVER =
          "test.host.selenium.server";
     private static final String PARAM_HOST_SERVER = "test.host.server";
     private static final String PARAM_PORT_SELENIUM_SERVER =
          "test.port.selenium.server";
     private static final String PARAM_PORT_SERVER = "test.port.server";
     
     private String contextRoot;
     
     /**
      * Creates a DojoServerFacesSeleniumTestCase object.
      */
     
     public DojoServerFacesSeleniumTestCase () {
          super();
     }
     
     /**
      * Performs test setup.
      * 
      * @param contextRootProperty a String containing the context root to
      *        associate with this test case.
      * @throws Exception if an error occurs while performing test setup.
      */
     
     protected void setUpTestCase (String contextRootProperty)
          throws Exception {
          String browser;
          String seleniumHost;
          int seleniumPort = 4444;
          String serverHost;
          int serverPort = 8080;
          
          // Collect the test parameters (hosts and ports).
          
          browser = System.getProperty
               (DojoServerFacesSeleniumTestCase.PARAM_BROWSER);
          seleniumHost = System.getProperty
               (DojoServerFacesSeleniumTestCase.PARAM_HOST_SELENIUM_SERVER);
          serverHost = System.getProperty
               (DojoServerFacesSeleniumTestCase.PARAM_HOST_SERVER);
          
          if (browser == null) {
               browser = "*chrome";
          }
          
          if (seleniumHost == null) {
               seleniumHost = "localhost";
          }
          
          if (serverHost == null) {
               serverHost = "localhost";
          }
          
          try {
               seleniumPort = Integer.parseInt (System.getProperty
                    (DojoServerFacesSeleniumTestCase.PARAM_PORT_SELENIUM_SERVER));
               serverPort = Integer.parseInt (System.getProperty
                    (DojoServerFacesSeleniumTestCase.PARAM_PORT_SERVER));
          }
          
          catch (Throwable e) {
               // Ignore, we have defaults.
          }
          
          // Set up the context root.
          
          this.contextRoot = System.getProperty (contextRootProperty);
          
          if (this.contextRoot == null) {
               this.contextRoot = "";
          }
          
          // Create the Selenium object.
          
          this.selenium = new DefaultSelenium (seleniumHost, seleniumPort,
               browser, "http://" + serverHost + ":" + serverPort + "/");
          
          this.selenium.start();
     }
     
     /**
      * Opens a URL via Selenium using the context root associated with this
      * test case.
      * 
      * @param url a String containing the URL to use.
      */
     
     protected void seleniumOpen (String url) {
          this.selenium.open (this.contextRoot + "/" + url);
     }
}
