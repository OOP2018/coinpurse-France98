package coinpurse;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.List;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Phanuwatch Luangpradit
 *
 */
public class Coin implements Valuable{
	private double value;
	private String currency;
	
	/**
	 * Constructor for coin with a value and currency
	 * @param value of the coin
	 * @param currency of the coin
	 */
	public Coin(double value, String currency){
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * Return the value of coin
	 * @return value of coin
	 */
	public double getValue(){
		return this.value;
	}
	
	/**
	 * Return the coin currency
	 * @return currency of coin
	 */
	public String getCurrency(){
		return this.currency;
	}
	
	/**
	 * Two coin are equal if they have same value and currency.
	 */
	public boolean equals(Object arg){
		if(arg == null){
			return false;
		}
		if(getClass() != arg.getClass()){
			return false;
		}
		Coin other = (Coin) arg;
		if(this.getValue() == other.getValue() && this.getCurrency().equalsIgnoreCase(other.getCurrency())){
			return true; 
		}
		return false;
	}
	
	/**
	 * Compare the value of two coins.
	 * @param coin
	 */
	public int compareTo(Valuable coin){
		if(this.value < coin.getValue()){
			return -1;
		}else if(this.value > coin.getValue()){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * Tell value and currency
	 * @return the sentence that tell value and currency.
	 */
	public String toString(){
		return this.value + "-" + this.currency;
	}
	
}
