package carferry;

public class Driver {
	private String firstName;
	private String lastName;
	private String drivingLicenceNumber;
	
	public Driver(String firstName, String lastName, String drivingLicenceNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.drivingLicenceNumber = drivingLicenceNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getDrivingLicenceNumber() {
		return drivingLicenceNumber;
	}

	
	
}
