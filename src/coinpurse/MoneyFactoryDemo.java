package coinpurse;

/**
 * Test MoneyFactory
 * @author Phanuwatch Luangpradit
 *
 */
public class MoneyFactoryDemo {

	public static void main(String[] args) {
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory()); //set as a ThaiMoneyFactory
		MoneyFactory mf = MoneyFactory.getInstance(); //GetInstance
		MoneyFactory mf2 = MoneyFactory.getInstance();
		System.out.println(mf == mf2);  //if it Singleton it will return true
		System.out.println("-----------------------------------");
		Purse purse = new Purse(5);
		purse.insert(mf.createMoney(1)); //create money by using double valuable
		purse.insert(mf.createMoney(5));
		purse.insert(mf.createMoney(10));
		purse.insert(mf.createMoney("50")); //create money by using String valuable
		purse.insert(mf.createMoney("100")); 
		Money money = new Money(50,"Baht");
		System.out.println(mf.createMoney(50)); //create money by using double valuable
		System.out.println(purse.getMoney());  
		
	}
}
