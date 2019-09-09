package de.fearlessdeveloper.moneyexample;

import java.util.Objects;

public class Dollar extends Money {

    public Dollar(int amount, Currency currency) {
        super(amount, currency);
    }

    public int getAmount() {
        return amount;
    }

    public Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}