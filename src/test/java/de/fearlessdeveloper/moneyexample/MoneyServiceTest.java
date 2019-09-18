package de.fearlessdeveloper.moneyexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@DataMongoTest
public class MoneyServiceTest {

    @Mock
    MoneyMongoRepository moneyMongoRepositoryMock;

    @InjectMocks
    MoneyService service;

    @Test
    public void testAddMoney() {
        var fiveDollar = Money.dollar(5);

        service.addMoney(fiveDollar);
        ArgumentCaptor<Money> argument =  ArgumentCaptor.forClass(Money.class);
        verify(moneyMongoRepositoryMock).saveOne(argument.capture());
        assertThat(argument.getValue().equals(fiveDollar), is(true));
    }

}
