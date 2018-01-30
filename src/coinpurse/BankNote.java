package coinpurse;

/**
 * BankNote represents BankNote with a fixed value and currency.
 * @author Phanuwatch Luangpradit
 *
 */
public class BankNote implements Valuable{
	
	private double value;
	private String currency;
	private long serialNumber;
	private static long nextSerialNumber = 1000000;
	
	/**
	 * Constructor of BankNote with value and currency
	 * @param value of BankNote
	 * @param currency of BankNote
	 */
	public BankNote(double value , String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = this.nextSerialNumber++;
	} 
	
	/**
	 * return the value of this BankNote
	 * @return value of money
	 */
	public double getValue(){
		return this.value;
	}
	
	/**
	 * return the currency of this BankNote
	 * @return currency of money
	 */
	public String getCurrency(){
		return this.currency;
	}
	
	/**
	 * return the serial number
	 * @return serial number of the banknote
	 */
	public long getSerial(){
		return this.serialNumber;
	}
	
	/**
	 * The Banknote are equal if they have same value and currency
	 */
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(getClass() != obj.getClass()){
			return false;
		}
		BankNote other = (BankNote) obj;
		if(this.getValue() == other.getValue() && this.getCurrency().equalsIgnoreCase(other.getCurrency())){
			return true; 
		}
		return false;
	}
	
	/**
	 * Tell the value and currency
	 * @return the sentence
	 */
	public String toString(){
		return getValue() + "-" + getCurrency() + " note [" + serialNumber + "]";
	}

	/**
	 * Compare the value of two banknotes
	 * @param money
	 */
	@Override
	public int compareTo(Valuable money) {
		if(this.value < money.getValue()){
			return -1;
		}else if(this.value > money.getValue()){
			return 1;
		}else{
			return 0;
		}
	}
	
}
