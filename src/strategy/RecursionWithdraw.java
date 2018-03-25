package strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.MoneyUtil;
import coinpurse.Valuable;

/** 
 * Withdraw using recursion
 * @author Phanuwatch Luangpradit
 *
 */
public class RecursionWithdraw implements WithdrawStrategy{

	/**
	 * Find items from a collection that total value equals to the requested amount.
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		return withdrawHelper(amount.getValue(), MoneyUtil.filterByCurrency(money, amount.getCurrency()));
	}

	/**
	 * Helper method of withdraw in recursion
	 * @param amount that you want to withdraw
	 * @param money List of Valuable
	 * @return the money
	 */
	public List<Valuable> withdrawHelper(double amount, List<Valuable> money){
		if(amount == 0){
			return new ArrayList<Valuable>();
		}
		if(amount <= 0){
			return null;
		}if(money.isEmpty() && amount != 0){
			return null;
		}
		
		double remaining = amount - money.get(0).getValue();
		List<Valuable> left = withdrawHelper(remaining, money.subList(1, money.size()));
		List<Valuable> right = withdrawHelper(amount, money.subList(1, money.size()));
		if(left != null){
			left.add(money.get(0));
			return left;
		}return right;
	}
	
}
