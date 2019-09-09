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
		var fiveDollar = new Dollar(5);
		assertThat(fiveDollar.getAmount(), is(5));
        assertEquals(new Dollar(10), fiveDollar.times(2));
		assertThat(fiveDollar.getAmount(), is(5));
	}

	@Test
    public void equality() {
	    // Triangulation
	    assertTrue(new Dollar(5).equals(new Dollar(5)));
	    assertFalse(new Dollar(6).equals(new Dollar(5)));

    }
}
