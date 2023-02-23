package mediaRentalManager;

/**
 * This class stores the information of each Media, which will be
 * stored in the main ArrayList called mediaList. Each Media type
 * will be either a Movie or an Album.
 * 
 * @author Shishir Velma
 */
public class Media {

	private String title;
	private int copies;
	
	/**
	 * Constructor for the base class.
	 * Stored in the main ArrayList called mediaList.
	 * @param title
	 * @param copies
	 */
	public Media(String title, int copies) {
		this.title = title;
		this.copies = copies;
	}
	
	/**
	 * getter for Media title
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * getter for Media copies available
	 * @return copies
	 */
	public int getCopies() {
		return copies;
	}
	
	/**
	 * changes copies available. Can increase or decrease
	 * by 1.
	 * @param step
	 */
	public void changeCopies(int step) {
		copies += step;
	}
}
