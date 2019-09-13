package de.fearlessdeveloper.moneyexample;

import java.util.Objects;

class Money {
    protected int amount;
    protected Currency currency;

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Money money = (Money) o;
        return amount == money.amount && getCurrency() == ((Money) o).getCurrency();
    }

    static Money dollar(int amount) {
        return new Money(amount, Currency.USD);
    }

    static Money franc(int amount) {
        return new Money(amount, Currency.CHF);
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public int getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public int hashCode() {
        return Objects.hash(amount);
    }

}
