package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book> {
	List<Book> books;
	
	public Library() {
		this.books = new ArrayList<Book>();
	}
	
	public void addBook(Book currentBookAdd) {
		this.books.add(currentBookAdd);
	}

	@Override
	public Iterator<Book> iterator() {
		
		return new LibIterator(books);
	}
	
	
	

	private class LibIterator implements Iterator<Book>{
		private int indexOfBook;
		private List<Book> listWithBooks;
		
		public LibIterator(List<Book> listWithBooks) {
			indexOfBook = 0;
			this.listWithBooks=listWithBooks;
		}
		
		@Override
		public boolean hasNext() {
			if(indexOfBook<listWithBooks.size()) {
				return true;
			}else {
			return false;	
			}
			 
		}

		@Override
		public Book next() {
			Book currentBook = listWithBooks.get(indexOfBook);
			indexOfBook++;
			return currentBook;
			
		}
		
	}
	

}
