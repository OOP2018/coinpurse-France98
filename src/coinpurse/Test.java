package coinpurse;

import java.util.Arrays;
import java.util.List;

import strategy.RecursionWithdraw;
import strategy.WithdrawStrategy;

public class Test {
	
	static WithdrawStrategy strategy = new RecursionWithdraw();

	public static void main(String[] args) {
		Valuable b2 = new BankNote(10,"dollar");
		Valuable b1 = new BankNote(10,"baht");
		Valuable b3 = new BankNote(10,"yen");
		Valuable b4 = new BankNote(10,"ringgit");
		List<Valuable> list = Arrays.asList(b2,b1,b3,b4);
		
		List<Valuable> result = strategy.withdraw(b2, list);
		System.out.println(result);
	}
}
