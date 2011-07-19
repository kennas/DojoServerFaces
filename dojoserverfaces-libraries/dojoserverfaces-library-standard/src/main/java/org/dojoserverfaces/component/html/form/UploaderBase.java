package org.dojoserverfaces.component.html.form;

import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;

abstract class UploaderBase extends WidgetBase {
    /**
     * If you don't supply an action in your form, supply an url to upload to
     */
    @Property
    String url;
}
