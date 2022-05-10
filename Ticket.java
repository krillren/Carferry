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
        return "[ " + this.position + " " +
        		this.vehicle.getDriver().getFirtName() + " " +
                this.vehicle.getDriver().getLastName() +
                " : " + this.vehicle.getRegistration() + " : " +
                this.price + " euros ]";
    }

	@Override
	public int compareTo(Ticket ticket) {
        String ret1 = this.vehicle.getDriver().getLastName().concat(this.vehicle.getDriver().getFirtName());
        String ret2 = ticket.vehicle.getDriver().getLastName().concat(ticket.vehicle.getDriver().getFirtName());
        return ret1.compareTo(ret2);
    }
}
