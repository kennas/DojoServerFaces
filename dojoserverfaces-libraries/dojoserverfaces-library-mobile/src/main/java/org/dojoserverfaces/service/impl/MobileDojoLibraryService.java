/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.service.impl;

import org.dojoserverfaces.service.DojoThemeHandler;
import org.dojoserverfaces.service.LibraryService;

public class MobileDojoLibraryService extends LibraryService {
    private String[] requiredDojoModules = { "dojox.mobile.common" };

    // create MobileThemeHandler
    private DojoThemeHandler themeHandler = new MobileDojoThemeHandler();

    @Override
    public String[] getRequiredDojoModules() {
        return requiredDojoModules;
    }

    @Override
    public DojoThemeHandler getThemeHandler() {
        return themeHandler;
    }
}
