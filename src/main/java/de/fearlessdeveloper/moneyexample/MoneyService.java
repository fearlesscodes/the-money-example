package de.fearlessdeveloper.moneyexample;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class MoneyService {

    MoneyMongoRepository repo;

    public MoneyService(MoneyMongoRepository moneyMongoRepository) {
        repo = moneyMongoRepository;
    }

    public void addMoney(Money money) {
        requireNonNull(money);
        repo.saveOne(money);
    }

    public List<Money> getAllMoney() {
        return repo.findAll();
    }
}
