package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Phanuwatch Luangpradit
 */
public class Purse {
	/** Collection of objects in the purse. */
	List<Valuable> money1 = new ArrayList<Valuable>();
	Comparator<Valuable> comp = new ValueComparator();

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money1.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double sum = 0;
		for (int i = 0; i < money1.size(); i++) {
			sum += money1.get(i).getValue();
		}
		return sum;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (getCapacity() == count()) {
			return true;
		}
		return false;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param money2
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable money2) {
		if (isFull()) {
			return false;
		} else if (money2.getValue() <= 0) {
			return false;
		}
		money1.add(money2);
		return true;

	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		if (amount < 0) {
			return null;
		}
		Collections.sort(money1,comp);
		Collections.reverse(money1);
		ArrayList<Valuable> list = new ArrayList<Valuable>();
		if (getBalance() >= amount) {
			for (int i = 0; i < money1.size() ; i++) {
				if (amount - money1.get(i).getValue() >= 0) {
					amount = amount - money1.get(i).getValue();
					list.add(money1.get(i));
				}
			}
		}
		if (amount != 0) {
			return null;
		}
		for (int i = 0; i < list.size(); i++) {
			money1.remove(list.get(i));
		}
		Valuable[] array = new Valuable[list.size()];
		list.toArray(array);
		return array;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return count() + " coins with value " + getBalance();
	}

	public List<Valuable> getMoney(){
		return money1;
	}
}

