package coinpurse;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Purse using JUnit.
 * This is a JUnit 4 test suite.  
 * 
 * IDEs (Eclipse, Netbeans, IntelliJ, BlueJ) include JUnit 4,
 * but you have to tell the IDE to add it to your project as a "Library".
 * To run these tests, right click on this file (in Project panel)
 * and choose Run As -> JUnit test
 * 
 * @author  Resident Evil
 * @version 2018.01.19
 */
public class PurseTest {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
	private static final String CURRENCY = "Baht";
	
    /**
     * Sets up the test fixture.
     * Called before every test method.
     */
	@Before
    public void setUp(){
        MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
    }
    
    /** Make a coin with the default currency. To save typing "new Coin(...)" */
    private Valuable makeCoin(double value) {
		return new Coin(value,CURRENCY);
	}
    
    private Valuable makeBankNote(double value){
    	return new BankNote(value,CURRENCY);
    }

    /** Easy test that the Purse constructor is working. */
    @Test
    public void testConstructor()
    {
        Purse purse = new Purse(6);
        assertEquals(6, purse.getCapacity());
        assertEquals(false, purse.isFull());
        assertEquals(0, purse.count());
    }

    

    /** Insert some coins. Easy test. */
    @Test
    public void testInsert()
    {
        Purse purse = new Purse(6);
        Valuable coin1 = makeCoin(5);
        Valuable coin2 = makeCoin(10);
        Valuable coin3 = makeCoin(1);
        Valuable bank1 = makeBankNote(50);
        Valuable bank2 = makeBankNote(20);
        Valuable bank3 = makeBankNote(1000);
        assertTrue( purse.insert(coin1));
        assertTrue( purse.insert(coin3));
        assertTrue( purse.insert(coin2));
        assertTrue(purse.insert(bank1));
        assertTrue(purse.insert(bank2));
        assertTrue(purse.insert(bank3));
        assertEquals( 6, purse.count() );
        // purse is full so insert should fail
        assertFalse( purse.insert(makeCoin(1)) );
    }


	/** Insert should reject coin with no value. */
    @Test
    public void testInsertNoValue()
    {
        Purse purse = new Purse(6);
        Coin fakeCoin = new Coin(0, CURRENCY);
        assertFalse( purse.insert(fakeCoin) );
    }


    @Test(timeout=1000)
    public void testIsFull()
    {   // borderline case (capacity 1)
        Purse purse = new Purse(1);
        assertFalse( purse.isFull() );
        purse.insert( makeCoin(1) );
        assertTrue( purse.isFull() );
        // real test
        int capacity = 4;
        purse = new Purse(capacity);
        for(int k=1; k<=capacity; k++) {
            assertFalse(purse.isFull());
            purse.insert( makeCoin(k) );
        }
        // should be full now
        assertTrue( purse.isFull() );
        assertFalse( purse.insert( makeCoin(5) ) );
    }

	/** Should be able to insert same coin many times,
	 *  since spec doesn't say anything about this.
	 */
	@Test(timeout=1000)
	public void testInsertSameCoin()
	{
		int capacity = 5;
		double value = 10.0;
		Purse purse = new Purse(capacity);
		Coin coin = new Coin(value, "THB");
		assertTrue( purse.insert(coin) );
		assertTrue( purse.insert(coin) ); // should be allowed
		assertTrue( purse.insert(coin) ); // should be allowed
		assertTrue( purse.insert(coin) ); // should be allowed
		assertTrue( purse.insert(coin) ); // should be allowed
		assertEquals( purse.getBalance(), 5*value, TOL);
	}
	
	/** Should be able to insert same banknote many times,
	 *  since spec doesn't say anything about this.
	 */
	@Test(timeout=1000)
	public void testInsertSameBank(){
		int capa = 5;
		double value = 50;
		Purse purse = new Purse(capa);
		BankNote bank = new BankNote(value,"THB");
		assertTrue(purse.insert(bank));
		assertTrue(purse.insert(bank));
		assertTrue(purse.insert(bank));
		assertTrue(purse.insert(bank));
		assertTrue(purse.insert(bank));
		assertEquals(purse.getBalance(), 5*value , TOL);
	}

