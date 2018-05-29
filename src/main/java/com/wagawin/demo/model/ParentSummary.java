package com.wagawin.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParentSummary {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAmountOfPersons() {
		return amountOfPersons;
	}
	public void setAmountOfPersons(Long amountOfPersons) {
		this.amountOfPersons = amountOfPersons;
	}
	public Long getAmountOfChildren() {
		return amountOfChildren;
	}
	public void setAmountOfChildren(Long amountOfChildren) {
		this.amountOfChildren = amountOfChildren;
	}
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private Long amountOfPersons; 
	private Long amountOfChildren;
	
	
}
