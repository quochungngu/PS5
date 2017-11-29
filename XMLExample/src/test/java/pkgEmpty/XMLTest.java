package pkgEmpty;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;
import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.BookException;
import pkgLibrary.Catalog;
import pkgMain.XMLReader;

public class XMLTest {
	
	private Catalog cat;
	
	@Before
	public void readCatalog() {
		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		this.cat = cat;
	}

	@Test
	public void testGetBook() throws BookException{
		Book bookExist = cat.getBook("bk101");
		
		//For testing, the method just throws error, assigns null, and then swallows BookException
		Book bookNotExist = cat.getBook("wrong");
		
		assertNotNull(bookExist);
		assertNull(bookNotExist);
	}
	
	@Test
	public void testAddBook() throws BookException{
		int newSize = cat.getBooks().size() + 1;
		
		// add new book
		cat.addBook(new Book("book","a","b","c",5.00,new Date(), "d", 4.00));
		assertEquals(cat.getBooks().size(), newSize);
		
		// try to add same book again; newSize is unchanged
		// BookException error is swallowed for test
		cat.addBook(new Book("book","a","b","c",5.00,new Date(), "d", 4.00));
		assertEquals(cat.getBooks().size(), newSize);
	}
}