	/** Add one coin and remove it. */
	@Test(timeout=1000)
	public void testEasyWithdraw() {
		Purse purse = new Purse(10);
		double [] values = {1, 20, 0.5, 10}; // values of coins we will insert
		
		for(double value : values) {
			Valuable coin = makeCoin(value);
			assertTrue(purse.insert(coin));
			assertEquals(value,  purse.getBalance(), TOL);
			Valuable[] result = purse.withdraw(value);
			assertTrue( result != null );
			assertEquals( 1, result.length );
			assertSame(  coin, result[0] ); // should be same object
			assertEquals( 0, purse.getBalance(), TOL );
		}
		
		double [] values2 = {20,50,100,500};
		
		for(double value : values2){
			Valuable bank = makeBankNote(value);
			assertTrue(purse.insert(bank));
			assertEquals(value, purse.getBalance() ,TOL);
			Valuable[] result2 = purse.withdraw(value);
			assertTrue(result2 != null);
			assertEquals(1, result2.length);
			assertSame(bank , result2[0]);
			assertEquals(0,purse.getBalance(),TOL);
		}
	}
	

	/** Add 2 coins and 2 BankNote and then withdraw in pairs, but not in same order. */
	@Test(timeout=1000)
	public void testMultiWithdraw() {
		Purse purse = new Purse(10);
		Valuable[] money = { makeCoin(5.0), makeCoin(10.0), makeBankNote(20) ,makeBankNote(50)};
		// insert them all
		for(Valuable moneys: money) assertTrue( purse.insert(moneys) );
		
		double amount1 = money[1].getValue() + money[3].getValue();
		double amount4 = money[0].getValue() + money[2].getValue();
		assertEquals(amount1+amount4, purse.getBalance(), TOL );
		
		
		Valuable[] wd1 = purse.withdraw(amount1);
		assertEquals(amount1, sum(wd1), TOL );
		
		assertEquals(amount4, purse.getBalance(), TOL );
		Valuable[] wd2 = purse.withdraw(amount4);
		
		// should be empty now
		assertEquals(0, purse.getBalance(), TOL );
	}
	

	/** Withdraw full amount in purse, using varying numbers of objects. */
	@Test(timeout=1000)
	public void testWithdrawEverything() {
		Purse purse = new Purse(10);
		// Coins we want to insert and then withdraw.
		// Use values such that greedy will succeed, but not monotonic
		List<Valuable> money = Arrays.asList(
				makeCoin(1.0), makeCoin(0.5), makeCoin(10.0), makeBankNote(20) , makeBankNote(50) , makeBankNote(100)
				);
		// num = number of coins to insert and then withdraw
		for(int num=1; num <= money.size(); num++) {
			double amount = 0.0;
			List<Valuable> subList = money.subList(0, num);
			for(Valuable c: subList) {
				purse.insert(c);
				amount += c.getValue();
			}
			// balance should be exactly what we just inserted
			assertEquals( amount, purse.getBalance(), TOL);
			// can we withdraw it all?
			Valuable[] result = purse.withdraw(amount);
			String errmsg = String.format("couldn't withdraw %.2f but purse has %s",
					amount, Arrays.toString(subList.toArray()) );
			assertNotNull( errmsg, result );
			// is the amount correct?
			assertEquals("Withdraw wrong amount", amount, sum(result), TOL);
			// should not be anything left in the purse
			assertEquals( 0.0, purse.getBalance(), TOL);
		}
	}

	@Test(timeout=1000)
	public void testImpossibleWithdraw() {
		Purse purse = new Purse(10);
		assertNull( purse.withdraw(1) );
		purse.insert( makeCoin(20) );
		assertNull( purse.withdraw(1) );
		assertNull( purse.withdraw(19) );
		assertNull( purse.withdraw(21) );
		purse.insert( makeCoin(20) ); // now it has 20 + 20
		assertNull( purse.withdraw(30) );
		purse.insert(makeBankNote(50));
		assertNull(purse.withdraw(30));
	}
	
	/**
	 * Test Withdraw that have Valuable in parameter
	 */
	@Test(timeout=1000)
	public void testValuableWithdraw(){
		Purse purse = new Purse(10);
		Valuable b1 = new BankNote(10,"baht");
		Valuable b2 = new BankNote(10,"dollar");
		Valuable b3 = new BankNote(10,"yen");
		Valuable b4 = new BankNote(10,"ringgit");
		purse.insert(b1);
		purse.insert(b2);
		purse.insert(b3);
		purse.insert(b4);
		Valuable[] result = purse.withdraw(new BankNote(10 , "dollar"));
		assertTrue(result != null);
		assertEquals(1, result.length);
		assertSame(b2, result[0]);
	}
	
	/**
	 * Sum the value of some coins.
	 * @param coins array of coins
	 * @return sum of values of the coins
	 */
	private double sum(Valuable[] coins)  {
		if (coins == null) return 0.0;
		double sum = 0;
		for(Valuable c: coins) if (c != null) sum += c.getValue();
		return sum;
	}
}