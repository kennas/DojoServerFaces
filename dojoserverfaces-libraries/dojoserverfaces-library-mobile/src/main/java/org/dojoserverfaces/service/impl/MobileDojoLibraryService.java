package org.dojoserverfaces.service.impl;

import org.dojoserverfaces.service.DojoThemeHandler;
import org.dojoserverfaces.service.LibraryService;

public class MobileDojoLibraryService extends LibraryService {
    private String[] requiredDojoModules = { "dojox.mobile.common" };

    // TODO: create MobileThemeHandler
    private DojoThemeHandler themeHandler = null;

    @Override
    public String[] getRequiredDojoModules() {
        return requiredDojoModules;
    }

    @Override
    public DojoThemeHandler getThemeHandler() {
        return themeHandler;
    }
}
