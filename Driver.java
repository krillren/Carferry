package carferry;

public class Driver {
	public String firtName;
	public String lastName;
	public String drivingLicenceNumber;
	
	public Driver(String firstName, String lastName, String drivingLicenceNumber) {
		this.firtName = firstName;
		this.lastName = lastName;
		this.drivingLicenceNumber = drivingLicenceNumber;
	}

	public String getFirtName() {
		return firtName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDrivingLicenceNumber() {
		return drivingLicenceNumber;
	}
}
