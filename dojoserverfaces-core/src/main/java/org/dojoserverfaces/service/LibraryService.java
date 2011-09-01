/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * This class defines a service interface so that standard and mobile can
 * provide different service implementation to do some initialization work
 */
public abstract class LibraryService {
    private static LibraryService instance = null;

    static {
        Iterator<LibraryService> iterator = ServiceLoader.load(
                LibraryService.class).iterator();
        if (iterator.hasNext()) {
            instance = iterator.next();
        }
    }

    /**
     * @return instance of LibraryService which is loaded by ServiceLoader
     */
    public static LibraryService getInstance() {
        return instance;
    }

    /**
     * @return required dojo modules that needed for all dojo applications
     */
    public abstract String[] getRequiredDojoModules();

    /**
     * @return a DojoThemeHandler that will handler theme related issues
     */
    public abstract DojoThemeHandler getThemeHandler();
}
