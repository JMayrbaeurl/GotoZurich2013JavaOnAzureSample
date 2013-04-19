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
	
	@Test
	public void testInsertMultipleBooks() {
		
		Book firstBook = new Book();
		firstBook.setTitle("Azure in Action");
		firstBook.setIsbn("978-1935182481");
		firstBook.setDescription("An essential guide to building scalable cloud applications in the Azure Services Platform, including Windows Azure, SQL Azure and .NET Services");
		firstBook.setRating(Rating.GOOD);
		firstBook.setImageUrl("images/AzureInAction.jpg");
		
		this.bookRepository.save(firstBook);
		
		Book secondBook = new Book();
		secondBook.setTitle("Programming Windows Azure");
		secondBook.setIsbn("978-0596801977");
		secondBook.setDescription("Learn the nuts and bolts of cloud computing with Windows Azure, Microsoft's new Internet services platform");
		secondBook.setRating(Rating.GOOD);
		secondBook.setImageUrl("images/ProgrammingWindowsAzure.jpg");
		
		this.bookRepository.save(secondBook);
	}
}
