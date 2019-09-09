package de.fearlessdeveloper.moneyexample;

abstract public class Money {
    protected int amount;
    protected Currency currency;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    static Money dollar(int amount) {
        return new Dollar(amount);
    }

    static Money franc(int amount) {
        return new Franc(amount, null);
    }

    abstract Money times(int multiplier);

    abstract int getAmount();

    public Currency getCurrency() {
        return this.currency;
    }

}
