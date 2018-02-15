package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Phanuwatch Luangpradit
 *
 */
public class Coin extends Money{
	/**
	 * Constructor for coin with a value and currency
	 * @param value of the coin
	 * @param currency of the coin
	 */
	public Coin(double value, String currency){
		super(value,currency);
	}
	
	/**
	 * Tell value and currency
	 * @return the sentence that tell value and currency.
	 */
	public String toString(){
		return getValue() + "-" + getCurrency();
	}
	
}
