package carferry;

public class Ticket implements Comparable<Ticket> {
	private String position;
	private Vehicle vehicle;
	private double price;
	
	public Ticket(String position, Vehicle vehicle, double price) {
		this.position = position;
		this.vehicle = vehicle;
		this.price = price;
	}

	public String getPositionString() {
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

	@Override
	public int compareTo(Ticket ticket) {
		return 0;
	}
}
