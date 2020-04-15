package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.Arrays;

public class Book implements Comparable<Book>{
	private String[] authors;
	private String title;
	private int year;
	private int pages;
	private double price;
	
	
	protected double getPrice() {
		return price;
	}

	protected void setPrice(double price) {
		if(price<=0) {
			throw new IllegalArgumentException("Price is inavalid");
		}else {
		this.price = price;
		}
	}

	public Book(String title, int year, int pages, String...authors) {
		setTitle(title);
		setYear(year);
		setPages(pages);
		setAuthors(authors);
	}
	
	public Book(String author, String title, double price) {
		
	}
	


	public String[] getAuthors() {
		
		return authors;
	}


	@Override
	public String toString() {
		String bookInfo = String.format("%s: Writen by %s", this.title,displayAuthors());
		return bookInfo;
	}
	
	public String displayAuthors() {
		StringBuilder sb = new StringBuilder(this.getAuthors().length);
		for(String name:this.authors) {
			sb.append(name);
			sb.append(" ");
		}
		return sb.toString();
	}




	public void setAuthors(String...authors) {
		if(authors.length==1) {
			if(authors[0].contains("\\s+")) {
				if(Character.isDigit(authors[0].split("\\s+")[1].charAt(0))) {
					throw new IllegalArgumentException("Invalid author");
				}
			}
		}
		this.authors = authors;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getPages() {
		return pages;
	}


	public void setPages(int pages) {
		this.pages = pages;
	}




	@Override
	public int compareTo(Book otherBook) {
		if(this.title.length()==otherBook.title.length()) {
			if(this.pages==otherBook.pages) {
				if(this.year==otherBook.year) {
					if(this.authors.length==otherBook.authors.length) {
						return 0;
					}else {
						return this.authors.length - otherBook.authors.length;
					}
				}else {
					return this.year - otherBook.year;
				}
			}else {
				return this.pages-otherBook.pages;
			}
		}
		return this.title.length()-otherBook.title.length();
		
	}
	
	

}
