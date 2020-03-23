package advanced_Softuni;

import java.util.HashSet;
import java.util.Set;

public class AdvancedExperiments {
@SuppressWarnings("deprecation")
public static void main(String[] args) {
	String temp = "Aleks Kuzmov";
	char c;
	StringBuilder sb = new StringBuilder(temp.length());
	
	for(int i =0;i<temp.length();i++) {
		c = temp.charAt(i);
		if(!Character.isSpace(c)) {
			sb.append(c);
		}
	}
	
	System.out.println(sb.toString());
	
}
}
