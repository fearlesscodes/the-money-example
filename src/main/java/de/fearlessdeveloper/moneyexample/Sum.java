package de.fearlessdeveloper.moneyexample;


public class Sum implements Expression {
    public Money augend;
    public Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Currency targetCurrency) {
        int amount = augend.getAmount() + addend.getAmount();

        return new Money(amount, targetCurrency);
    }
}
