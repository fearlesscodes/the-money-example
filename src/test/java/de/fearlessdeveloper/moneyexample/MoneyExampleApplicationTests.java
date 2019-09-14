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
	public void dollarMultiplication() {
		Money fiveDollar = Money.dollar(5);
		assertEquals(Money.dollar(10), fiveDollar.times(2));
	}

	@Test
	public void francMultiplication() {
		var fiveFranc = Money.franc(5);
		assertThat(fiveFranc.getAmount(), is(5));
		assertEquals(Money.franc(10), fiveFranc.times(2));
		assertThat(fiveFranc.getAmount(), is(5));
	}


	@Test
    public void equality() {
	    // Triangulation
	    assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(6).equals(Money.dollar(5)));

		assertTrue(Money.franc(5).equals(Money.franc(5)));
		assertFalse(Money.franc(6).equals(Money.franc(5)));

		assertFalse(Money.franc(5).equals(Money.dollar(5)));

    }

    @Test
	public void testCurrency() {
		assertEquals(Currency.USD, Money.dollar(4).getCurrency());
		assertEquals(Currency.CHF, Money.franc(4).getCurrency());
	}

	@Test
	public void testPlusResultSum() {
		var fiveDollar = Money.dollar(5);
		Expression result = fiveDollar.plus(fiveDollar);
		var sum = (Sum) result;
		assertEquals(fiveDollar, sum.augend);
		assertEquals(fiveDollar, sum.addend);
	}

	@Test
	public void testReduceSum() {
		Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
		var bank = new Bank();
		Money result = bank.reduce(sum, Currency.USD);
		assertEquals(Money.dollar(7), result);
	}

	@Test
	public void testReduceMoney() {
		var bank = new Bank();
		Money result = bank.reduce(Money.dollar(1), Currency.USD);
		assertEquals(Money.dollar(1), result);
	}

}
