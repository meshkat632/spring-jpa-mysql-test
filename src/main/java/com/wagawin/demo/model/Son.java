package com.wagawin.demo.model;

import javax.persistence.Entity;

@Entity
public class Son extends Child{
	public String getBiCycleColor() {
		return biCycleColor;
	}

	public void setBiCycleColor(String biCycleColor) {
		this.biCycleColor = biCycleColor;
	}

	private String biCycleColor;

}
