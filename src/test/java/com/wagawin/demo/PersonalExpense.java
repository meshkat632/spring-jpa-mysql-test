package com.wagawin.demo;

public class PersonalExpense {
	public PersonalExpense(String name, long currentExpenses) {
		super();
		this.name = name;
		this.currentExpenses = currentExpenses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCurrentExpenses() {
		return currentExpenses;
	}

	public void setCurrentExpenses(long currentExpenses) {
		this.currentExpenses = currentExpenses;
	}

	private String name;
	private long currentExpenses;

}