package org.dojoserverfaces.constants;

/**
 * RenderChildren type
 * 
 */
public enum ChildrenRenderType {
    // do not let parent render children
    NO_RENDER,
    // let the parent render children and add children to script
    USE_ADD_CHILD,
    // let the parent render children but render them not as children
    RENDER

}
