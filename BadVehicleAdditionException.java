package carferry;

public class BadVehicleAdditionException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public BadVehicleAdditionException() {
		super();
	}
	
	public BadVehicleAdditionException(String message) {
		super(message);
	}

}
