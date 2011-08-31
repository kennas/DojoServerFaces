package org.dojoserverfaces.service.impl;

import org.dojoserverfaces.service.DojoThemeHandler;
import org.dojoserverfaces.service.LibraryService;

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
