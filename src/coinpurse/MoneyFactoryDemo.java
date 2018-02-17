package coinpurse;

/**
 * Test MoneyFactory
 * @author Phanuwatch Luangpradit
 *
 */
public class MoneyFactoryDemo {

	public static void main(String[] args) {
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		MoneyFactory mf = MoneyFactory.getInstance();
		MoneyFactory mf2 = MoneyFactory.getInstance();
		System.out.println(mf == mf2);
		System.out.println("-----------------------------------");
		Purse purse = new Purse(5);
		purse.insert(mf.createMoney(1));
		purse.insert(mf.createMoney(5));
		purse.insert(mf.createMoney(10));
		purse.insert(mf.createMoney(50));
		purse.insert(mf.createMoney(100));
		System.out.println(purse.getMoney());
	}
}
