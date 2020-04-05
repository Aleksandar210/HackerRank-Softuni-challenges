package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.Arrays;

public class Book implements Comparable<Book>{
	private String[] authors;
	private String title;
	private int year;
	private int pages;
	
	
	public Book(String title, int year, int pages, String...authors) {
		setTitle(title);
		setYear(year);
		setPages(pages);
		setAuthors(authors);
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
