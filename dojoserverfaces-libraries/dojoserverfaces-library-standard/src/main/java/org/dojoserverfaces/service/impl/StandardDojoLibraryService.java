/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.service.impl;

import org.dojoserverfaces.service.DojoThemeHandler;
import org.dojoserverfaces.service.LibraryService;

/**
 * Library Service for DojoServiceFaces Standard Library
 */
public class StandardDojoLibraryService extends LibraryService {
    private DojoThemeHandler themeHandler = new StandardDojoThemeHandler();

    @Override
    public String[] getRequiredDojoModules() {
        return null;
    }

    @Override
    public DojoThemeHandler getThemeHandler() {
        return themeHandler;
    }
}
