package de.fearlessdeveloper.moneyexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoneyExampleApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void dollarMulitplication() {
		var dollar = new Dollar(5);
		assertThat(dollar.getAmount(), is(5));
		var dollarTimesFive = dollar.times(2);
		assertThat(dollarTimesFive.getAmount(), is(10));
        assertThat(dollar.getAmount(), is(5));

	}

	@Test
    public void equality() {
	    // Triangulation
	    assertTrue(new Dollar(5).equals(new Dollar(5)));
	    assertFalse(new Dollar(6).equals(new Dollar(5)));

    }
}
