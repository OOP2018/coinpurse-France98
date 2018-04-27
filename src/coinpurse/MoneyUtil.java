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
	private static void printCoin(List<? extends Valuable> coins) {
		for(int i = 0; i < coins.size(); i++){
			System.out.println(coins.get(i));
		}
	}

	/**	
	 * Filter the coin by using currency
	 * @param coins
	 * @param currency
	 * @return the list name's same
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<E> coins, String currency) {
		List<E> same = new ArrayList<>();
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
	public static void sortCoins(List<? extends Valuable> money) {
		java.util.Collections.sort(money);
	}
	
	public static <E extends Comparable<? super E>> E max(E ... args){
		E max = null;
		if(args.length > 0){
			for(int i = 0; i < args.length ; i++){
				max = args[i];
				if(args[i].compareTo(max) > 0){
					max = args[i];
				}
			}
		}
		return max;
	}
	
	/**
	 * Test the method.
	 * @param arg
	 */
	public static void main(String[] arg) {
//		List<Valuable> coins = new ArrayList<Valuable>();
//		coins.add(new Coin(10, "Baht"));
//		coins.add(new Coin(5, "Baht"));
//		coins.add(new Coin(20, "Baht"));
//		coins.add(new Coin(25, "Baht"));
//		coins.add(new Coin(40, "Dollar"));
//		coins = filterByCurrency(coins, "Baht");
//		printCoin(coins);
		String max = MoneyUtil.max("dog" , "zebra" , "cat" , "elephant");
		Money m1 = new BankNote(50, "Baht");
		Money m2 = new BankNote(500, "Baht");
		Money m3 = new BankNote(1000, "Baht");
		Money max2 = MoneyUtil.max(m1,m2,m3);
		System.out.println(max2);
	}
}
