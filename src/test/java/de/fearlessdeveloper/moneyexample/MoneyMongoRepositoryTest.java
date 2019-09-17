package de.fearlessdeveloper.moneyexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


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
        var moneyArgument = ArgumentCaptor.forClass(Money.class);
    }

    @Test
    public void testRepoClean() {

    }


    @Test
    public void testSaveMoneyPlusCall() {
    }
}
