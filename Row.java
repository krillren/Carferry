package carferry;

import java.util.Deque;
import java.util.LinkedList;

public class Row {
	private final double LENGTH;
	private Deque<Vehicle> vehicleQueue;
	private double totalWeight;
	private double remainingSpace;
	private int lastIndex;
	
	public Row() {
		this.LENGTH = 25.0;
		this.vehicleQueue = new LinkedList<Vehicle>();
		this.totalWeight = 0.0;
		this.remainingSpace = this.LENGTH;
		this.lastIndex = 0;
	}
	
	public boolean addVehicleRow(Vehicle vehicle) throws BadVehicleAdditionException {
		if (vehicle.getLength() + 0.5 > this.remainingSpace) {
			throw new BadVehicleAdditionException("Taille insuffisante dans la cale");
		}
		
		this.vehicleQueue.addFirst(vehicle);
		this.remainingSpace -= vehicle.getLength() + 0.5;
		this.totalWeight += vehicle.getUnloadedWeight();
		
		if (vehicle.hasCargo()) {
			Truck truck = (Truck)(vehicle);
			this.totalWeight += truck.getCargoWeight();
		}
		
		return true;
	}
	
	public Vehicle removeVehicleRow() {
		if (this.vehicleQueue.isEmpty()) {
			return null;
		}
		
		Vehicle vehicle = this.vehicleQueue.removeLast();
		this.remainingSpace += vehicle.getLength() + 0.5;
		this.totalWeight -= vehicle.getUnloadedWeight();
		
		if (vehicle.hasCargo()) {
			Truck truck = (Truck)(vehicle);
			this.totalWeight -= truck.getCargoWeight();
		}
		
		return vehicle;
	}
	
	public double getTotalWeight() {
		return this.totalWeight;
	}
	
	public double getRemainingSpace() {
		return this.remainingSpace;
	}
	
	public int getLastIndex() {
        return this.lastIndex;
    }
	
	public boolean isEmpty() {
		return this.vehicleQueue.isEmpty();
	}
	
	public String toString() {
		String retString = "";
		
		for (Vehicle vehicle : vehicleQueue) {
			retString += vehicle.toString() + "\n";
		}
		
		return retString;
	}
}
