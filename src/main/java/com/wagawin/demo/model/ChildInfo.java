package com.wagawin.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ChildInfo {
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@JsonIgnoreProperties({ "children", "house" })
	private Person parent;
	private Meal mostFavoriteMeal;
	private Long id;
	private String name;
	private int age;

	public ChildInfo() {

	}

	public ChildInfo(Child child, Person parent, Meal mostFavoriteMeal) {
		this.id = child.getId();
		this.name = child.getName();
		this.age = child.getAge();		
		this.parent = parent;
		this.mostFavoriteMeal = mostFavoriteMeal;
	}

	public Person getParent() {
		return parent;
	}

	public void setParent(Person parent) {
		this.parent = parent;
	}

	public Meal getMostFavoriteMeal() {
		return mostFavoriteMeal;
	}

	public void setMostFavoriteMeal(Meal mostFavoriteMeal) {
		this.mostFavoriteMeal = mostFavoriteMeal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
