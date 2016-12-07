/*******************************************************************************
 *      Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 *      Available via Academic Free License >= 2.1 OR the modified BSD license.
 *      see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.gadget;

import java.util.Collection;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;
import org.dojoserverfaces.constants.RendersChildren;
import org.dojoserverfaces.util.Helper;
import org.dojoserverfaces.widget.DojoWidget;
import org.dojoserverfaces.widget.property.DojoClass;

/**
 * InlineEditBox is best described as a behavior on some text on the page, such
 * that clicking that text brings up an editor, and when the text is saved, the
 * screen is reverted to it's original state (but with the new text). you can
 * use this tag as e.g. <dsf:inlineEditBox> <dsf:editor/> </dsf:inlineEditBox>
 * 
 */
@Gadget(dojoType = "dijit.InlineEditBox", rendersChildren = RendersChildren.YES_CUSTOM_RENDER)
public class InlineEditBox extends WidgetBase {
    /**
     * Class name (or reference to the Class) for Editor widget
     */
    @Property(handler = EditorHandler.class, exposed = false)
    Object editor;

    public static class EditorHandler extends
            org.dojoserverfaces.widget.property.Property implements DojoClass {

        public EditorHandler(String attributeName, String propertyName) {
            super(attributeName, propertyName);
        }

        public EditorHandler(String name) {
            super(name);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            for (UIComponent child : component.getChildren()) {
                DojoWidget dw = (DojoWidget) child;
                String editor = dw.getWidgetType().geTypeName();
                return Helper.quote(editor);
            }
            return null;
        }

        @Override
        public String getDojoType(UIComponent component) {
            for (UIComponent child : component.getChildren()) {
                DojoWidget dw = (DojoWidget) child;
                return dw.getWidgetType().geTypeName();
            }
            return null;
        }

        @Override
        public boolean isSet(UIComponent component) {
            return true;
        }

    }

    /**
     * Set of parameters for editor, like {required: true}
     */
    @Property(handler = EditorParamsHandler.class, exposed = false)
    Object editorParams;

    public static class EditorParamsHandler extends
            org.dojoserverfaces.widget.property.Property {

        public EditorParamsHandler(String attributeName, String propertyName) {
            super(attributeName, propertyName);
        }

        public EditorParamsHandler(String name) {
            super(name);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            for (UIComponent child : component.getChildren()) {
                DojoWidget dw = (DojoWidget) child;
                Collection<org.dojoserverfaces.widget.property.Property> properties = dw
                        .getPropertyHandlers();
                String jsonPropertySetting;
                StringBuilder widgetInitialization = new StringBuilder("{");
                boolean addComma = false;
                for (org.dojoserverfaces.widget.property.Property property : properties) {
                    if (null != (jsonPropertySetting = property
                            .getAsJsonPropertySetting(child))) {
                        if (addComma) {
                            widgetInitialization.append(',');
                        }
                        widgetInitialization.append(jsonPropertySetting);
                        addComma = true;
                    }
                }
                widgetInitialization.append("}");
                return widgetInitialization.toString();
            }
            return null;
        }

    }

    /**
     * Changing the value automatically saves it; don't have to push save button
     * (and save button isn't even displayed)
     */
    @Property
    Boolean autoSave;
    /**
     * Cancel button label
     */
    @Property
    String buttonCancel;
    /**
     * Save button label
     */
    @Property
    String buttonSave;
    /**
     * If true, clicking the InlineEditBox to edit it will have no effect.
     */
    @Property
    Boolean disabled;
    /**
     * If true, the widget can not be draggable. Defined only if
     * dojo.require("dojox.layout.GridContainerLite") is done
     */
    @Property
    Boolean dragRestriction;
    /**
     * Is the node currently in edit mode?
     */
    @Property
    Boolean editing;
    /**
     * This widget or a widget it contains has focus, or is "active" because it
     * was recently clicked.
     */
    @Property
    Boolean focused;
    /**
     * The label to display for a given widget
     */
    @Property
    String label;
    /**
     * The text that gets displayed when there is no value (so that the user has
     * a place to click to edit).if it is not set it has a default icon
     */
    @Property
    String noValueIndicator;
    /**
     * Set this to true if the specified Editor's value should be interpreted as
     * HTML rather than plain text (ex: dijit.Editor)
     */
    @Property
    Boolean renderAsHtml;
    /**
     * Width of editor. By default it's width=100% (ie, block mode).
     */
    @Property
    String width;

}
