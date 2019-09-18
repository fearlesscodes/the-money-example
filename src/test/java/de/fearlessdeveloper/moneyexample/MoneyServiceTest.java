package de.fearlessdeveloper.moneyexample;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class MoneyServiceTest {

    @Mock
    MoneyMongoRepository moneyMongoRepositoryMock;



}
