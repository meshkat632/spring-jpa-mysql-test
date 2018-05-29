package com.wagawin.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		List<PersonalExpense> departmentExpenses = new ArrayList<PersonalExpense>();
		departmentExpenses.add(new PersonalExpense("a", 2000));
		departmentExpenses.add(new PersonalExpense("b", 2000));
		departmentExpenses.add(new PersonalExpense("c", 2000));
		departmentExpenses.add(new PersonalExpense("d", 2000));
		departmentExpenses.add(new PersonalExpense("e", 2000));
		System.out.println(getRemainingCompanyBalanceOld(1000000, departmentExpenses));
		System.out.println(getRemainingCompanyBalance(1000000, departmentExpenses));
		
		CharSequence charSequence = "baeldung";
		System.out.println(charSequence );
		
		CharSequence charSequence1 = new StringBuffer("baeldung");
		CharSequence charSequence2 = new StringBuilder("baeldung");
		
		System.out.println(charSequence1 );
		System.out.println(charSequence2 );
		
		/*
		System.out.println(getName(Arrays.asList("ola", "amigo"), 1));		
		System.out.println(getName(Arrays.asList("ola", "amigo"), 0));
		*/

	}

	private static long getRemainingCompanyBalanceOld(long initialBalance, List<PersonalExpense>... departmentExpenses) {
		long remainingCompanyBalance = initialBalance;
		for (List<PersonalExpense> departmentExpense : departmentExpenses) {
			for (PersonalExpense personalExpense : departmentExpense) {
				System.out.println(
						"Processing %s" + personalExpense.getName() + " " + personalExpense.getCurrentExpenses());
				remainingCompanyBalance = remainingCompanyBalance - personalExpense.getCurrentExpenses();
			}
		}
		return remainingCompanyBalance;

	}

	@SafeVarargs
	
	private static long getRemainingCompanyBalance(long initialBalance, List<PersonalExpense>... departmentExpenses) {

		long totalExpenses = Stream.of(departmentExpenses)
				                    .flatMap(departmentExpense -> departmentExpense.stream())
				                    .mapToLong(personalExpense -> personalExpense.getCurrentExpenses())				                    
				                    .sum();
		return initialBalance - totalExpenses;

	}
	
	
	 

}


