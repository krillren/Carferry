package carferry;

import java.util.Deque;
import java.util.LinkedList;

/**
 * class permettant de modèliser une rangé de la cale du carferry.
 *
 */
public class Row {
	/**
	 * représente la longueur total de la rangé.
	 */
	private final double LENGTH;
	/**
	 * représente la queue de véhicule présent dans la rangé.
	 */
	private Deque<Vehicle> vehicleQueue;
	/**
	 * représente le poid total de tout les véhicule présent dans la rangé.
	 */
	private double totalWeight;
	/**
	 * reprèsente l'espace restant dans la rangé.
	 */
	private double remainingSpace;
	/**
	 * représente l'indice de position de la prochaine place à allouer.
	 */
	private int lastIndex;
	
	/**
	 * constructeur par défaut de Row respectant les dimensions donné dans l'énoncé.
	 */
	public Row() {
		this.LENGTH = 25.0;
		this.vehicleQueue = new LinkedList<Vehicle>();
		this.totalWeight = 0.0;
		this.remainingSpace = this.LENGTH;
		this.lastIndex = 0;
	}
	
	/**
	 * fonction permettant l'ajout d'un véhicule dans la rangé.
	 * @param vehicle , véhicule ajouté.
	 * @return vrai si l'ajout est un succès faux sinon.
	 * @throws BadVehicleAdditionException , si la longueur ne le permet pas.
	 */
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
	
	/**
	 * fonction permettant de retirer un véhicule de la rangé.
	 * @return  vrai si le retrait est un succès faux sinon.
	 */
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
	
	/**
	 * @return le poid total.
	 */
	public double getTotalWeight() {
		return this.totalWeight;
	}
	
	/**
	 * @return l'espace restant.
	 */
	public double getRemainingSpace() {
		return this.remainingSpace;
	}
	
	/**
	 * @return  l'indice de position de la prochaine place à allouer.
	 */
	public int getLastIndex() {
        return this.lastIndex;
    }
	
	/**
	 * @return vrai si la rangé est vide faux sinon.
	 */
	public boolean isEmpty() {
		return this.vehicleQueue.isEmpty();
	}
	
	/**
	 *	renvoi une chaîne de caractère représentant les véhicules présent dans la rangé.
	 */
	public String toString() {
		String retString = "";
		
		for (Vehicle vehicle : vehicleQueue) {
			retString += vehicle.toString() + "\n";
		}
		
		return retString;
	}
}
