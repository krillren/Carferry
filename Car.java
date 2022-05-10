package carferry;

/**
 * class permettant la modèlisation d'une voiture, elle hérite de véhicle et ajoute un attribut nbPassenger.
 *
 */
public class Car extends Vehicle {
	/**
	 * nbPassenger représente le nombre de passager(s) dans la voiture, autre que le conducteur.
	 */
	private byte nbPassenger;
	
	/**
	 * constructeur de la class car.
	 * @param registration , plaque d'immatriculation.
	 * @param unloadedWeight , poid à vide.
	 * @param length , longueur de la voiture.
	 * @param driver , conducteur.
	 * @param nbPassenger , nombre de passager(s).
	 */
	public Car(String registration, double unloadedWeight, double length, Driver driver, byte nbPassenger) {
		super(registration, unloadedWeight, length, driver);
		this.nbPassenger = nbPassenger;
	}
	
	/**
	 * @return le nombre de passager(s).
	 */
	public byte getNbPassengerNb() {
		return nbPassenger;
	}

	
	/**
	 *	méthode permettant de différencié une voiture d'un camion.
	 */
	public boolean hasCargo() {
		return false;
	}
}
