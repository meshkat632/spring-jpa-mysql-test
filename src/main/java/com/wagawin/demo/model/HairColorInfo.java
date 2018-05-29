package com.wagawin.demo.model;

public class HairColorInfo extends ColorInfo{
	
	public HairColorInfo(String hairColor) {		
		this.hairColor = hairColor;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	private String hairColor;
	

}
