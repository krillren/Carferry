package carferry;

/**
 * class modèlisant les tickets genéré dans le carferry.
 *
 */
public class Ticket implements Comparable<Ticket> {
	/**
	 * position dans la cale du véhicule.
	 */
	private String position;
	/**
	 * véhicule associé au ticket.
	 */
	private Vehicle vehicle;
	/**
	 * prix de la traversé.
	 */
	private double price;
	
	/**
	 * constructeur de ticket.
	 * @param position , position dans la cale du véhicule.
	 * @param vehicle , véhicule associé au ticket.
	 * @param price , prix de la traversé.
	 */
	public Ticket(String position, Vehicle vehicle, double price) {
		this.position = position;
		this.vehicle = vehicle;
		this.price = price;
	}

	/**
	 * @return position dans la cale du véhicule.
	 */
	public String getPositionString() {
		return position;
	}

	/**
	 * @return véhicule associé au ticket.
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @return prix de la traversé.
	 */
	public double getPrice() {
		return price;
	}
	
		
	/**
	 *	renvoi une chaîne de caractère contenant la position, le nom/prénom du conducteur, le numéro d'immatriculation et le prix de la traversé.
	 */
	public String toString() {
        return "[ " + this.position + " " +
        		this.vehicle.getDriver().getFirtName() + " " +
                this.vehicle.getDriver().getLastName() +
                " : " + this.vehicle.getRegistration() + " : " +
                this.price + " euros ]";
    }

	
	/**
	 *	outil de comparaison des ticket (ordre lexicographique des nom de famille / prénom.
	 */
	public int compareTo(Ticket ticket) {
        String ret1 = this.vehicle.getDriver().getLastName().concat(this.vehicle.getDriver().getFirtName());
        String ret2 = ticket.vehicle.getDriver().getLastName().concat(ticket.vehicle.getDriver().getFirtName());
        return ret1.compareTo(ret2);
    }
}
