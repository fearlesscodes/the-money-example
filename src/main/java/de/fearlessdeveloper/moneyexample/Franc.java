package de.fearlessdeveloper.moneyexample;

import java.util.Objects;

public class Franc extends Money {

    public Franc(int amount, Currency currency) {
        this.amount = amount;
        this.currency = Currency.CHF;
    }

    public int getAmount() {
        return amount;
    }

    public Money times(int multiplier) {
        return new Franc(amount * multiplier, null);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}