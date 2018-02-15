package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory{
	
	private String currency = "Baht";

	@Override
	public Valuable createMoney(double value) {
		if(value == 1 || value == 2 || value == 5 || value == 10){
			return new Coin(value , currency);
		}else if(value == 20 || value == 50 || value == 100 || value == 500 || value == 1000){
			return new BankNote(value, currency);
		}else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String getCurrency() {
		return currency;
	}

}
