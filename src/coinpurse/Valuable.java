package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * @author Phanuwatch Luangpradit
 *
 */
public interface Valuable extends Comparable<Valuable>{
	
	/**
	 * Get money value
	 */
	public double getValue();
	
	/**
	 * Get money currency
	 */
	public String getCurrency();
}
