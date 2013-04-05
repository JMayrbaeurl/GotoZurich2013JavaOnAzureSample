/**
 * 
 */
package at.dpe.gotocon2013.bookstore.domainmodel;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

/**
 * @author jurgenma
 *
 */
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	
	@Id
	private String isbn;
	
	private String description;
	
	public enum Rating { VERY_BAD, BAD, AVERAGE, GOOD, EXCELLENT };
	
	private Rating rating = Rating.AVERAGE;
	
	private String imageUrl;

	/**
	 * 
	 */
	public Book() {
		super();
	}
	

	/**
	 * @param title
	 * @param iSBN
	 * @param description
	 */
	public Book(final String title, final String iSBN, final String description) {
		
		super();
		
		this.title = title;
		this.isbn = iSBN;
		this.description = description;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/**
	 * @return the title
	 */
	public final String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public final void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public final void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the rating
	 */
	public final Rating getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public final void setRating(Rating rating) {
		this.rating = rating;
	}


	/**
	 * @return the isbn
	 */
	public final String getIsbn() {
		return isbn;
	}


	/**
	 * @param isbn the isbn to set
	 */
	public final void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * @param imageUrl the URL to an image for the book
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the URL to an image for the book to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
