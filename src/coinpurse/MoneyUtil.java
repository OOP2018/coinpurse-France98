package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter currency of coin and sort the coin.
 * 
 * @author Phanuwatch Luangpradit
 *
 */
public class MoneyUtil {

	/**
	 * Print value of coin and currency that in the list.
	 * @param coins
	 */
	private static void printCoin(List<Coin> coins) {
		for(int i = 0; i < coins.size(); i++){
			System.out.println(coins.get(i));
		}
	}

	/**	
	 * Filter the coin by using currency
	 * @param coins
	 * @param currency
	 * @return
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> same = new ArrayList<>();
		for (int i = 0; i < coins.size(); i++) {
			if (coins.get(i).getCurrency().equalsIgnoreCase(currency)) {
				same.add(coins.get(i));
			}
		}
		return same;
	}

	/**
	 * Sort the coin value by using Collections.sort
	 * @param coin
	 */
	public static void sortCoins(List<Coin> coin) {
		java.util.Collections.sort(coin);
	}
	
	/**
	 * Test the method.
	 * @param arg
	 */
	public static void main(String[] arg) {
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10, "Baht"));
		coins.add(new Coin(5, "Baht"));
		coins.add(new Coin(20, "Baht"));
		coins.add(new Coin(25, "Baht"));
		coins.add(new Coin(40, "Dollar"));
		coins = filterByCurrency(coins, "Baht");
		printCoin(coins);
	}
}
