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
	
	public boolean addVehicleRow(Vehicle vehicle) {
		if(vehicle.getLength()+50>this.remainingSpace) {
			return false;
		}
		this.vehicleQueue.addFirst(vehicle);
		remainingSpace-=vehicle.getLength()+50;
		return true;
	}
	
	public boolean removeVehicleRow() {
		if(this.vehicleQueue.isEmpty()) {
			return false;
		}
		remainingSpace+=this.vehicleQueue.removeFirst().getLength()+50;
		return true;
	}
	
	public double getTotalWeight() {
		return this.totalWeight;
	}
	
	public double getRemainingSpace() {
		return this.remainingSpace;
	}
	public Deque<Vehicle> getVehicleQueue(){
		return this.vehicleQueue;
	}
}
