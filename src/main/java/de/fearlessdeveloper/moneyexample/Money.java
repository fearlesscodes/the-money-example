package de.fearlessdeveloper.moneyexample;

public class Money {
    protected int amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money dollar = (Money) o;
        return amount == dollar.amount;
    }
}
