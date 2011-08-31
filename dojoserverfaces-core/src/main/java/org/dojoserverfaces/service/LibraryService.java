package org.dojoserverfaces.service;

import java.util.Iterator;
import java.util.ServiceLoader;

public abstract class LibraryService {
    private static LibraryService instance = null;

    static {
        Iterator<LibraryService> iterator = ServiceLoader.load(
                LibraryService.class).iterator();
        if (iterator.hasNext()) {
            instance = iterator.next();
        }
    }

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
