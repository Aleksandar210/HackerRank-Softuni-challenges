package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.Comparator;

public class ComparePersonByName implements Comparator<Person> {

	
	@Override
	public int compare(Person o1, Person o2) {
		
		if(o1.getName().length()==o2.getName().length()) {
			if(o1.getName().charAt(0)==o2.getName().charAt(0)) {
				return 0;
			}else {
				int first = o1.getName().charAt(0);
				int second = o2.getName().charAt(0);
				return first-second;
			}
		}else {
			return o1.getName().length()-o2.getName().length();
		}
	}

}
