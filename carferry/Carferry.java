package carferry;

import java.util.Set;
import java.util.TreeSet;

public class Carferry {
	private final double MAX_WEIGHT;
	private final int NB_ROWS;
	private Row[] rows; //replace by an list implemented by an array list in the constructor
	private Set<Ticket> ticketTreeSet;
	
	public Carferry() {
		this.MAX_WEIGHT = 7.5;
		this.NB_ROWS = 2;
		this.rows = new Row[NB_ROWS];
		
		for (int i = 0 ; i < NB_ROWS ; i++) {
			this.rows[i] = new Row();
		}
		
		this.ticketTreeSet = new TreeSet<Ticket>();
	}
	
	private boolean generateTicket(Vehicle vehicle) {
		return false;
	}
	
	public boolean addVehicle(Vehicle vehicle) {
		return false;
	}
	
	public boolean removeLastVehicle(Vehicle vehicle) {
		return false;
	}
	
	public boolean emptyHold() {
		return false;
	}
	
	public String toString() {
		return "";
	}
}
