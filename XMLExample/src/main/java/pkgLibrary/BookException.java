package pkgLibrary;

public class BookException extends Exception {
	private Book book;
	private Catalog cat;
	private String bookID;
	
	public BookException(Book book, String message) {
		super(message);
		System.out.println(message);
		this.book = book;
	}
	
	public BookException(Book book, Catalog cat, String message) {
		super(message);
		System.out.println(message);
		this.book = book;
		this.cat = cat;
	}
	
	public BookException(String bookID, Catalog cat, String message) {
		super(message);
		System.out.println(message);
		this.bookID = bookID;
		this.cat = cat;
	}
	
	public Book getBook() {
		return book;
	}
	
	public Catalog getCatalog() {
		return cat;
	}
}
