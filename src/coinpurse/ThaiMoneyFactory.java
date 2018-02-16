package coinpurse;

/**
 * Subclass of MoneyFactory
 * Create and get currency of money
 * @author Phanuwatch Luangpradit
 *
 */
public class ThaiMoneyFactory extends MoneyFactory{
	
	private String currency = "Baht";

	/**
	 * Create the money
	 * @return if it's a coin return coin
	 * 		   if it's a bank return BankNote
	 * 		   if value is not valid currency amount, then throw IllegalArgumentException
	 */
	@Override
	public Valuable createMoney(double value) {
		if(value == 1 || value == 2 || value == 5 || value == 10){
			return new Coin(value , currency);
		}else if(value == 20 || value == 50 || value == 100 || value == 500 || value == 1000){
			return new BankNote(value, currency);
		}else{
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Get the currency of ThaiMoneyFactory
	 * @return Thai Baht currency
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

}
