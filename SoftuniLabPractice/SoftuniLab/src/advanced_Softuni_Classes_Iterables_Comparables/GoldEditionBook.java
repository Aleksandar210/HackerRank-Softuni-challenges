package advanced_Softuni_Classes_Iterables_Comparables;

public class GoldEditionBook extends Book {
	
	
	
	
public GoldEditionBook(String author, String title,double price) {
	super(author,title,price);
	calculatePrice(price);
}

private void calculatePrice(double price) {
	super.setPrice(0.3*price);
}

@Override
public String toString() {
	String current = String.format("%s %s %f",super.getAuthors(),super.getTitle(),super.getPrice());
	return current;
}


}
