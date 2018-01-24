package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Phanuwatch Luangpradit
 */
public class Purse {
	/** Collection of objects in the purse. */
	List<Coin> coins = new ArrayList<Coin>();

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
		return coins.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double sum = 0;
		for (int i = 0; i < coins.size(); i++) {
			sum += coins.get(i).getValue();
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
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		if (isFull()) {
			return false;
		} else if (coin.getValue() <= 0) {
			return false; 
		}
		coins.add(coin);
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
	public Coin[] withdraw(double amount) {
		if (amount < 0) {
			return null;
		}
		MoneyUtil.sortCoins(coins);
		ArrayList<Coin> list = new ArrayList<Coin>();
		if (getBalance() >= amount) {
			for (int i = coins.size() -1 ; i >= 0 ; i--) {
				if (amount - coins.get(i).getValue() >= 0) {
					amount = amount - coins.get(i).getValue();
					list.add(coins.get(i));
				}
			}
		}
		if (amount != 0) {
			return null;
		}
		for (int i = 0; i < list.size(); i++) {
			coins.remove(list.get(i));
		}
		Coin[] array = new Coin[list.size()];
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

}

