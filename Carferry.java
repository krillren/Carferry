package carferry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Carferry {
	private final double MAX_WEIGHT;
	private final int NB_ROWS;
	private List<Row> rows;
	private Set<Ticket> ticketTreeSet;
	
	public Carferry() {
		this.MAX_WEIGHT = 75.0;	
		this.NB_ROWS = 2;
		this.rows = new ArrayList<Row>(NB_ROWS);
		
		for (int i = 0 ; i < NB_ROWS ; i++) {
			this.rows.add(new Row());
		}
		
		this.ticketTreeSet = new TreeSet<Ticket>();
	}
	
	private void generateTicket(Vehicle vehicle, int row, int index) {
		double price = 0.0;
		
        if (vehicle.hasCargo()) {
            price = 45 + 0.1 * ((Truck)vehicle).getCargoWeight();
        } else {
            price = 35 + 3 * ((Car)vehicle).getNbPassengerNb();
        }
        
        if (row == 0) {
            this.ticketTreeSet.add(new Ticket("G" + index, vehicle, price));
        } else {
            this.ticketTreeSet.add(new Ticket("D" + index, vehicle, price));
        }
	}
	
	private boolean deleteTicket(Vehicle vehicle) {
		for (Ticket ticket : this.ticketTreeSet) {
            if(ticket.getVehicle() == vehicle) {
                this.ticketTreeSet.remove(ticket);
                return true;
            }
        }
        return false;
	}
	
	private int rowMinWeight() {
		int rowWithLessWeight = 0;
		int currentRow = 0;
		double lessWeightSeen = this.MAX_WEIGHT;
		
		for (Row row : this.rows) {
			if (row.getTotalWeight() < lessWeightSeen) {
				lessWeightSeen = row.getTotalWeight();
				rowWithLessWeight = currentRow;
			}
			currentRow++;
		}
		
		if (currentRow == 0) {
			return -1;
		}
		
		return rowWithLessWeight;
	}
	
	private int rowMaxWeight() {
		int rowWithMaxWeight = 0;
		int currentRow = 0;
		double maxWeightSeen = 0.0;
		
		for (Row row : this.rows) {
			if (row.getTotalWeight() > maxWeightSeen) {
				maxWeightSeen = row.getTotalWeight();
				rowWithMaxWeight = currentRow;
			}
			currentRow++;
		}
		
		if (currentRow == 0) {
			return -1;
		}
		
		return rowWithMaxWeight;
	}
	
	public boolean addVehicle(Vehicle vehicle) throws BadVehicleAdditionException {
		int rowWithLessWeight = rowMinWeight();
		
		if (rowWithLessWeight == -1) {
			throw new BadVehicleAdditionException("Poids exessif dans la cale");
		}
		
		try {
			if (this.rows.get(rowWithLessWeight).addVehicleRow(vehicle)) {
				this.generateTicket(vehicle, rowWithLessWeight, this.rows.get(rowWithLessWeight).getLastIndex());
				return true;
			}
		} catch (BadVehicleAdditionException e) {
			System.err.println("Erreur, cause d'espace insuffisant dans la cale");
			return false;
		}
		
		return false;
	}
	
	private boolean removeVehicle() {
		int rowWithLessWeight = rowMaxWeight();
		
		if (rowWithLessWeight == -1) {
			return false;
		}
		
		Vehicle removedVehicle = this.rows.get(rowWithLessWeight).removeVehicleRow(); 
		
		if (removedVehicle != null) {
			System.out.println(removedVehicle);
			this.deleteTicket(removedVehicle);
			return true;
		}
		
		return false;
	}
	
	public void emptyHold() {
		while (removeVehicle());
	}
	
	public void printTickets() {
        for(Ticket ticket : this.ticketTreeSet) {
            System.out.print(ticket.toString() + "\n");
        }
    }
	
	public String toString() {
		String retString = "";
		
		retString += "Rangée Gauche :\n" + this.rows.get(0).toString();
		retString += "\nRangée Droite :\n" + this.rows.get(1).toString();
		
		return retString;
	}
}
