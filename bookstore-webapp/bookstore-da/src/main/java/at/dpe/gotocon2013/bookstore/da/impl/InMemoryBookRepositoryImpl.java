package at.dpe.gotocon2013.bookstore.da.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.CollectionFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import at.dpe.gotocon2013.bookstore.da.BookRepository;
import at.dpe.gotocon2013.bookstore.domainmodel.Book;

public class InMemoryBookRepositoryImpl implements BookRepository {

	private Map<String, Book> store = new HashMap<>();
	
	public InMemoryBookRepositoryImpl() {
		//
		// Create a set of dummy-books for the in-memory repository
		//
		for (int i = 0; i < 10; i++) {
			Book b = new Book
					     (
					      "Book " + String.valueOf(i),
					      "ISBN " + String.valueOf(i),
					      "Some description for this book... Number " + String.valueOf(i)
					     );
			this.save(b);
		}
	}

	@Override
	public Iterable<Book> findAll(Sort sort) {
		return store.values();
	}

	@Override
	public Page<Book> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public <S extends Book> S save(S entity) {

		if (store.containsKey(entity.getIsbn())) {
			store.remove(entity.getIsbn());
		}
		store.put(entity.getIsbn(), entity);

		return entity;
	}

	@Override
	public <S extends Book> Iterable<S> save(Iterable<S> entities) {
		for (S s : entities) {
			this.save(s);
		}
		return null;
	}

	@Override
	public Book findOne(String id) {
		return store.get(id);
	}

	@Override
	public boolean exists(String id) {
		return this.store.containsKey(id);
	}

	@Override
	public Iterable<Book> findAll() {
		return this.store.values();
	}

	@Override
	public Iterable<Book> findAll(Iterable<String> ids) {
		@SuppressWarnings("unchecked")
		Collection<Book> filteredBooks = (Collection<Book>)CollectionFactory.createCollection(Book.class, 0);
		for (String bookId : ids) {
			if (this.store.containsKey(bookId)) {
				filteredBooks.add(this.store.get(bookId));
			}
		}

		return filteredBooks;
	}

	@Override
	public long count() {
		return this.store.size();
	}

	@Override
	public void delete(String id) {
		if (this.store.containsKey(id)) {
			this.store.remove(id);
		}
	}

	@Override
	public void delete(Book entity) {
		if (this.store.containsKey(entity.getIsbn())) {
			this.store.remove(entity.getIsbn());
		}
	}

	@Override
	public void delete(Iterable<? extends Book> entities) {
		for (Book book : entities) {
			this.delete(book);
		}
	}

	@Override
	public void deleteAll() {
		this.store = new HashMap<>();
	}
}
