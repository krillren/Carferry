package carferry;

/**
 * class modèlisant un camion, elle hérite de véhicule et ajoute un attribut cargoWeight.
 *
 */
public class Truck extends Vehicle {
	/**
	 * poid de la cargaison.
	 */
	private double cargoWeight;
	
	/**
	 * constructeur de camion.
	 * @param registration , plaque d'immatriculation.
	 * @param unloadedWeight , poid à vide.
	 * @param length , longueur de la voiture.
	 * @param driver , conducteur.
	 * @param cargoWeight , poid de la cargaison.
	 */
	public Truck(String registration, double unloadedWeight, double length, Driver driver, double cargoWeight) {
		super(registration, unloadedWeight, length, driver);
		this.cargoWeight = cargoWeight;
	}

	/**
	 * @return poid de la cargaison.
	 */
	public double getCargoWeight() {
		return cargoWeight;
	}

	
	/**
	 * méthode permettant de différencié une voiture d'un camion.
	 */
	public boolean hasCargo() {
		return true;
	}
}
