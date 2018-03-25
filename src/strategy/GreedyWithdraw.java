package strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.MoneyUtil;
import coinpurse.Valuable;
import coinpurse.ValueComparator;

/**
 * Withdraw using Greedy Algorithm
 * @author Phanuwatch Luangpradit
 * 
 */
public class GreedyWithdraw implements WithdrawStrategy{
	
	Comparator<Valuable> comp = new ValueComparator();

	/**
	 * Find items from a collection that total value equals to the requested amount.
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		double amount1 = amount.getValue();
		if (amount.getValue() < 0) {
			return null;
		}
		Collections.sort(money,comp);
		Collections.reverse(money);
		List<Valuable> m = MoneyUtil.filterByCurrency(money, amount.getCurrency());
		ArrayList<Valuable> list = new ArrayList<Valuable>();
//			for(Valuable v : m){
//				if(amount1 - v.getValue() >= 0){
//					amount1 = amount1 - v.getValue();
//					list.add(v);					
//				}
//			}
			for(int i = 0; i < m.size() ; i++){
				if(amount1 - m.get(i).getValue() >= 0){
					amount1 = amount1 - m.get(i).getValue();
					list.add(m.get(i));					
				}
			}
		if(amount1 != 0){
			return null;
		}
		for (int i = 0; i < list.size(); i++) {
			money.remove(list.get(i));
		}
		return list;
	}

	
}
