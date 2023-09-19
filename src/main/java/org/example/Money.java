import java.util.Currency;

public class Money {
    public double value;
    public Currency currency;
    public Money(double dValue, Currency c) {
        this.value = dValue;
        this.currency = c;
    }

    public double getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Money add(Money moneyzToGiveMeh) {
        // Convert
        if (!this.currency.equals(moneyzToGiveMeh.getCurrency())) { // If the two currency does not match
            if (this.getCurrency().equals(Currency.getInstance("USD")) && moneyzToGiveMeh.getCurrency().equals(Currency.getInstance("HUF")))
                moneyzToGiveMeh = new Money(moneyzToGiveMeh.value *0.0034, Currency.getInstance("USD"));
            else if (this.getCurrency().equals(Currency.getInstance("HUF")) && moneyzToGiveMeh.getCurrency().equals(Currency.getInstance("USD")))
                moneyzToGiveMeh = new Money(moneyzToGiveMeh.value *249.3, Currency.getInstance("HUF"));
//            else if (this.what().equals(Currency.getInstance("ASD")) && moneyzToGiveMeh.what().equals(Currency.getInstance("USD")))
//                moneyzToGiveMeh = new Money(moneyzToGiveMeh.val *249.3, Currency.getInstance("ASD"));
            else return null;
        }
        this.value += moneyzToGiveMeh.getValue(); // Add value of the parameter to this.val
        return this;
    }

    public Integer compareTo(Money moneyToCompare) {
        if (!this.c.equals(moneyToCompare.what())) {
            if (this.what().equals(Currency.getInstance("USD")) && moneyToCompare.what().equals(Currency.getInstance("HUF")))
                moneyToCompare = new Money(moneyToCompare.val*0.0034, Currency.getInstance("USD"));
            else if (this.what().equals(Currency.getInstance("HUF")) && moneyToCompare.what().equals(Currency.getInstance("USD")))
                moneyToCompare = new Money(moneyToCompare.val*249.3, Currency.getInstance("HUF"));
            else return null;
        }
        return Double.compare(this.how_much(), moneyToCompare.how_much());
    }
}