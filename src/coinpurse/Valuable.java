package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * @author Phanuwatch Luangpradit
 *
 */
public interface Valuable extends Comparable<Valuable>{
	
	/**
	 * Get money value
	 * @return the value of money
	 */
	public double getValue();
	
	/**
	 * Get money currency
	 * @return the currency of money
	 */
	public String getCurrency();
}
