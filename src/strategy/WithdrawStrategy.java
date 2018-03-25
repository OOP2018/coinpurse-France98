package strategy;

import java.util.List;

import coinpurse.Valuable;

/** 
 * Interface for Withdraw using Strategy Pattern
 * @author Phanuwatch Luangpradit
 *
 */
public interface WithdrawStrategy {

	/**
	 * Find and return items from a collection whose total value equals
	 * the requested amount.
	 * @param amount is the amount of the money to withdraw, with currency
	 * @param money the contents that are available for possible withdraw.
	 * 		  Must not be null, but may be an empty list.
	 * 		  This list is not modified.
	 * @return if a solution is found, return a List containing references
	 * 		   from the money parameter (List) whose sum equals the amount.
	 * 		   if a solution is not found, returns
	 */
	public List<Valuable> withdraw(Valuable amount ,List<Valuable> money);
}
