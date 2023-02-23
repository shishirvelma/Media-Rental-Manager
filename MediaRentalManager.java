package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MediaRentalManager implements MediaRentalManagerInt {

	private ArrayList<Customer> customerList;
	private ArrayList<Media> mediaList;
	private int limit;
	
	public MediaRentalManager() {
		customerList = new ArrayList<Customer>();
		mediaList = new ArrayList<Media>();
		limit = 2;
	}
	
	
	public void addCustomer(String name,
            String address,
            String plan) {
		
		customerList.add( new Customer(name, address, plan) );
	}
	
	public void addMovie(String title,
            int copiesAvailable,
           String rating) {
		
		mediaList.add( new Movie(title,copiesAvailable, rating) );
	}
	
	public void addAlbum(String title,
            int copiesAvailable,
            String artist,
            String songs) {
		
		mediaList.add( new Album(title,copiesAvailable, artist, songs) );
	}
	
	public void setLimitedPlanLimit(int value) {
		this.limit = value;
	}
	
	public String getAllCustomersInfo() {
		String answer = "***** Customers' Information *****" + "\n";
		
		Collections.sort(customerList, Comparator.comparing(Customer::getName));
		
		for (int i = 0; i < customerList.size(); i++) {
			answer += "Name: " + customerList.get(i).getName() + ", " 
					+ "Address: " + customerList.get(i).getAddress() + ", " 
					+ "Plan: " + customerList.get(i).getPlan() + "\n";
			answer += "Rented: " + customerList.get(i).getRent() + "\n" 
					+ "Queue: " + customerList.get(i).getQueue() + "\n";
		}
		
//		System.out.print(answer);
		
		return answer;
	}
	
	public String getAllMediaInfo() {
		String answer = "***** Media Information *****" + "\n";
		
		Collections.sort(mediaList, Comparator.comparing(Media::getTitle));
		
		for (int i = 0; i < mediaList.size(); i++) {
			
			answer += "Title: " + mediaList.get(i).getTitle() 
					+ ", Copies Available: " + mediaList.get(i).getCopies();
			
			if (mediaList.get(i).getClass() == Album.class) {
				
				answer += ", Artist: " + ((Album) mediaList.get(i)).getArtist()
						+ ", Songs: " + ((Album) mediaList.get(i)).getSongs()
						+ "\n";
				
			} else {

				answer += ", Rating: " + ((Movie) mediaList.get(i)).getRating()
						+ "\n";
			}
		}
//		System.out.print(answer);
		return answer;
	}
	
	public boolean addToQueue(String customerName,
            String mediaTitle) {
		
		boolean answer = true;
		
		int index = customerIndex(customerName);
		
		if (index > -1) {	
			for (int j = 0; j < customerList.get(index).getQueue().size();
					j++) {
				
				if (customerList.get(index).getNameInQueue(j) == mediaTitle) {
					answer = false;
				}
			}
			
			if (answer == true) {
				
				customerList.get(index).addQueue(mediaTitle); 				
			}		
		}
//		System.out.print(answer);
		return answer;
	}
	
	public boolean removeFromQueue(String customerName,
            String mediaTitle) {
		
		boolean answer = false;
		
		int index = customerIndex(customerName);
		
		if (index > -1) {
			
			for (int j = 0; j < customerList.get(index).getQueue().size();
					j++) {	
				
				if (customerList.get(index).getNameInQueue(j) == mediaTitle) {
					customerList.get(index).removeQueue(j);
					answer = true;
				}
			}
		}
//		System.out.print(answer);
		return answer;
	}
	
	public String processRequests() {
		String answer = "";
		String mediaTitle;
		int mediaIndex;
		
		Collections.sort(customerList, Comparator.comparing(Customer::getName));
		Collections.sort(mediaList, Comparator.comparing(Media::getTitle));
		
		for (int i = 0; i < customerList.size(); i++) {
			
			for (int j = 0; j < customerList.get(i).getQueue().size();
					j++) {
				
				mediaTitle = customerList.get(i).getNameInQueue(j);
				
				
				mediaIndex = findMediaIndex(mediaTitle);
				if (mediaIndex > -1 &&
						mediaList.get(mediaIndex).getCopies() > 0 &&
						( customerList.get(i).getRent().size() < limit ||
						  customerList.get(i).getPlan() == "UNLIMITED")) {
					
					answer += "Sending " + mediaTitle + " to " 
							+ customerList.get(i).getName() + "\n";
					
					customerList.get(i).AddRent(mediaTitle);
					mediaList.get(mediaIndex).changeCopies(-1);
					customerList.get(i).removeQueue(j);
					j--;
					
				}
			}
		}
//		System.out.print(answer);
		return answer;
	}
	
	public boolean returnMedia(String customerName,
            String mediaTitle) {
		
		boolean answer = false;
		
		int index = customerIndex(customerName);
		
		if (index > -1) {
			
			for (int j = 0; j < customerList.get(index).getRent().size();
					j++) {	
				
				if (customerList.get(index).getNameInRent(j) == mediaTitle) {
					customerList.get(index).removeRent(j);
					answer = true;
				}
			}
		}
		
		if (answer == true) {
			
			for (int k = 0; k < mediaList.size(); k++) {
				
				if (mediaList.get(k).getTitle() == mediaTitle) {
					mediaList.get(k).changeCopies(1);
				}
			}	
		}
//		System.out.print(answer);
		return answer;
	}
	
	public ArrayList<String> searchMedia(String title,
            String rating,
            String artist,
            String songs) {
		
		Collections.sort(customerList, Comparator.comparing(Customer::getName));
		Collections.sort(mediaList, Comparator.comparing(Media::getTitle));
		
		ArrayList<String> answer = new ArrayList<String>();
		int titleCheck = 0;
		int ratingCheck = 0;
		int artistCheck = 0;
		int songsCheck = 0;
		
		String songList = "";
		
		if (title == null) {
			titleCheck = -1;
		}
		
		if (rating == null) {
			ratingCheck = -1;
		}
		
		if (artist == null) {
			artistCheck = -1;
		}
		
		if (songs == null) {
			songsCheck = -1;
		}
		
		
		for (int i = 0; i < mediaList.size(); i++) {
			
			if (titleCheck == 1) {
				titleCheck = 0;
			}
			
			if (ratingCheck == 1) {
				ratingCheck = 0;
			}
			
			if (artistCheck == 1) {
				artistCheck = 0;
			}
			
			if (songsCheck == 1) {
				songsCheck = 0;
			}
			
			
			if (mediaList.get(i).getTitle() == title &&
					titleCheck > -1) {
				titleCheck = 1;
			}
			
			
			
			if (mediaList.get(i).getClass() == Movie.class &&
					ratingCheck > -1) {
			
				if (((Movie) mediaList.get(i)).getRating() == rating &&
						ratingCheck > -1) {
					ratingCheck = 1;
				}
			} else if (mediaList.get(i).getClass() == Album.class &&
					( artistCheck > -1 ||
							songsCheck > -1 )){
			
				if (((Album) mediaList.get(i)).getArtist() == artist &&
						artistCheck > -1) {
					artistCheck = 1;
				}
				
				songList = ((Album) mediaList.get(i)).getSongs();
				
//				System.out.print(songList);
//				System.out.print(songList.indexOf(songs));
				
				if (songList.indexOf(songs) >= 0 &&
						songsCheck > -1) {
					songsCheck = 1;
				}
			}
			
			if (titleCheck != 0 &&
					ratingCheck != 0 &&
					artistCheck != 0 &&
					songsCheck != 0) {
				answer.add(mediaList.get(i).getTitle());
				
			}
			
		}
		System.out.print(answer);
		return answer;
	}
	
	
	private int findMediaIndex(String mediaTitle) {
		int answer = -1;
		
		for (int i = 0; i < mediaList.size(); i++) {
			if (mediaList.get(i).getTitle() == mediaTitle) {
				answer = i;			
			}
		}
		
		
		return answer;		
	}
	
	
	private int customerIndex(String name) {
		int answer = -1;
		
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getName() == name) {
				answer = i;			
			}
		}
		
		return answer;		
	}
}
