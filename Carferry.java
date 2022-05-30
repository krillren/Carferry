package carferry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * class représentant le carferry et modèlisant les actions possible de ce dernier (charger et décharger des véhicules.
 *
 */
public class Carferry {
	/**
	 * MAX_WEIGHT représente le poid total supporté par le carferry.
	 */
	private final double MAX_WEIGHT;
	/**
	 * NB_ROWS représente le nombre de rangé disponible dans la cale de carferry.
	 */
	private final int NB_ROWS;
	/**
	 * rows est une liste de Row permettant de modéliser les rangé dans la cale.
	 */
	private List<Row> rows;
	/**
	 * ticketTreeSet est un treeSet de Ticket permettant de modélisé la liste de tickets genéré sur le carferry.
	 */
	private Set<Ticket> ticketTreeSet;
	
	/**
	 * constructeur du Carferry respectant les dimensions donné dans l'énoncé.
	 */
	public Carferry() {
		this.MAX_WEIGHT = 75.0;	
		this.NB_ROWS = 2;
		this.rows = new ArrayList<Row>(NB_ROWS);
		
		for (int i = 0 ; i < NB_ROWS ; i++) {
			this.rows.add(new Row());
		}
		
		this.ticketTreeSet = new TreeSet<Ticket>();
	}
	
	/**
	 * fonction permettant de genérer un ticket.
	 * @param vehicle , vehicule associé au ticket.
	 * @param row , rangé dans laquelle est placé le véhicule.
	 * @param index , emplacement de la voiture dans la rangé.
	 */
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
	
	/**
	 * fonction permettant la suprréssion d'un ticket.
	 * @param vehicle , véhicule associé au ticket.
	 * @return vrai si le ticket est enlevé non sinon.
	 */
	private boolean deleteTicket(Vehicle vehicle) {
		for (Ticket ticket : this.ticketTreeSet) {
            if(ticket.getVehicle() == vehicle) {
                this.ticketTreeSet.remove(ticket);
                return true;
            }
        }
        return false;
	}
	
	/**
	 * fonction permettant de renvoyer la rangé la moins chargé de la cale.
	 * @return indice de la rangé dans le arraylist de row.
	 */
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
	
	/**
	 * fonction permettant de renvoyé la rangé la plus chargé.
	 * @return indice de la rangé dans le arraylist de row.
	 */
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
	
	/**
	 * fonction permettant d'insérer un véhicule dans la cale et génère un ticket en respectant les contrainte d'embarquement.
	 * @param vehicle , véhicule inséré.
	 * @return	vrai si l'embarquement est un succès faux sinon.
	 * @throws BadVehicleAdditionException si le poids est exessif.
	 */
	public boolean addVehicle(Vehicle vehicle) throws BadVehicleAdditionException {
		int rowWithLessWeight = rowMinWeight();
		
		if (rowWithLessWeight == -1) {
			throw new BadVehicleAdditionException("Poids exessif dans la cale");
		}
		
		try {
			this.rows.get(rowWithLessWeight).addVehicleRow(vehicle);
		} catch (BadVehicleAdditionException e) {
			throw new BadVehicleAdditionException("Erreur : "+e.getMessage());
		}
		
		this.generateTicket(vehicle, rowWithLessWeight, this.rows.get(rowWithLessWeight).getLastIndex());
		return true;
	}
	
	/**
	 * fonction permettant de retirer un véhicule de la cale.
	 * @return vrai si l'opération est un succès faux sinon.
	 */
	public String removeVehicle() {
		int rowWithLessWeight = rowMaxWeight();
		
		if (rowWithLessWeight == -1) {
			return null;
		}
		
		Vehicle removedVehicle = this.rows.get(rowWithLessWeight).removeVehicleRow(); 
		
		if (removedVehicle != null) {
			System.out.println(removedVehicle);
			this.deleteTicket(removedVehicle);
			return removedVehicle.getRegistration();
		}
		
		return null;
	}
	
	/**
	 * fonction permettant de vider entièrement la cale.
	 */
	public void emptyHold() {
		while (removeVehicle()!=null);
	}
	
	/**
	 * fonction permettant d'afficher sur la console l'ensemble des tickets.
	 */
	public void printTickets() {
        for(Ticket ticket : this.ticketTreeSet) {
            System.out.print(ticket.toString() + "\n");
        }
    }
	
	/**
	 *	renvoi une chaine de caractère représentant le contenue des deux rangés.
	 */
	public String toString() {
		String retString = "";
		
		retString += "Rangée Gauche :\n" + this.rows.get(0).toString();
		retString += "\nRangée Droite :\n" + this.rows.get(1).toString();
		
		return retString;
	}

	public Ticket[] getCarsRow(int index) {
		List<Ticket> result = new ArrayList<Ticket>();
		switch(index) {
			case 0:
				for(Ticket t : ticketTreeSet) {
					if(t.getPositionString().charAt(0) == 'G') {
						result.add(t);
					}
				}
			break;
			
			case 1:
				for(Ticket t : ticketTreeSet) {
					if(t.getPositionString().charAt(0) == 'D') {
						result.add(t);
					}
				}
			break;
			
			default:
			break;
		}
		result.sort(null);
		return result.toArray(new Ticket[0]);
	}
}
