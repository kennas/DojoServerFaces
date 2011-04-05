package org.dojoserverfaces.test.data.model.component;

import javax.faces.bean.ManagedBean;


/**
 * An input component which restricts input to numeric input and offers down and
 * up arrow buttons to "spin" the number up and down
 * 
 */
@ManagedBean
public class NumberSpinner extends NumberInputBase {

	public Number getSmallDelta() {
		return (Number) getAttribute("smallDelta");
	}
	public void setSmallDelta(Number smallDelta) {
		setAttribute("smallDelta", smallDelta);
	}
	public Number getLargeDelta() {
		return (Number) getAttribute("largeDelta");
	}
	public void setLargeDelta(Number largeDelta) {
		setAttribute("largeDelta", largeDelta);
	}
}
