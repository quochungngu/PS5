package pkgLibrary;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;	
	
	@XmlElement(name="book")
	ArrayList<Book> books;
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public Book getBook(String bookID) throws BookException{
		try {
			for(Book book:books) {
				if (book.getId().equals(bookID)) {
					return book;
				}
			}
			throw new BookException(bookID, this, "Can't find book in catalog.\n");
		}
		catch(BookException e) {
			return null;
			// Swallowing to test the method
		}
	}

	public void addBook(Book book) throws BookException{
		try {
			for(Book b:books) {
				if (b.getId().equals(book.getId())) {
					throw new BookException(book, this, "Book already exists in catalog. Can't add.\n");
				}
			}
			books.add(book);
		}
		catch(BookException e) {
			// Swallowing to test the method
		}
	}
}