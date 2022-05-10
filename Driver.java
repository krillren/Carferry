package carferry;

/**
 * class permettant la modèlisation du conducteur.
 *
 */
public class Driver {
	/**
	 * prénom du conducteur.
	 */
	public String firtName;
	/**
	 * nom du conducteur.
	 */
	public String lastName;
	/**
	 * numéro de permis de conduire du conducteur.
	 */
	public String drivingLicenceNumber;
	
	/**
	 * constructeur de conducteur.
	 * @param firstName , prénom.
	 * @param lastName , nom.
	 * @param drivingLicenceNumber , numéro de permis de conduire.
	 */
	public Driver(String firstName, String lastName, String drivingLicenceNumber) {
		this.firtName = firstName;
		this.lastName = lastName;
		this.drivingLicenceNumber = drivingLicenceNumber;
	}

	/**
	 * @return prénom du conducteur.
	 */
	public String getFirtName() {
		return firtName;
	}

	/**
	 * @return nom du conducteur.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return numéro de permis de conduire du conducteur.
	 */
	public String getDrivingLicenceNumber() {
		return drivingLicenceNumber;
	}
}
