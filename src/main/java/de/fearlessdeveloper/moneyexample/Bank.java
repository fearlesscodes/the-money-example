package de.fearlessdeveloper.moneyexample;

public class Bank  {
    public Money reduce(Expression source, Currency to) {
        if (source instanceof Money) return (Money) source;
        var sum = (Sum) source;
        return sum.reduce(to);
    }
}
