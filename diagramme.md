# Analyse Projet POA
## Guillaume RENAUD & Lucien MARTIAL TP2A

# Diagramme de classes

```mermaid
classDiagram
	Vehicle <|-- Car : extends
	Vehicle <|-- Truck : extends

	Comparable <|-- Ticket : implements
			
	class Comparable {
		<<interface>>
		+int compareTo(T o)
	}
			
	class Car {
		-byte nbPassenger
		+byte getNbPassenger()
	}
			
	class Truck {
		-double cargoWeigth
		+double getCargoWeigth()
	}
			
	class Carferry {
		-List<Row> rows;
		-Set<Ticket> ticketTreeSet
		-boolean generateTicket(Vehicle vehicle)
		-boolean deleteTicket(Vehicle vehicle)
		-int rowMinWeight()
		-int rowMaxWeight()
		+boolean addVehicle(Vehicle vehicle)
		+boolean removeVehicle()
		+void emptyHold()
		+Ticket[] getCarsRow(int index)
		+String toString()
	}
			
	class Row {
		-final double LENGTH
		-List<Vehicle> vehicleQueue
		-double totalWeigth
		-double remainingSpace
		+boolean addVehicleRow()
		+boolean removeVehicleRow()
		+double getTotalWeigth()
		+double getRemainingSpace()
		+int getLastIndex()
		+boolean isEmpty()
		+String toString()
	}
			
	class Driver {
		-String firstName
		-String lastName
		-String drivingLicenceNumber
		+String getFirstName()
		+String getLastName()
		+String getDrivingLicenceNumber()
	}
			
	class Ticket {
		-String position
		-Vehicle vehicle
		-double price
		+String getPosition()
		+Vehicle getVehicle()
		+double getPrice()
		+String get_small_info_toString()
		+String toString()
	}

	class Vehicle {
		<<abstract>>
		-String registration
		-double unloadedWeight
		-double length
		-Driver driver
		+String getRegistration()
		+double getUnloadedWeight()
		+double getLength()
		+Driver getDriver()
		+abstract bool hasCargo()
		+String toString()
	}
```
