package org.example;

import java.util.Currency;

public class Money {

    private double value;
    private Currency currency;

    public Money(double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Money addMoney(Money moneyToBeAdded) {
        // Convert
        moneyToBeAdded = convertMoney(moneyToBeAdded);
        if (moneyToBeAdded == null) return null;
        this.value += moneyToBeAdded.getValue(); // Add value of the parameter to this.val
        return this;
    }

    public Integer compareTo(Money m) {
        m = convertMoney(m);
        if (m == null) return null;
        return Double.compare(this.getValue(), m.getValue());
    }

    private Money convertMoney(Money moneyToBeAdded) {
        if (this.currency.equals(moneyToBeAdded.getCurrency())) {
            return moneyToBeAdded;
        }

        if (isCurrentUsd() && isToBeAddedHuf(moneyToBeAdded))
            return new Money(moneyToBeAdded.value *0.0027, Currency.getInstance("USD"));
        else if (isCurrentHuf() && isToBeAddedUsd(moneyToBeAdded))
            return new Money(moneyToBeAdded.value *363.76, Currency.getInstance("HUF"));

        return null;
    }

    private static boolean isToBeAddedUsd(Money moneyToBeAdded) {
        return moneyToBeAdded.getCurrency().equals(Currency.getInstance("USD"));
    }

    private boolean isCurrentHuf() {
        return this.getCurrency().equals(Currency.getInstance("HUF"));
    }

    private static boolean isToBeAddedHuf(Money moneyToBeAdded) {
        return moneyToBeAdded.getCurrency().equals(Currency.getInstance("HUF"));
    }

    private boolean isCurrentUsd() {
        return this.getCurrency().equals(Currency.getInstance("USD"));
    }
}