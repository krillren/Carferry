package carferry;

public class Truck extends Vehicle {
	private double cargoWeight;
	
	public Truck(String registration, 
			double unloadedWeight, 
			double length, 
			Driver driver,
			double cargoWeight) {
		
		super(registration, unloadedWeight, length, driver);
		this.cargoWeight=cargoWeight;
	}
	public double getCargoWeight() {
		return cargoWeight;
	}
	public boolean hasCargo() {
		return cargoWeight>0;
	}

}
