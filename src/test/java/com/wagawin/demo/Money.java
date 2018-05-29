package com.wagawin.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public class Money {

	private BigDecimal amount;
	private Currency currency;
	private RoundingMode roundingMode;

	public Money(BigDecimal amount, Currency currency) {
		this(amount, currency, RoundingMode.FLOOR);
	}

	private Money(BigDecimal amount, Currency currency, RoundingMode roundingMode) {
		this.amount = amount;
		this.currency = currency;
		this.roundingMode = roundingMode;
	}

	public Money multiplyBy(int factor) {
		BigDecimal newAmount = amount.multiply(new BigDecimal(factor));
		return new Money(newAmount, currency, roundingMode);
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public RoundingMode getRoundingStyle() {
		return roundingMode;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}

	public static void main(String[] args) {

		Money a = new Money(new BigDecimal("67.89"), Currency.getInstance("EUR"));
		Money b = new Money(new BigDecimal("98.76"), Currency.getInstance("USD"));
		System.out.println(a);
		System.out.println(b);
		System.out.println(b.multiplyBy(2));
	}

}
