/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

public abstract class WigdetBase extends HTMLOutput {
    private String style;
    private String styleClass;
    private String title;
    private String tooltip;
    private String region;
    private Integer colSpan;
    private String column;
    private String iconClass;
    private Boolean showTitle;
    private Integer minSize;
    private Boolean splitter;
    private Boolean selected;
    private Boolean closable;
    private Boolean dragRestriction;

    /*
     * event
     */
    private String onClick;
    private String onDblClick;
    private String onMouseDown;
    private String onMouseMove;
    private String onMouseOut;
    private String onMouseOver;
    private String onMouseUp;
    private String onKeyDown;
    private String onKeyPress;
    private String onKeyUp;
    private String onShow;
    private String onHide;

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getColSpan() {
        return colSpan;
    }

    public void setColSpan(Integer colSpan) {
        this.colSpan = colSpan;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public Boolean getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(Boolean showTitle) {
        this.showTitle = showTitle;
    }

    public Integer getMinSize() {
        return minSize;
    }

    public void setMinSize(Integer minSize) {
        this.minSize = minSize;
    }

    public Boolean getSplitter() {
        return splitter;
    }

    public void setSplitter(Boolean splitter) {
        this.splitter = splitter;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getClosable() {
        return closable;
    }

    public void setClosable(Boolean closable) {
        this.closable = closable;
    }

    public Boolean getDragRestriction() {
        return dragRestriction;
    }

    public void setDragRestriction(Boolean dragRestriction) {
        this.dragRestriction = dragRestriction;
    }

    public String getOnClick() {
        return onClick;
    }

    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }

    public String getOnDblClick() {
        return onDblClick;
    }

    public void setOnDblClick(String onDblClick) {
        this.onDblClick = onDblClick;
    }

    public String getOnMouseDown() {
        return onMouseDown;
    }

    public void setOnMouseDown(String onMouseDown) {
        this.onMouseDown = onMouseDown;
    }

    public String getOnMouseMove() {
        return onMouseMove;
    }

    public void setOnMouseMove(String onMouseMove) {
        this.onMouseMove = onMouseMove;
    }

    public String getOnMouseOut() {
        return onMouseOut;
    }

    public void setOnMouseOut(String onMouseOut) {
        this.onMouseOut = onMouseOut;
    }

    public String getOnMouseOver() {
        return onMouseOver;
    }

    public void setOnMouseOver(String onMouseOver) {
        this.onMouseOver = onMouseOver;
    }

    public String getOnMouseUp() {
        return onMouseUp;
    }

    public void setOnMouseUp(String onMouseUp) {
        this.onMouseUp = onMouseUp;
    }

    public String getOnKeyDown() {
        return onKeyDown;
    }

    public void setOnKeyDown(String onKeyDown) {
        this.onKeyDown = onKeyDown;
    }

    public String getOnKeyPress() {
        return onKeyPress;
    }

    public void setOnKeyPress(String onKeyPress) {
        this.onKeyPress = onKeyPress;
    }

    public String getOnKeyUp() {
        return onKeyUp;
    }

    public void setOnKeyUp(String onKeyUp) {
        this.onKeyUp = onKeyUp;
    }

    public String getOnShow() {
        return onShow;
    }

    public void setOnShow(String onShow) {
        this.onShow = onShow;
    }

    public String getOnHide() {
        return onHide;
    }

    public void setOnHide(String onHide) {
        this.onHide = onHide;
    }
}
