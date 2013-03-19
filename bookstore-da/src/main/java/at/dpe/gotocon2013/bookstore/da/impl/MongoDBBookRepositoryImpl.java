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
			MongoEntityInformation<Book, String> metadata,
			MongoOperations mongoOperations) {
		
		super(metadata, mongoOperations);
	}
	
	private static class BookMetadata implements MongoEntityInformation<Book, String> {

		@Override
		public boolean isNew(Book entity) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String getId(Book entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Class<String> getIdType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Class<Book> getJavaType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getCollectionName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getIdAttribute() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
