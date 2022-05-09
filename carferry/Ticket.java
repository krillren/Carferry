package carferry;

import java.util.LinkedList;
import java.util.List;

public class Ticket implements Comparable<Ticket> {
	private String position;
	private Vehicle vehicle;
	private double price;
	
	private List<Ticket> link;
	
	
	public Ticket(String position, Vehicle vehicle, double price) {
		this.position = position;
		this.vehicle = vehicle;
		this.price = price;
		
	}


	public String getPosition() {
		return position;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public double getPrice() {
		return price;
	}
	public String toString() {
		return "";
	}
	public int compareTo(Ticket arg0) {
		if(this.position.charAt(0)>arg0.position.charAt(0)) {
			return -1;
		}
		if(this.position.charAt(0)<arg0.position.charAt(0)) {
			return 1;
		}
		return this.position.substring(1).compareTo(arg0.position.substring(1));
	}
	
}
