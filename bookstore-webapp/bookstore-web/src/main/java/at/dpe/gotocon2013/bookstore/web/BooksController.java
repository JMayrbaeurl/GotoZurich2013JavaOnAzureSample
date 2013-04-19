package at.dpe.gotocon2013.bookstore.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import at.dpe.gotocon2013.bookstore.da.BookRepository;
import at.dpe.gotocon2013.bookstore.domainmodel.Book;

@Controller
public class BooksController {

	private BookRepository myBooks;

	/**
	 * @param myBooks
	 */
	@Autowired
	public BooksController(BookRepository myBooks) {
		super();
		this.myBooks = myBooks;
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
    public String list(Model model) {
		Iterable<Book> booksInRep = this.myBooks.findAll();
		Iterator<Book> iter = booksInRep.iterator();
		List<Book> books = new ArrayList<Book>();
		while(iter.hasNext())
			books.add(iter.next());
		
		model.addAttribute("books", books);
		
		model.addAttribute("now", (new Date()).toString());
		
		return "books/list";
    }
}
