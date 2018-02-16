package coinpurse;

/**
 * Create money such as Coin and BankNote
 * @author Phanuwatch Luangpradit
 *
 */
public abstract class MoneyFactory {

	public static MoneyFactory instance ;
	
	/**
	 * Constructor of MoneyFactory
	 */
	protected MoneyFactory(){
		
	}
	

	/**
	 * Create new money object in the local currency.
	 * @param value
	 */
	public abstract Valuable createMoney(double value);

	/**
	 * Accept money value as a String
	 * @param value
	 * @return createMoney
	 */
	public Valuable createMoney(String value){
		return createMoney(Double.parseDouble(value));
	}
	
	/**
	 * get an instance of MoneyFactory
	 * @return object of subclass such as ThaiMoneyFactory and MalayMoneyFactory
	 */
	public static MoneyFactory getInstance(){
		return instance;
	}
	
	/**
	 * Set MoneyFactory 
	 * @param mf
	 */
	public static void setMoneyFactory(MoneyFactory mf){
		instance = mf;
	}
	
	/**
	 * Get currency of subclass
	 * @return local currency
	 */
	public abstract String getCurrency();
}
