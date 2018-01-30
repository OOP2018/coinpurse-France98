package coinpurse;

/**
 * 
 * @author Phanuwatch Luangpradit
 *
 */
public class BankNote implements Valuable{
	
	private double value;
	private String currency;
	private long serialNumber;
	private static long nextSerialNumber = 1000000;
	
	public BankNote(double value , String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = this.nextSerialNumber++;
	} 
	
	/**
	 * return the value of this BankNote
	 * @return value of 
	 */
	public double getValue(){
		return this.value;
	}
	
	public String getCurrency(){
		return this.currency;
	}
	
	public long getSerial(){
		return this.serialNumber;
	}
	
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
	
	public String toString(){
		return getValue() + "-" + getCurrency() + " note [" + serialNumber + "]";
	}

	@Override
	public int compareTo(Valuable coin) {
		if(this.value < coin.getValue()){
			return -1;
		}else if(this.value > coin.getValue()){
			return 1;
		}else{
			return 0;
		}
	}
	
}
