package de.fearlessdeveloper.moneyexample;

public class MoneyService {

    MoneyMongoRepository repo;

    public MoneyService(MoneyMongoRepository moneyMongoRepository) {
        repo = moneyMongoRepository;
    }

    public void addMoney(Money money) {
        repo.saveOne(money);
    }
}
