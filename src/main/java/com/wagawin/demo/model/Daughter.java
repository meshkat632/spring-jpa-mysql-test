package com.wagawin.demo.model;

import javax.persistence.Entity;

@Entity
public class Daughter extends Child {
	
	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	private String hairColor;
	 

}
