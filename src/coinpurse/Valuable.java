package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * @author Phanuwatch Luangpradit
 *
 */
public interface Valuable extends Comparable<Valuable>{
	public double getValue();
	public String getCurrency();
}
