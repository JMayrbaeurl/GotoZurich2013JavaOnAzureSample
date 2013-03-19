package at.dpe.gotocon2013.bookstore.da;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import at.dpe.gotocon2013.bookstore.domainmodel.Book;
import at.dpe.gotocon2013.bookstore.domainmodel.Book.Rating;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestCaseMongoDBBookRepository {

	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void testAutowiring() {
		assertNotNull(this.bookRepository);
	}

	@Test
	public void testInsertNewBook() {
		
		Book newBook = new Book();
		newBook.setTitle("Once upon a time");
		newBook.setIsbn("1234-1234-1234-1234");
		newBook.setDescription("Ein wirklich spannendes Buch über ich weiss nichts");
		newBook.setRating(Rating.GOOD);
		
		this.bookRepository.save(newBook);
	}
}
