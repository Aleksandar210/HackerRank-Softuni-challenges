package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		if(b1.getTitle().length()==b2.getTitle().length()) {
			if(b1.getYear()==b2.getYear()) {
				if(b1.getPages()==b2.getPages()) {
					if(b1.getAuthors().length==b2.getAuthors().length) {
						return 0;
					}else {
						return b1.getAuthors().length-b2.getAuthors().length;
					}
				}else {
					return b1.getPages()-b2.getPages();
				}
			}else {
				return b1.getYear()-b2.getYear();
			}
		}else {
			return b1.getTitle().length()-b2.getTitle().length();
		}
		
	}

}
