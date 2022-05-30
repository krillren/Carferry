package carferry;

public class Main {
	public static void main(String[] args) {
		Carferry carferry = new Carferry();
		
		
		Car v1 = new Car("RM 1054 FF",1.2,4.2,new Driver("Martin","Jeanne","22FF"),(byte) 2);
	    Car v2 = new Car("PO 377 AA",1.4,4.5,new Driver("Dupont","Vincent","A55"),(byte) 1);
	    Car v3 = new Car("WX 456 RT",1.2,5.3,new Driver("Durand","Marie","B34"),(byte) 2);
	    Truck c1 = new Truck("AZ 678 DF",4.0,12,new Driver("Grant","Philip","20FF"),15.0);
	    Truck c2 = new Truck("QS 543 HJ",5.2,13.5,new Driver("Scott","Simon","B55JG"),22.5);
	    Truck c3 = new Truck("BN 321 XC",4.5,15,new Driver("Lambert","Alain","C44Djk"),15.0);
	    
	    
	    try {
		    carferry.addVehicle(c1);
		    carferry.addVehicle(v1);
		    carferry.addVehicle(v2);
		    carferry.addVehicle(c2);
		    carferry.addVehicle(v3);
		    carferry.addVehicle(c3);
	    } catch (BadVehicleAdditionException e) {
	    	System.err.println("Erreur, cause d'espace insuffisant dans la cale");
	    }
		Controller controller = new Controller(carferry);
		
		/*
		
	    
	    
	    System.out.println(carferry);
	    carferry.printTickets();
	    
	    
	    
	    
	    System.out.println("\nDébarquement :");
	    
	    carferry.emptyHold();
	    */
	    
	}
}
