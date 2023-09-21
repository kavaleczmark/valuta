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
        if (!this.currency.equals(moneyToBeAdded.getCurrency())) { // If the two currency does not match
            if (this.getCurrency().equals(Currency.getInstance("USD")) && moneyToBeAdded.getCurrency().equals(Currency.getInstance("HUF")))
                moneyToBeAdded = new Money(moneyToBeAdded.value *0.0034, Currency.getInstance("USD"));
            else if (this.getCurrency().equals(Currency.getInstance("HUF")) && moneyToBeAdded.getCurrency().equals(Currency.getInstance("USD")))
                moneyToBeAdded = new Money(moneyToBeAdded.value *249.3, Currency.getInstance("HUF"));
//          else if (this.what().equals(Currency.getInstance("ASD")) && moneyToBeAdded.what().equals(Currency.getInstance("USD")))
//                moneyToBeAdded = new Money(moneyToBeAdded.val *249.3, Currency.getInstance("ASD"));
            else return null;
        }
        this.value += moneyToBeAdded.getValue(); // Add value of the parameter to this.val
        return this;
    }

    public Integer compareTo(Money m) {
        if (!this.currency.equals(m.getCurrency())) {
            if (this.getCurrency().equals(Currency.getInstance("USD")) && m.getCurrency().equals(Currency.getInstance("HUF")))
                m = new Money(m.value *0.0034, Currency.getInstance("USD"));
            else if (this.getCurrency().equals(Currency.getInstance("HUF")) && m.getCurrency().equals(Currency.getInstance("USD")))
                m = new Money(m.value *249.3, Currency.getInstance("HUF"));
            else return null;
        }
        return Double.compare(this.getValue(), m.getValue());
    }
}