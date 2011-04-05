/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.component;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GridContainer {
	private Integer nbZone = 3;

	private Boolean isAutoOrganized = true;
	private String colWiths;

	public Integer getNbZone() {
		return nbZone;
	}

	public void setNbZone(Integer nbZone) {
		this.nbZone = nbZone;

	}

	public Boolean getIsAutoOrganized() {
		return isAutoOrganized;
	}

	public void setIsAutoOrganized(Boolean isAutoOrganized) {
		this.isAutoOrganized = isAutoOrganized;
	}

	public String getColWiths() {
		/*
		 * int k=0;
		 * 
		 * if(tm!=0&&(colWiths!=null&&colWiths.length()==0)) {
		 * 
		 * System.out.println("============== tm=" + tm);
		 * 
		 * k=100/tm; for(int i=0;i<tm;i++) colWiths = colWiths + k+","; colWiths
		 * = colWiths.substring(0, colWiths.lastIndexOf(",")); tm=0; }
		 */
		return colWiths;
	}

	public void setColWiths(String colWiths) {
		this.colWiths = colWiths;
	}

}
