package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Phanuwatch Luangpradit
 *
 */
public class MoneyUtil {

	public static List<Coin> filterByCurency(List<Coin> coins, String currency) {
		List<Coin> same = new ArrayList<>();
		for (int i = 0; i < coins.size(); i++) {
			if (coins.get(i).getCurrency().equalsIgnoreCase(currency)) {
				same.add(coins.get(i));
			}
		}
		return same;
	}
	
	public static void sortCoins(List<Coin> coin){
		java.util.Collections.sort(coin);
	}
	
}
