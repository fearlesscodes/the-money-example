package de.fearlessdeveloper.moneyexample;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

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

    public void saveAll(List<Money> listOfMoney) {
        listOfMoney.stream().forEach(money -> saveOne(money));
    }

    public void removeAllGreaterThan(Money money) {
        var threshold = new Query(where("amount").gt(money.getAmount()));
        this.mongoTemplate.findAllAndRemove(threshold, Money.class);
    }

    public List<Money> findAll() {
        return this.mongoTemplate.findAll(Money.class);
    }

    public boolean isEmpty() {
        return this.mongoTemplate.findAll(Money.class).isEmpty();
    }

    public List<Money> findAllMoneyGreaterThan(Money money) {
        var query = new Query(where("amount").gt(money.getAmount()));
        return this.mongoTemplate.find(query, Money.class);
    }

    public int count() {
       return mongoTemplate.findAll(Money.class).size();
    }
}
