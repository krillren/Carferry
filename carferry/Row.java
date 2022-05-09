package carferry;

import java.util.Deque;
import java.util.LinkedList;

public class Row {
	private final double LENGTH;
	private Deque<Vehicle> vehicleQueue;
	private double totalWeight;
	private double remainingSpace;
	
	public Row() {
		this.LENGTH = 25.0;
		this.vehicleQueue = new LinkedList<Vehicle>();
		this.totalWeight = 0.0;
		this.remainingSpace = this.LENGTH;
	}
	
	public boolean addVehicleRow() {
		return false;
	}
	
	public boolean removeVehicleRow() {
		return false;
	}
	
	public double getTotalWeight() {
		return this.totalWeight;
	}
	
	public double getRemainingSpace() {
		return this.remainingSpace;
	}
}
