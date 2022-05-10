package carferry;

public class Car extends Vehicle {
	private byte nbPassenger;
	
	public Car(String registration, double unloadedWeight, double length, Driver driver, byte nbPassenger) {
		super(registration, unloadedWeight, length, driver);
		this.nbPassenger = nbPassenger;
	}

	public byte getNbPassengerNb() {
		return nbPassenger;
	}

	@Override
	public boolean hasCargo() {
		return false;
	}
}
