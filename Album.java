package mediaRentalManager;

/**
 * This class extends the Media class. It is a subclass, and
 * it inherits the variables and methods from Media. This class
 * is specifically for Media that are Albums. 
 * 
 * @author Shishir Velma
 */
public class Album extends Media {

	private String artist;
	private String songs;
	
	/**
	 * Constructor for an Album, which is a type of Media.
	 * Stored in the main ArrayList called mediaList.
	 * @param title
	 * @param copies
	 * @param artist
	 * @param songs
	 */
	public Album(String title, int copies, String artist, String songs) {
		
		super(title, copies);
		this.artist = artist;	
		this.songs = songs;
	}

	/**
	 * getter for Album artist
	 * @return artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * getter for Album songs
	 * @return songs
	 */
	public String getSongs() {
		return songs;
	} 
}
