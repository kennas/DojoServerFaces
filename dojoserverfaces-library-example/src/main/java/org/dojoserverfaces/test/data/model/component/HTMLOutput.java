package org.dojoserverfaces.test.data.model.component;

import javax.faces.component.UIComponent;

public abstract class HTMLOutput {

	//
	// public String getStyle() {
	// return getAttribute("style");
	// }
	//
	// public void setStyle(String style) {
	// setAttribute("style", style;
	// }
	//
	// public String getStyleClass() {
	// return getAttribute("styleClass;
	// }
	//
	// public void setStyleClass(String styleClass) {
	// setAttribute("styleClass", styleClass;
	// }

	public String getOnClick() {
		return (String) getAttribute("onClick");
	}

	public void setOnClick(String onClick) {
		setAttribute("onClick", onClick);
	}

	// public String getOnDblClick() {
	// return getAttribute("onDblClick");
	// }
	//
	// public void setOnDblClick(String onDblClick) {
	// setAttribute("onDblClick", onDblClick;
	// }
	//
	// public String getOnMouseDown() {
	// return getAttribute("onMouseDown");
	// }
	//
	// public void setOnMouseDown(String onMouseDown) {
	// setAttribute("onMouseDown", onMouseDown;
	// }
	//
	// public String getOnMouseMove() {
	// return getAttribute("onMouseMove");
	// }
	//
	// public void setOnMouseMove(String onMouseMove) {
	// setAttribute("onMouseMove", onMouseMove;
	// }
	//
	// public String getOnMouseOut() {
	// return getAttribute("onMouseOut");
	// }
	//
	// public void setOnMouseOut(String onMouseOut) {
	// setAttribute("onMouseOut", onMouseOut;
	// }
	//
	// public String getOnMouseOver() {
	// return getAttribute("onMouseOver");
	// }
	//
	// public void setOnMouseOver(String onMouseOver) {
	// setAttribute("onMouseOver", onMouseOver;
	// }
	//
	// public String getOnMouseUp() {
	// return getAttribute("onMouseUp");
	// }
	//
	// public void setOnMouseUp(String onMouseUp) {
	// setAttribute("onMouseUp", onMouseUp;
	// }
	//
	// public String getOnKeyDown() {
	// return getAttribute("onKeyDown");
	// }
	//
	// public void setOnKeyDown(String onKeyDown) {
	// setAttribute("onKeyDown", onKeyDown;
	// }
	//
	// public String getOnKeyPress() {
	// return getAttribute("onKeyPress");
	// }
	//
	// public void setOnKeyPress(String onKeyPress) {
	// setAttribute("onKeyPress", onKeyPress;
	// }
	//
	// public String getOnKeyUp() {
	// return getAttribute("onKeyUp");
	// }
	//
	// public void setOnKeyUp(String onKeyUp) {
	// setAttribute("onKeyUp", onKeyUp;
	// }

	private UIComponent[] wrapper = { null, null, null };

	public UIComponent[] getWrapper() {
		return wrapper;
	}

	protected void setAttribute(String name, Object value) {
		for (UIComponent component : wrapper) {
			if (null != component) {
				component.getAttributes().put(name, value);
			}
		}
	}

	protected Object getAttribute(String name) {
		UIComponent component = wrapper[0];
		if (null != component) {
			return component.getAttributes().get(name);
		}
		return null;
	}

}
