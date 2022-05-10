package carferry;

public abstract class Vehicle {
	private String registration;
	private double unloadedWeight;
	private double length;
	private Driver driver;
	
	public Vehicle(String registration, double unloadedWeight, double length, Driver driver) {
		this.registration = registration;
		this.unloadedWeight = unloadedWeight;
		this.length = length;
		this.driver = driver;
	}

	public String getRegistration() {
		return registration;
	}

	public double getUnloadedWeight() {
		return unloadedWeight;
	}

	public double getLength() {
		return length;
	}

	public Driver getDriver() {
		return driver;
	}
	
	public abstract boolean hasCargo();
}
