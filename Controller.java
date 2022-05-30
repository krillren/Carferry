package carferry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * class controller permet de faire l'intermédiaire entre l'application et l'affichage graphique.
 * possède les attributs:
 * -fenetre menu.
 * -fenetre formulaire.
 * -fenetre cale.
 * -carferry.
 */
public class Controller {
	//parti visuelle
	MainWindow menu;
	Fenetre_formulaire formulaire;
	Fenetre_cale_carferry cale;
	
	//parti carferry
	Carferry carferry;
	
	/**
	 * constructeur de la class controller.
	 * @param carferry carferry associé.
	 */
	public Controller( Carferry carferry) {
		
		this.menu = new MainWindow();
		menu.setVisible(true);
		menu.getAcces_cale().addActionListener(new ActionHandler());
		menu.getEmbarquer_boutton().addActionListener(new ActionHandler());
		menu.getDebarquer_boutton().addActionListener(new ActionHandler());

		this.formulaire = new Fenetre_formulaire();
		this.formulaire.getBouton_valider().addActionListener(new ActionHandler());
		this.formulaire.getRb_camion().addActionListener(new ActionHandler());
		this.formulaire.getRb_voiture().addActionListener(new ActionHandler());
		formulaire.setVisible(false);

		this.cale = new Fenetre_cale_carferry(carferry);
		this.cale.getVehicleLeft().addMouseListener(new JlistListener(this.cale.getVehicleLeft(),this.cale.getTicketLeft()));
		this.cale.getVehicleRight().addMouseListener(new JlistListener(this.cale.getVehicleRight(),this.cale.getTicketRight()));
		cale.setVisible(false);
		
		this.carferry = carferry;

	}
	
	public class ActionHandler implements ActionListener{
		
		/**
		 * action qui se déclanche lors d'un appuie de boutton dans les fenêtres.
		 */
		public void actionPerformed(ActionEvent a) {
			Object source = a.getSource();
			if(source == menu.getAcces_cale()){
				System.out.print("salut ");
				cale.setVisible(true);
			}
			if(source == menu.getEmbarquer_boutton()){
				formulaire.reset();
				formulaire.setVisible(true);
			}
			if(source == menu.getDebarquer_boutton()) {
				String removed_vehicle = carferry.removeVehicle();
				if(removed_vehicle!=null) {
					JOptionPane.showMessageDialog(null, "Débarquement réussi "+removed_vehicle,"Embarquement",JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "la cale est vide","Embarquement",JOptionPane.WARNING_MESSAGE);
				}
				cale.dispose();
				cale = new Fenetre_cale_carferry(carferry);
				cale.getVehicleLeft().addMouseListener(new JlistListener(cale.getVehicleLeft(),cale.getTicketLeft()));
				cale.getVehicleRight().addMouseListener(new JlistListener(cale.getVehicleRight(),cale.getTicketRight()));
				cale.setVisible(false);
			}
			if(source == formulaire.getBouton_valider()){
				Vehicle vehicle = traitement_formulaire();
				try {
					carferry.addVehicle(vehicle);
				} catch (BadVehicleAdditionException e) {
					System.err.println("Erreur"+e.getMessage());
					JOptionPane.showMessageDialog(null, "Embarquement impossible: "+e.getMessage(),"Embarquement",JOptionPane.WARNING_MESSAGE);
					return;
				}
				cale.dispose();
				cale = new Fenetre_cale_carferry(carferry);
				cale.getVehicleLeft().addMouseListener(new JlistListener(cale.getVehicleLeft(),cale.getTicketLeft()));
				cale.getVehicleRight().addMouseListener(new JlistListener(cale.getVehicleRight(),cale.getTicketRight()));
				cale.setVisible(false);
				formulaire.dispose();
				JOptionPane.showMessageDialog(null,"Embarquement Réussi","Embarquement",JOptionPane.WARNING_MESSAGE);
			}
			if(source == formulaire.getRb_camion()) {
				formulaire.getTf_nb_passagers().setEnabled(false);
				formulaire.getTf_poids_cargaison().setEnabled(true);
			}
			
			if(source == formulaire.getRb_voiture()) {
				formulaire.getTf_nb_passagers().setEnabled(true);
				formulaire.getTf_poids_cargaison().setEnabled(false);
			}
			
		}
		/**
		 * fonction permettant de traiter le formulaire d'embarquement.
		 * @return null si le formulaire est incorrect , le véhicule à embarquer sinon.
		 */
		private Vehicle traitement_formulaire(){
			String nom_conducteur = formulaire.getTf_nom_conducteur().getText();
			String prenom_conducteur = formulaire.getTf_prenom_conducteur().getText();
			String num_permis = formulaire.getTf_num_permis().getText();
			String immatriculation = formulaire.getTf_immatriculation().getText();
			double longueur;
			double poids;
			byte nbPassengers;
			double poids_cargaison;
			try{
				longueur = Double.parseDouble(formulaire.getTf_longueur().getText());
				poids = Double.parseDouble(formulaire.getTf_poids().getText()); 

			}catch(NumberFormatException e){
				return null;
			}
			

			//check conducteur info
			if(nom_conducteur.length()==0 || prenom_conducteur.length()==0 || num_permis.length()==0){
				return null;
			}

			//check vehicule info
			if(immatriculation=="" || immatriculation.length()>20|| longueur==0 || poids==0){
				return null;
			}

			//check vehicule type
			if(formulaire.getRb_voiture().isSelected()){

				try {
					nbPassengers = Byte.parseByte(formulaire.getTf_nb_passagers().getText());
				}catch(NumberFormatException e) {
					return null;
				}

				return new Car( immatriculation, poids, longueur, new Driver(prenom_conducteur,nom_conducteur,num_permis), nbPassengers);
			}
			if(formulaire.getRb_camion().isSelected()){
				try {
					poids_cargaison = Byte.parseByte(formulaire.getTf_poids_cargaison().getText());
				}catch(NumberFormatException e) {
					return null;
				}
				return new Truck( immatriculation, poids, longueur, new Driver(prenom_conducteur,nom_conducteur,num_permis), poids_cargaison);
			}
			return null;


		}
		
			
	}
	/**
	 * class JlistListener permet de s'occuper des intéractions avec la JList dans la fenêtre cale.
	 * lors d'un click sur un élément de la jList, on affiche une nouvelle fenêtre d'information.
	 */
	public class JlistListener implements MouseListener{
		JList list;
		Ticket[] entireTicket;
		public JlistListener(JList list, Ticket[] entireTicket) {
			super();
			this.list = list;
			this.entireTicket = entireTicket; 
		}
		/**
		 * action qui se déclanche lors d'un clique de souris.
		 * permet de d'afficher les informations détaillé d'un ticket lors d'un click sur l'élement de la JList corespondant.
		 */
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(null,entireTicket[list.getSelectedIndex()].toString(),"TICKET",JOptionPane.INFORMATION_MESSAGE);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
