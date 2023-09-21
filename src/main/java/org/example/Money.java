package org.example;

import java.util.Currency;

public class Money {
    public double value;
    public Currency currency;
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

    private Money convertMoney(Money moneyToBeAdded) {
        if (!this.currency.equals(moneyToBeAdded.getCurrency())) { // If the two currency does not match
            if (this.getCurrency().equals(Currency.getInstance("USD")) && moneyToBeAdded.getCurrency().equals(Currency.getInstance("HUF")))
                moneyToBeAdded = new Money(moneyToBeAdded.value *0.0027, Currency.getInstance("USD"));
            else if (this.getCurrency().equals(Currency.getInstance("HUF")) && moneyToBeAdded.getCurrency().equals(Currency.getInstance("USD")))
                moneyToBeAdded = new Money(moneyToBeAdded.value *363.76, Currency.getInstance("HUF"));
            else return null;
        }
        return moneyToBeAdded;
    }

    public Integer compareTo(Money m) {
        m = convertMoney(m);
        if (m == null) return null;
        return Double.compare(this.getValue(), m.getValue());
    }
}