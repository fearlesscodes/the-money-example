package de.fearlessdeveloper.moneyexample;

import java.util.Objects;

public class Dollar extends Money {

    public Dollar(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }



    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}