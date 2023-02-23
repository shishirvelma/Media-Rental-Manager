package mediaRentalManager;


/**
 * This class extends the Media class. It is a subclass, and
 * it inherits the variables and methods from Media. This class
 * is specifically for Media that are Movies. 
 * 
 * @author Shishir Velma
 */
public class Movie extends Media {

	private String rating;
	
	/**
	 * Constructor for a Movie, which is a type of Media.
	 * Stored in the main ArrayList called mediaList.
	 * @param title
	 * @param copies
	 * @param rating
	 */
	public Movie(String title, int copies, String rating) {
		
		super(title, copies);
		this.rating = rating;	
	}

	/**
	 * getter for movie rating
	 * @return rating
	 */
	public String getRating() {
		return rating;
	}

}
