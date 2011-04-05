/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.selenium;

import org.openqa.selenium.server.SeleniumServer;

public class SeleniumServerManager {
    private static final SeleniumServerManager instance = new SeleniumServerManager();

    public static SeleniumServerManager getInstance() {
        return instance;
    }

    private SeleniumServer server = null;

    protected SeleniumServerManager() {
    }

    public void startSeleniumServer() {
        if (server == null) {
            try {
                server = new SeleniumServer();

            }
            catch (Exception e) {
                System.err.println("Error during creation of Selenium server: "
                        + e.getMessage());
                e.printStackTrace();
            }
        }
        try {
            System.out.println("Trying to start the Selenium server...");
            server.start();
        }
        catch (Exception e) {
            System.err.println("Error during Selenium server start: "
                    + e.getMessage());
            e.printStackTrace();
        }
    }

    public void stopSeleniumServer() {
        if (server != null) {
            try {
                System.out.println("Trying to stop the Selenium server...");
                server.stop();
                server = null;
            }
            catch (Exception e) {
                System.err.println("Error during Selenium server stop: "
                        + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}