package carferry;

/**
 * classe permettant de gérer les exceptions lié à l'embarquement des véhicules dans le carferry.
 *
 */
public class BadVehicleAdditionException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * constructeur par défaut.
	 */
	public BadVehicleAdditionException() {
		super();
	}
	
	/**
	 * constructeur plus spécifique permettant de transmettre un message.
	 * @param message lié à l'exception
	 */
	public BadVehicleAdditionException(String message) {
		super(message);
	}

}
