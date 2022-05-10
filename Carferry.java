package carferry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Carferry {
	private final double MAX_WEIGHT;
	private final int NB_ROWS;
	private List<Row> rows; //replace by an list implemented by an array list in the constructor
	private Set<Ticket> ticketTreeSet;
	
	public Carferry() {
		this.MAX_WEIGHT = 7.5;
		this.NB_ROWS = 2;
		this.rows = new ArrayList<Row>();
		
		for (int i = 0 ; i < NB_ROWS ; i++) {
			this.rows.add(new Row());
		}
		
		this.ticketTreeSet = new TreeSet<Ticket>();
	}
	
	private boolean generateTicket(Vehicle vehicle) {
		return false;
	}
	
	public boolean addVehicle(Vehicle vehicle) {
		if(this.rows.get(0).getRemainingSpace()>=this.rows.get(1).getRemainingSpace()) {
			return this.rows.get(0).addVehicleRow(vehicle);
		}
		return this.rows.get(1).addVehicleRow(vehicle);
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
