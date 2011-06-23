package org.dojoserverfaces.component.mobile;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PreRenderViewEvent;
import javax.faces.event.SystemEvent;
import javax.faces.render.Renderer;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Component;
import org.dojoserverfaces.component.dojo.DojoScriptBlockComponent;
import org.dojoserverfaces.component.dojo.DojoTheme;

@Component
public class MobileTheme extends DojoTheme {

    /**
     * Creates a component.
     */
    public MobileTheme() {
        super();
    }

    /**
     * The theme name. it should be iphone,android,blackberry,auto
     * 
     */
    @Attribute
    public String getName() {
        return (String) getStateHelper().eval("name", "iphone");
    }

    /**
     * 
     * @param name
     *            a String containing the theme.
     */
    public void setName(String name) {
        getStateHelper().put("name", name);
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    }

    @Override
    public void encodeChildren(FacesContext context) throws IOException {
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
    }

    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        if (event instanceof PreRenderViewEvent) {
        }
        else {
            // make sure we are in the resource area
            final UIViewRoot viewRoot = getFacesContext().getViewRoot();
            // unsubscribe from the PostAddToViewEvent as moving the component
            // may cause a re-firing of the same event
            viewRoot.unsubscribeFromViewEvent(
                    javax.faces.event.PostAddToViewEvent.class, this);
            // move myself to the correct resource block
            viewRoot.addComponentResource(getFacesContext(), this,
                    RESOURCE_TARGET);
            if (!this.getName().equals("auto")) {
                org.dojoserverfaces.component.dojo.DojoStyleComponent styleBlock = org.dojoserverfaces.component.dojo.DojoStyleComponent
                        .findStyleBlockComponent(viewRoot);
                styleBlock
                        .addRequiredCss("dojox/mobile/themes/{theme}/base.css");
            }
            org.dojoserverfaces.component.dojo.DojoScriptBlockComponent
                    .addScriptBlockToView(viewRoot);
            DojoScriptBlockComponent initScriptBlock = DojoScriptBlockComponent
                    .findInitBlockComponent(viewRoot);
            initScriptBlock.addRequires("dojox.mobile");
        }
    }

    @Override
    public void encodeAll(FacesContext context) throws IOException {
    }

    public static MobileTheme findMobileTheme(UIViewRoot view) {

        for (UIComponent comp : view.getComponentResources(
                FacesContext.getCurrentInstance(), RESOURCE_TARGET)) {
            if (comp instanceof MobileTheme) {
                return (MobileTheme) comp;
            }
        }

        return null;
    }

    @Override
    protected Renderer getRenderer(FacesContext context) {
        return null;
    }

    @Override
    public String getRendererType() {
        return null;
    }
}
