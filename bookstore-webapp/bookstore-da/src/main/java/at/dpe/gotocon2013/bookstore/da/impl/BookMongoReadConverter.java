package at.dpe.gotocon2013.bookstore.da.impl;

import org.springframework.core.convert.converter.Converter;

import at.dpe.gotocon2013.bookstore.domainmodel.Book;

import com.mongodb.DBObject;

public class BookMongoReadConverter implements Converter<DBObject, Book>{

	public Book convert(DBObject source) {
		Book b = new Book
					  (
					     source.get("title").toString(),
					     source.get("_id").toString(),
					     source.get("description").toString()
				      );
		b.setRating(Book.Rating.valueOf(source.get("rating").toString()));
		
		return b;
	}
	
}
