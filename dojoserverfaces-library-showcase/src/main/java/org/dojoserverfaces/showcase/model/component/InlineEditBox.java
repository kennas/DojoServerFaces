package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class InlineEditBox {

    private Boolean autoSave = true;
    private String buttonCancel;
    private String buttonSave;
    private Boolean disabled = false;
    private Boolean editing = false;
    private Boolean focused = false;

    private String noValueIndicator="edit here";
    private Boolean renderAsHtml = false;
    private String width = "700px";
    private String value="Hello InlineEditBox please edit here";

    public Boolean getAutoSave() {
        return autoSave;
    }

    public void setAutoSave(Boolean autoSave) {
        this.autoSave = autoSave;
    }

    public String getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(String buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public String getButtonSave() {
        return buttonSave;
    }

    public void setButtonSave(String buttonSave) {
        this.buttonSave = buttonSave;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getEditing() {
        return editing;
    }

    public void setEditing(Boolean editing) {
        this.editing = editing;
    }

    public Boolean getFocused() {
        return focused;
    }

    public void setFocused(Boolean focused) {
        this.focused = focused;
    }

    public String getNoValueIndicator() {
        return noValueIndicator;
    }

    public void setNoValueIndicator(String noValueIndicator) {
        this.noValueIndicator = noValueIndicator;
    }

    public Boolean getRenderAsHtml() {
        return renderAsHtml;
    }

    public void setRenderAsHtml(Boolean renderAsHtml) {
        this.renderAsHtml = renderAsHtml;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
