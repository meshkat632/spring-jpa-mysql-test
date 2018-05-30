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

@Entity
public class Person {
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
		this.house.setOwner(this);
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
	public List<Child> getChildren() {
		return children;
	}
	public void setChildren(List<Child> children) {
		this.children = children;
		this.children.forEach(child -> child.setParent(this));
	}
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String name;
	private int age;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Child> children= new ArrayList<Child>();
	
	@OneToOne(cascade=CascadeType.ALL)
	private House house;

	 

	
	
	/*
	public Person(String name, int age, List<Child> children) {
		super();
		this.name = name;
		this.age = age;
		this.children = new ArrayList<Child>();
		this.children.addAll(children);		
	}
	*/
	
}

