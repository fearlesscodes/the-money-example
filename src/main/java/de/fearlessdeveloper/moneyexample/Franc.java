package de.fearlessdeveloper.moneyexample;

import java.util.Objects;

public class Franc extends Money {

    public Franc(int amount, Currency currency) {
        super(amount, currency);
    }



    public Money times(int multiplier) {
        return Money.franc(amount * multiplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}