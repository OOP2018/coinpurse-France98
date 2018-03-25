package strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.MalayMoneyFactory;
import coinpurse.Money;
import coinpurse.MoneyFactory;
import coinpurse.Purse;
import coinpurse.ThaiMoneyFactory;
import coinpurse.Valuable;
import coinpurse.ValueComparator;

public class WithdrawTest {

	private WithdrawStrategy strategy;

	private static final double TOL = 1.0E-6;
	private static final String CURRENCY = "Baht";

	@Before
	public void setUp() {
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		strategy = new RecursionWithdraw();
	}

	private Valuable makeCoin(double value) {
		return new Coin(value, CURRENCY);
	}

	private Valuable makeBankNote(double value) {
		return new BankNote(value, CURRENCY);
	}

	@Test
	public void testRecursionWithdraw() {
		List<Valuable> money = Arrays.asList(makeCoin(5.0), makeCoin(2.0), makeCoin(2.0), makeCoin(2.0));
		strategy.withdraw(makeCoin(6.0), money);
		assertEquals(2, strategy.withdraw(makeCoin(6), money).get(0).getValue(), TOL);
		assertEquals(2, strategy.withdraw(makeCoin(6), money).get(1).getValue(), TOL);
		assertEquals(2, strategy.withdraw(makeCoin(6), money).get(2).getValue(), TOL);
	}

	@Test
	public void testNormalWithdraw() {
		List<Valuable> money = Arrays.asList(makeCoin(5.0), makeCoin(2.0), makeCoin(2.0), makeCoin(2.0));
		strategy.withdraw(makeCoin(4.0), money);
		assertEquals(2, strategy.withdraw(makeCoin(4), money).get(0).getValue(), TOL);
		assertEquals(2, strategy.withdraw(makeCoin(4), money).get(1).getValue(), TOL);
	}

	@Test
	public void testMiddleWithdraw() {
		List<Valuable> money = Arrays.asList(makeCoin(5.0), makeCoin(10.0), makeCoin(2.0));
		strategy.withdraw(makeCoin(10.0), money);
		assertEquals(10, strategy.withdraw(makeCoin(10.0), money).get(0).getValue(), TOL);
	}

	@Test
	public void testWithdrawMoreThanBalance() {
		List<Valuable> money = Arrays.asList(makeCoin(5.0), makeCoin(2.0), makeCoin(2.0), makeCoin(2.0));
		assertNull(strategy.withdraw(makeCoin(20), money));
	}

	@Test
	public void withdrawEverything() {
		List<Valuable> money = Arrays.asList(makeCoin(5.0), makeCoin(2.0), makeCoin(2.0), makeCoin(2.0));
		strategy.withdraw(makeCoin(11.0), money);
		assertEquals(2, strategy.withdraw(makeCoin(11.0), money).get(0).getValue(), TOL);
		assertEquals(2, strategy.withdraw(makeCoin(11.0), money).get(1).getValue(), TOL);
		assertEquals(2, strategy.withdraw(makeCoin(11.0), money).get(2).getValue(), TOL);
		assertEquals(5, strategy.withdraw(makeCoin(11.0), money).get(3).getValue(), TOL);
	}

	@Test
	public void withdrawDifferentCurrency() {
		Valuable b1 = new BankNote(10,"baht");
		Valuable b2 = new BankNote(10,"baht");
		Valuable b3 = new BankNote(10,"yen");
		Valuable b4 = new BankNote(10,"ringgit");
		List<Valuable> list = Arrays.asList(b1,b2,b3,b4);
		List<Valuable> result = strategy.withdraw(new BankNote(10,"dollar"), list);
		assertNull(result);
		
	}

}
