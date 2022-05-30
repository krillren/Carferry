package carferry;

/**
 * class abstraite modèlisant les véhicules.
 *
 */
public abstract class Vehicle {
	/**
	 * numéro d'immatriculation.
	 */
	private String registration;
	/**
	 * poids à vide.
	 */
	private double unloadedWeight;
	/**
	 * longueur du véhicule.
	 */
	private double length;
	/**
	 * conducteur.
	 */
	private Driver driver;
	
	/**
	 * constructeur du véhicule.
	 * @param registration , numéro d'immatriculation.
	 * @param unloadedWeight , poids à vide.
	 * @param length , longueur de la voiture.
	 * @param driver , conducteur.
	 */
	public Vehicle(String registration, double unloadedWeight, double length, Driver driver) {
		this.registration = registration;
		this.unloadedWeight = unloadedWeight;
		this.length = length;
		this.driver = driver;
	}

	/**
	 * @return numéro d'immatriculation.
	 */
	public String getRegistration() {
		return registration;
	}

	/**
	 * @return poid à vide.
	 */
	public double getUnloadedWeight() {
		return unloadedWeight;
	}

	/**
	 * @return longueur de la voiture.
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @return conducteur.
	 */
	public Driver getDriver() {
		return driver;
	}
	
	/**
	 *	renvoie une chaîne de caractère contenant le numéro d'immatriculation.
	 */
	public String toString() {
		return this.registration;
	}
	
	/**
	 * @return vrai si le véhicule est un camion faux sinon.
	 */
	public abstract boolean hasCargo();
}
