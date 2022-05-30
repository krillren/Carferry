package carferry;

import java.awt.Color;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataListener;

/**
 * class Fenetre_cale_carferry permet d'afficher le contenu de la cale du carferry à l'utilisateur.
 */
public class Fenetre_cale_carferry extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 720;
	private static final int HEIGHT = WIDTH / 16 * 9;
	private JList<String> vehicleLeft;
	private JList<String> vehicleRight;
	JPanel pannel1;
	JPanel pannel2;
	private DefaultListModel<String> listModelLeft;
	private DefaultListModel<String> listModelRight;
	
	Ticket [] full_ticket_left;
	Ticket [] full_ticket_right;
	 
	
	/**
	 * constructeur de la fenêtre cale du carferry, permettant d'afficher le contenu de la cale du carferry à l'utilisateur
	 * l'utilisateur à la possibilité de cliquez sur une voiture afin d'afficher des informations supplémentaire tel que 
	 * la position de la voiture, le nom et prénom du conducteur, le prix du billet.
	 * @param carferry le carferry associé.
	 */
	public Fenetre_cale_carferry(Carferry carferry) {
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Container container = this.getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
		full_ticket_left = carferry.getCarsRow(0);
		full_ticket_right = carferry.getCarsRow(1);
		
		
		listModelLeft = new DefaultListModel<>();
		vehicleLeft = new JList<>( listModelLeft );
		for ( int i = 0; i < full_ticket_left.length; i++ ){
			listModelLeft.addElement(full_ticket_left[i].get_small_info_toString() );
		}
		
		listModelRight = new DefaultListModel<>();
		vehicleRight = new JList<>( listModelRight );
		for ( int i = 0; i < full_ticket_right.length; i++ ){
			listModelRight.addElement( full_ticket_right[i].get_small_info_toString() );
		}
		
		

		
		pannel1 = new JPanel();
		pannel1.setBackground(Color.white);
		pannel1.setBorder(new TitledBorder("Rangée gauche"));
		pannel1.add(vehicleLeft);
		container.add(pannel1);
		
		pannel2 = new JPanel();
		pannel2.setBackground(Color.white);
		pannel2.setBorder(new TitledBorder("Rangée droite"));
		pannel2.add(vehicleRight);
		container.add(pannel2);
		
		
		
		
		this.setVisible(true);
	}
	
	/**
	 * getter pour la jlist des véhicules de la rangée gauche.
	 * @return la jlist des véhicules de la rangée gauche.
	 */
	public JList getVehicleLeft() {
		return vehicleLeft;
	}
	/**
	 * getter pour la jlist des véhicules de la rangée droite.
	 * @return la jlist des véhicules de la rangée droite.
	 */
	JList getVehicleRight() {
		return vehicleRight;
	}
	/**
	 * getter pour la liste des tickets associé au véhicules de la rangée gauche.
	 * @return la liste des tickets associé au véhicules de la rangée gauche.
	 */
	public Ticket[] getTicketLeft() {
		return full_ticket_left;
	}
	
	/**
	 * getter pour la liste des tickets associé au véhicules de la rangée droite.
	 * @return la liste des tickets associé au véhicules de la rangée droite.
	 */
	public Ticket[] getTicketRight() {
		return full_ticket_right;
	}
	
}
