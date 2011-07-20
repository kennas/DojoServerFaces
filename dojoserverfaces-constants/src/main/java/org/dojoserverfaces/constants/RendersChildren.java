package org.dojoserverfaces.constants;
/**
 * RenderChildren enum
 * 
 */
public enum RendersChildren {
    /* The component is responsible for rendering children. It will use built in 
     * support for adding child components as child widgets of the dojo widget
     * e.g. widget.addChild(new <child component creation)
     * 
     */
    YES_USE_ADD_CHILD,
    /* The component is responsible for handling children.
     */
    YES_CUSTOM_RENDER,
    /* The component is not responsible for handling its children. This is the default.
     */
    NO_NOT_RESPONSIBLE
}