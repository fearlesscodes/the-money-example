package de.fearlessdeveloper.moneyexample;

import java.util.Objects;

public class Franc extends Money {

    public Franc(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }


    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}