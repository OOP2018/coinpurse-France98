package coinpurse;

public abstract class MoneyFactory {
	
	protected MoneyFactory(){
		
	}
	
	public static MoneyFactory instance ;

	public abstract Valuable createMoney(double value);

	public Valuable createMoney(String value){
		return createMoney(Double.parseDouble(value));
	}
	
	public static MoneyFactory getInstance(){
		return instance;
	}
	
	public static void setMoneyFactory(MoneyFactory mf){
		instance = mf;
	}
	
	public abstract String getCurrency();
}
