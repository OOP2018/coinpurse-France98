package coinpurse;

import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable> {

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
