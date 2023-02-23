package mediaRentalManager;

import java.util.ArrayList;

/**
 * This class stores the information of each customer, which will be
 * stored in the main ArrayList called customerList
 * 
 * @author Shishir Velma
 */
public class Customer {

	private String name;
	private String address;
	private String plan;
	private ArrayList<String> rent;
	private ArrayList<String> queue;
	
	/**
	 * Class that stores the information for each customer, 
	 * along with storing their queues.
	 * @param name
	 * @param address
	 * @param plan 
	 */
	public Customer(String name, String address, String plan) {
	
		this.name = name;
		this.address = address;
		this.plan = plan;
		this.rent = new ArrayList<String>();
		this.queue = new ArrayList<String>();
	}
	
	/**
	 * getter for customer name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * getter for customer address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * getter for customer plan
	 * @return plan
	 */
	public String getPlan() {
		return plan;
	}

	/**
	 * getter for customer rent list
	 * @return rent
	 */
	public ArrayList<String> getRent() {
		return rent;
	}
	
	/**
	 * getter for the name of the media in the rent list
	 * @param index
	 * @return media name
	 */
	public String getNameInRent(int index) {
		return rent.get(index);
	}
	
	/**
	 * adds the name of a media to the rent list
	 * @param mediaTitle
	 */
	public void AddRent(String mediaTitle) {
		rent.add(mediaTitle);
	}
	
	/**
	 * removes a media from the rent list
	 * @param index
	 */
	public void removeRent(int index) {
		rent.remove(index);
	}
	
	/**
	 * getter for customer queue
	 * @return queue
	 */
	public ArrayList<String> getQueue() {
		return queue;
	}
	
	/**
	 * getter for media name in customer queue
	 * @param index
	 * @return media name
	 */
	public String getNameInQueue(int index) {
		return queue.get(index);
	}
	
	/**
	 * adds media name to customer queue
	 * @param mediaTitle
	 */
	public void addQueue(String mediaTitle) {
		queue.add(mediaTitle);
	}
	
	/**
	 * removes media name from customer queue
	 * @param index
	 */
	public void removeQueue(int index) {
		queue.remove(index);
	}

}
