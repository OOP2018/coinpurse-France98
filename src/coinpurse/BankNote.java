package coinpurse;

/**
 * BankNote represents BankNote with a fixed value and currency.
 * @author Phanuwatch Luangpradit
 *
 */
public class BankNote extends Money{
	
	private long serialNumber;
	private static long nextSerialNumber = 1000000;
	
	/**
	 * Constructor of BankNote with value and currency
	 * @param value of BankNote
	 * @param currency of BankNote
	 */
	public BankNote(double value , String currency){
		super(value,currency);
		this.serialNumber = nextSerialNumber++;
	} 
	
	/**
	 * return the serial number
	 * @return serial number of the banknote
	 */
	public long getSerial(){
		return this.serialNumber;
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
