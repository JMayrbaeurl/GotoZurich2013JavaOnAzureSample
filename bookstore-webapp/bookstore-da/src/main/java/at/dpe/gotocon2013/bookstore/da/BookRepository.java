/**
 * 
 */
package at.dpe.gotocon2013.bookstore.da;

import org.springframework.data.repository.PagingAndSortingRepository;

import at.dpe.gotocon2013.bookstore.domainmodel.Book;

/**
 * @author jurgenma
 *
 */
public interface BookRepository extends PagingAndSortingRepository<Book, String> {

}
