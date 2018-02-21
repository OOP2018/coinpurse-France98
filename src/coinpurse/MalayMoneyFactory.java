package coinpurse;

/**
 * Subclass of MoneyFactory
 * Create and get currency of money
 * @author France98
 *
 */
public class MalayMoneyFactory extends MoneyFactory{
	
	private String currency = "Ringgit";
	private static long nextSerialNumber = 1000000;

	/**
	 * Create the money
	 * @return if it's a coin return coin
	 * 		   if it's a bank return BankNote
	 * 		   if value is not valid currency amount, then throw IllegalArgumentException
	 */
	@Override
	public Valuable createMoney(double value) {
		if(value == 0.05 || value == 0.1 || value == 0.2 || value == 0.5){
			return new Coin(value , currency);
		}else if(value == 1 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100){
			return new BankNote(value , currency , nextSerialNumber++);
		}else{
			throw new IllegalArgumentException("Not valid currency amount");
		}
	}

	/**
	 * Get the money currency
	 * @return Malay Ringgit currency
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

}
