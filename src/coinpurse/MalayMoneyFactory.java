package coinpurse;

public class MalayMoneyFactory extends MoneyFactory{
	
	private String currency = "Ringgit";

	@Override
	public Valuable createMoney(double value) {
		if(value == 0.05 || value == 0.1 || value == 0.2 || value == 0.5){
			return new Coin(value , currency);
		}else if(value == 1 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100){
			return new BankNote(value , currency);
		}else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String getCurrency() {
		return currency;
	}

}
