package coinpurse;

import java.util.Comparator;

/**
 * Compare money by using currency and value
 * @author Phanuwatch Luangpradit
 *
 */
public class ValueComparator implements Comparator<Valuable> {

	/**
	 * Compare two objects that implement Valuable.
	 * First compare them by currency, so that "Baht" < "Dollar".
	 * If both objects have the same currency, order them by value.
	 */
	@Override
	public int compare(Valuable arg0, Valuable arg1) {
		if(arg0.getCurrency().equalsIgnoreCase(arg1.getCurrency())){
			if(arg0.getValue() < arg1.getValue()){
				return -1;
			}else if(arg0.getValue() > arg1.getValue()){
				return 1;
			}else{
				return 0;
			}
		}return arg0.getCurrency().compareToIgnoreCase(arg1.getCurrency());
	}
}
