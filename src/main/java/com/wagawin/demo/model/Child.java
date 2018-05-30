package com.wagawin.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Child {
	public List<Meal> getFavoriteMeals() {
		return favoriteMeals;
	}
	public void setFavoriteMeals(List<Meal> favoriteMeals) {
		this.favoriteMeals = favoriteMeals;
		this.favoriteMeals.forEach(meal -> meal.setChild(this));
	}
	public Person getParent() {
		return parent;
	}
	public void setParent(Person parent) {
		this.parent = parent;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String name;
	private int age;
	
	@OneToOne
	@JsonIgnoreProperties({ "children", "house", "age", "name" })	
	private Person parent;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Meal> favoriteMeals= new ArrayList<Meal>();
	
	@Override
	public String toString() {
		return "Child [name=" + name + ", age=" + age + "]";
	}	
}
