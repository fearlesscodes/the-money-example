package de.fearlessdeveloper.moneyexample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataMongoTest
public class MoneyMongoRepositoryTest {

    MoneyMongoRepository repo;

    Money fiveDollar = Money.dollar(5);

    @Autowired
    MongoTemplate mongoTemplate;

    @Before
    public void setupRepo() {
        repo = new MoneyMongoRepository(mongoTemplate);
        repo.clean();
    }

    @Test
    public void testAddMoney() {
        assertThat(repo.isEmpty(), is(true));
        repo.saveOne(fiveDollar);
        assertThat(repo.isEmpty(), is(false));
    }

    @Test
    public void testRepoClean() {
        assertThat(repo.isEmpty(), is(true));
        repo.saveOne(fiveDollar);
        assertThat(repo.isEmpty(), is(false));
        repo.clean();
        assertThat(repo.isEmpty(), is(true));
    }


    @Test
    public void testSaveAll() {
        var fiveDollar = Money.dollar(5);
        var tenTollar = Money.dollar(10);
        assertThat(repo.isEmpty(), is(true));
        repo.saveAll(List.of(fiveDollar, tenTollar));
        assertThat(repo.count(), is(2));
    }

    @Test
    public void findAll() {
        var fiveDollar = Money.dollar(5);
        var tenTollar = Money.dollar(10);
        assertThat(repo.isEmpty(), is(true));
        repo.saveAll(List.of(fiveDollar, tenTollar));
        assertThat(repo.findAll().size(), is(2));
    }

    @Test
    public void removeAllMoneyGreaterThan() {
        var fiveDollar = Money.dollar(5);
        var tenTollar = Money.dollar(10);
        assertThat(repo.isEmpty(), is(true));
        repo.saveAll(List.of(fiveDollar, tenTollar));
        repo.removeAllGreaterThan(Money.dollar(6));
        assertThat(repo.count(), is(1));
        repo.findAll().stream().forEach(money -> {
            assertEquals(money, fiveDollar);
        });
    }

    @Test
    public void testFindAllMoneyGreaterThan() {
        var fiveDollar = Money.dollar(5);
        var tenDollar = Money.dollar(10);
        assertThat(repo.isEmpty(), is(true));
        repo.saveAll(List.of(fiveDollar, tenDollar));
        assertThat(repo.findAllMoneyGreaterThan(Money.dollar(5)).size(), is(1));
        repo.findAllMoneyGreaterThan(fiveDollar).stream().forEach(money -> {
            assertThat(money.getAmount() > fiveDollar.getAmount(), is(true));
            assertThat(money.getAmount() < fiveDollar.getAmount(), is(false));
        });
    }

    @After
    public void clearAfterTestRun() {
        repo.clean();
    }
}
