package org.example;

import java.util.Currency;

public class Main {
    public static void main(String[] args) {
        Money money1=new Money(100.0, Currency.getInstance("HUF"));
        Money money2=new Money(3.0, Currency.getInstance("USD"));
        System.out.println(money1.getValue() + " " +money1.getCurrency());
        System.out.println(money2.getValue() + " " +money2.getCurrency());
        System.out.println(money1.compareTo(money2));
        money1.addMoney(money2);
        System.out.println(money1.getValue() + " " +money1.getCurrency());
        System.out.println(money2.getValue() + " " +money2.getCurrency());
        System.out.println(money1.compareTo(money2));
    }
}
