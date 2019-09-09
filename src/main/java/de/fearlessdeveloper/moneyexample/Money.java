package de.fearlessdeveloper.moneyexample;

abstract public class Money {
    protected int amount;
    protected Currency currency;

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    static Money dollar(int amount) {
        return new Dollar(amount, Currency.USD);
    }

    static Money franc(int amount) {
        return new Franc(amount, Currency.CHF);
    }

    abstract Money times(int multiplier);

    public int getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return this.currency;
    }

}
