package de.fearlessdeveloper.moneyexample;

import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class MoneyMongoRepository {

    MongoTemplate mongoTemplate;

    public MoneyMongoRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void addMoney(Money money) {
        mongoTemplate.save(money);
    }

    public void clean() {
        this.mongoTemplate.dropCollection(Money.class);
    }

    public void saveOne(Money money) {
        mongoTemplate.save(money);
    }

    public boolean isEmpty() {
        return this.mongoTemplate.findAll(Money.class).isEmpty();
    }
}
