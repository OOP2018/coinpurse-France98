package coinpurse;

/**
 * Super class of Coin and BankNote
 * @author Phanuwatch Luangpradit
 *
 */
public class Money implements Valuable{

	protected double value;
	protected String currency;

	/**
	 * Constructor of Money with value and currency
	 * @param value of money
	 * @param currency of money
	 */
	public Money(double value, String currency) {
		if(value <= 0){
			this.value = 0;
		}else{
			this.value = value;
		}
		this.currency = currency;
	}

	/**
	 * Return the value of coin
	 * @return value of coin
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Return the coin currency
	 * @return currency of coin
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Two money are equal if they have same value and currency
	 */
	public boolean equals(Object o){
		if(o == null){
			return false;
		}if(this.getClass() != o.getClass()){
			return false;
		}
		Money other = (Money) o;
		if(other.getValue() == this.getValue() && other.getCurrency().equalsIgnoreCase(this.getCurrency())){
			return true;
		}return false;
	}

	/**
	 * Compare the currency if currency is same, it will compare the value.
	 */
	@Override
	public int compareTo(Valuable o) {
		if(this.currency.compareToIgnoreCase(o.getCurrency()) == 0){
			return Double.compare(this.value, o.getValue());
		}return this.currency.compareToIgnoreCase(o.getCurrency());
	}

}