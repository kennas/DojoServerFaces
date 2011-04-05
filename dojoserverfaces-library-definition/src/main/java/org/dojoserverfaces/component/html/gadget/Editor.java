/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.gadget;

import javax.faces.component.UIComponent;

import org.dojoserverfaces.build.annotation.Event;
import org.dojoserverfaces.build.annotation.Gadget;
import org.dojoserverfaces.build.annotation.Property;
import org.dojoserverfaces.component.html.WidgetBase;
import org.dojoserverfaces.widget.property.DimensionProperty;
import org.dojoserverfaces.widget.property.ElementIdProperty;
import org.dojoserverfaces.widget.property.EventHandlerProperty;
import org.dojoserverfaces.widget.property.PostCreateScript;
import org.dojoserverfaces.widget.property.StringArrayProperty;

/**
 * This component provides basic WYSIWYG editing features, based on the
 * browser's underlying rich text editing capability, accompanied by a toolbar
 * (`dijit.Toolbar`). A plugin model is available to extend the editor's
 * capabilities as well as the the options available in the toolbar. Content
 * generation may vary across browsers, and clipboard operations may have
 * different results, to name a few limitations.
 */
@Gadget(dojoType = "dijit.Editor")
class Editor extends WidgetBase {

    public static class OnLoadDeferredProperty extends EventHandlerProperty
            implements PostCreateScript {

        public OnLoadDeferredProperty(String propertyName, String behaviorName) {
            super(propertyName, behaviorName);
        }

        @Override
        public String getAsPropertyValue(UIComponent component) {
            // this property does not work when set in constructor
            return null;
        }

        @Override
        public String getPostCreateInitialization(UIComponent component,
                String widget) {
            return new StringBuilder(widget).append('.')
                    .append(this.getPropertyName()).append(".addCallback(")
                    .append(super.getAsPropertyValue(component)).append(");")
                    .toString();
        }

    }

    /**
     * Indicate whether to inherit the parent's width or simply use 100%
     */
    @Property
    Boolean inheritWidth;

    /**
     * Specifies the name of a (hidden) <textarea> node on the page that's used
     * to save the editor content on page leave. Used to restore editor contents
     * after navigating to a new page and then hitting the back button.
     */
    // TODO ??? what if empty?
    @Property(handler = ElementIdProperty.class)
    String name;

    /**
     * A semicolon (";") separated list of css files for the editing area
     */
    // TODO the javascript code defined this as [const] String"
    // does that just mean it can only be set once?
    @Property
    String styleSheets;

    /**
     * Set height to fix the editor at a specific height, with scrolling. By
     * default, this is 300px. If you want to have the editor always resizes to
     * accommodate the content, use AlwaysShowToolbar plugin and set height="".
     * If this editor is used within a layout widget, set height="100%". Default
     * is 300px.
     */
    @Property(handler = DimensionProperty.class)
    String height;

    /**
     * The minimum height that the editor should have.
     */
    @Property(handler = DimensionProperty.class)
    String minHeight;

    /**
     * Make tab key and shift-tab indent and outdent rather than navigating.
     * Default is false. Caution: Using this makes web pages inaccessible to
     * users unable to use a mouse.
     */
    @Property
    Boolean isTabIndent;

    /**
     * When true, disables the browser's native spell checking, if supported.
     * Works only in Firefox. Default is false.
     */
    @Property
    Boolean disableSpellCheck;
    
    /**
     * A list of plugin names (as strings) or instances (as objects) for this
     * widget. When declared in markup, it might look like: plugins=
     * "['bold',{name:'dijit._editor.plugins.FontChoice', command:'fontName', generic:true}]"
     */
    @Property(handler = StringArrayProperty.class)
    Object plugins;
    
    /**
     * Fired when the editor finishes initializing.
     */
    @Event(handler = OnLoadDeferredProperty.class)
    String onLoadDeferred;
    // see - http://bugs.dojotoolkit.org/ticket/12067
    // TODO think about renaming this to onLoad
    
    /**
     * Whether we shall use custom undo/redo support instead of the native
     * browser support. By default, we only enable customUndo for IE, as it has
     * broken native undo/redo support. Note: the implementation does support
     * other browsers which have W3C DOM2 Range API implemented. It was also
     * enabled on WebKit, to fix undo/redo enablement. (#9613)
     */
    @Property
    Boolean customUndo;
    /**
     * When using customUndo, not every keystroke will be saved as a step.
     * Instead typing (including delete) will be grouped together: after a user
     * stops typing for editActionInterval seconds, a step will be saved; if a
     * user resume typing within editActionInterval seconds, the timeout will be
     * restarted. By default, editActionInterval is 3 seconds.
     */
    @Property
    Integer editActionInterval;
}
