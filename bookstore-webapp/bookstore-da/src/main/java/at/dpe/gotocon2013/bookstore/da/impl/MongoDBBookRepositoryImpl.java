/**
 * 
 */
package at.dpe.gotocon2013.bookstore.da.impl;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import at.dpe.gotocon2013.bookstore.da.BookRepository;
import at.dpe.gotocon2013.bookstore.domainmodel.Book;

/**
 * @author jurgenma
 *
 */
public class MongoDBBookRepositoryImpl extends SimpleMongoRepository<Book, String> implements BookRepository {
	
	/**
	 * @param metadata
	 * @param mongoOperations
	 */
	public MongoDBBookRepositoryImpl(
			/*MongoEntityInformation<Book, String> metadata,*/
			MongoOperations mongoOperations)
	{
		super(new BookMetadata(), mongoOperations);
	}
	
	private static class BookMetadata implements MongoEntityInformation<Book, String> {

		@Override
		public boolean isNew(Book entity) {
			// TODO Auto-generated method stub
			return (entity.getIsbn().length() == 0);
		}

		@Override
		public String getId(Book entity) {
			// TODO Auto-generated method stub
			return entity.getIsbn();
		}

		@Override
		public Class<String> getIdType() {
			// TODO Auto-generated method stub
			return String.class;
		}

		@Override
		public Class<Book> getJavaType() {
			// TODO Auto-generated method stub
			return Book.class;
		}

		@Override
		public String getCollectionName() {
			// TODO Auto-generated method stub
			return "book";
		}

		@Override
		public String getIdAttribute() {
			// TODO Auto-generated method stub
			return "Isbn";
		}
	}
}
