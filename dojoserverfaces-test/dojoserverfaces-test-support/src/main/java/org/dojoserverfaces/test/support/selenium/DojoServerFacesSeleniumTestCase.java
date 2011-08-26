/*******************************************************************************
 *   Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *   Available via Academic Free License >= 2.1 OR the modified BSD license.
 *   see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.test.support.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.thoughtworks.selenium.SeleneseTestBase;

/**
 * The DojoServerFacesSeleniumTestCase defines a Selenium test case used for
 * DojoServerFaces testing.
 */

public class DojoServerFacesSeleniumTestCase extends SeleneseTestBase {
     private static final String PARAM_BROWSER = "test.browser";
     private static final String PARAM_HOST_SERVER = "test.host.server";
     private static final String PARAM_PORT_SERVER = "test.port.server";
     
     protected StringBuffer verificationErrors = new StringBuffer();
     private String contextRoot;
     protected WebDriver driver;
     
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
          String serverHost;
          int serverPort = 8080;
          
          // Collect the test parameters (hosts and ports).
          
          browser = System.getProperty
               (DojoServerFacesSeleniumTestCase.PARAM_BROWSER);
          serverHost = System.getProperty
               (DojoServerFacesSeleniumTestCase.PARAM_HOST_SERVER);
          
          if (browser == null) {
               browser = "firefox";
          }
          
          browser = browser.toLowerCase().trim();
          
          if (serverHost == null) {
               serverHost = "localhost";
          }
          
          try {
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
          
          WebDriver tmpDriver;
          if (browser.equals ("chrome")) {
        	  tmpDriver = new ChromeDriver();
          }
          
          else if (browser.equals ("firefox")) {
        	  tmpDriver = new FirefoxDriver();
          }
          
          else if (browser.equals ("htmlunit")) {
        	  tmpDriver = new HtmlUnitDriver();
               
               ((HtmlUnitDriver) tmpDriver).setJavascriptEnabled (true);
               
          } else {
        	  //defaulting to htmlunit if none of the above were set - this may need a better default.
        	  tmpDriver = new HtmlUnitDriver();
              
              ((HtmlUnitDriver) tmpDriver).setJavascriptEnabled (true);
             
          }
          
          this.driver = new WebDriverWrapper(tmpDriver, serverHost, serverPort, contextRoot);
          
          // Set timeout 
          //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          

     }
     
}
