package com.wagawin.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Meal {
	
	public Meal() {
		
	}
	public Meal(String name, Date invented) {
		this.name = name;
		this.invented = invented;
	}
	public Child getChild() {
		return child;
	}
	public void setChild(Child child) {
		this.child = child;
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
	public Date getInvented() {
		return invented;
	}
	public void setInvented(Date invented) {
		this.invented = invented;
	}
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String name;
	private Date invented;
	
	@OneToOne
	@JsonIgnore
	private Child child;

}
