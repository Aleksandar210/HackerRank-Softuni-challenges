package softuni_objectsandclasses_folder;



public class Article {
	private String title;
	private String author;
	private String content;
	
	public Article(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	
	public Article() {
		
	}
	
	
	
	
	public void edit(String newContent) {
		this.content = newContent;
	}
	
	public void changeAuthor(String newAuthor) {
		this.author = newAuthor;
	}
	
	public void rename(String newTitle) {
		this.title = newTitle;
	}
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return title + " " + content + " -" + author;
	}

	

	
	

}
