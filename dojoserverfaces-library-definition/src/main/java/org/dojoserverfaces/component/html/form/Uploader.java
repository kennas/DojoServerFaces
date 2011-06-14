package org.dojoserverfaces.component.html.form;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.build.annotation.EditableValueHolder;
import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.constants.HtmlElementType;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.property.BooleanProperty;
import org.dojoserverfaces.widget.property.DojoClass;
import org.dojoserverfaces.widget.property.EnumPropertyBase;

/**
 * A bare-bones, stylable file-input button, with optional multi-file selection.
 * The list of files is not displayed, that is for you to handle by connecting
 * to the onChange event, or use the dojox.form.uploader.FileList. Uploader
 * without plugins does not have any ability to upload - it is for use in forms
 * where you handle the upload either by a standard POST or with Ajax using an
 * iFrame. This class is for convenience of multiple files only. No progress
 * events are available. If the browser supports a file-input with the
 * "multiple" attribute, that will be used. If the browser does not support
 * "multiple" (ergo, IE) multiple inputs are used, one for each selection.
 */
@EditableValueHolder(dojoType = "dojox.form.Uploader", elementType = HtmlElementType.MULTI_PART_FORM)
class Uploader extends UploaderBase {

    static class PluginProperty extends EnumPropertyBase implements DojoClass {
        private static final String PLUGIN_PKG = "dojox.form.uploader.plugins";
        private static final String[] validValues = { "iframe", "flash",
                "html5" };

        protected PluginProperty(String name, String propertyName) {
            super(name, propertyName, validValues);
        }

        @Override
        public String getAsJsonPropertySetting(UIComponent component) {
            return null;
        }

        @Override
        public String getDojoType(UIComponent component) {
            String value = (String) getAttributeValue(component);
            if (value == null) {
                value = "iframe"; // defaults to iframe
            }
            if ("iframe".equals(value)) {
                return PLUGIN_PKG + ".IFrame";
            }
            else if ("flash".equals(value)) {
                return PLUGIN_PKG + ".Flash";
            }
            else if ("html5".equals(value)) {
                return PLUGIN_PKG + ".HTML5";
            }
            return null;
        }
    }

    static class ForceProperty extends BooleanProperty {
        protected ForceProperty(String name, String propertyName) {
            super(name, propertyName);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            Boolean force = (Boolean) getAttributeValue(component);
            if (force == null) {
                force = true; // defaults to true
            }
            if (force) {
                String plugin = (String) Helper.getAttributeValue(component,
                        "plugin");
                if ("iframe".equals(plugin) || "flash".equals(plugin)) {
                    return Helper.quote(plugin);
                }
            }
            return null;
        }
    }

    /**
     * Supply an url to upload to.
     */
    @Property
    String url;

    /**
     * Is the text appended to the name property. This is necessary so the
     * server can tell what type of file data it is dealing with.
     */
    @Property
    String flashFieldName;

    /**
     * The text used in the button.
     */
    @Property
    String label;

    /**
     * Whether multiple files can or cannot be selected.
     */
    @Property
    Boolean multiple;

    /**
     * If true, uploads imediately after a file has been selected. If false,
     * waits for upload() to be called.
     */
    @Property
    Boolean uploadOnSelect;

    /**
     * Specify a plugin ("iframe", "flash") to use for upload
     */
    @Property(handler = PluginProperty.class)
    String plugin;

    /**
     * Force to use specified plugin ("iframe", "flash"), defaults to true.
     */
    @Property(handler = ForceProperty.class)
    Boolean force;

    /**
     * Defauts to "0". You ay change this to change the tab order on the page.
     */
    @Property
    Integer tabIndex;

    /**
     * Stub to connect Fires when upload in progress was canceled.
     */
    @Property
    String onAbort;

    /**
     * The event handler script to execute when upload begins.
     */
    @Event
    String onBegin;

    /**
     * The event handler script to execute when dialog box has been closed
     * without a file selection.
     */
    @Event
    String onCancel;

    /**
     * The event handler script to execute when files are selected Event is an
     * array of last files selected.
     */
    @Event
    String onChange;

    /**
     * The event handler script to execute on upload progress. Event is a
     * normalized object of common properties from HTML5 uploaders and the Flash
     * uploader. Will not fire for IFrame.
     */
    @Event
    String onProgress;

    /**
     * The event handler script to execute when all files have uploaded Event is
     * an array of all files.
     */
    @Event
    String onComplete;

    /**
     * The event handler script to execute when encountered errors.
     */
    @Event
    String onError;

}
