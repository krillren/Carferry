package carferry;

import javax.swing.*;
import java.awt.*;

/**
 * class MainWindow permet d'afficher une fenêtre ouvrant la possibilité à l'utilisateur de soit:
 * -afficher la cale (ouvre la fenêtre Fenetre_cale_carferry).
 * -embarquer un véhicule (ouvre la fenêtre Fenetre_formulaire).
 * -débarquer un véhicule (ouvre un message d'information indiquant si le débarquement à réussi ou non).
 */
public class MainWindow extends JFrame {
    private int WIDTH = 720;
    private int HEIGHT = WIDTH / 16 * 9;
    
    //menu
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem acces_cale;
    
    private JPanel P1;
    private JPanel P2;
    private JLabel P1_label;
    private JButton embarquer_boutton;
    private JButton debarquer_boutton;
    /**
     * constructeur de la class Main window.
     */
    public MainWindow() {
    	super("CAR FERRY");
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        
        //création du menu
        menuBar = new JMenuBar();
        menu = new JMenu("carferry");
        acces_cale = new JMenuItem("Afficher cale");
        menu.add(acces_cale);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        //création indication bouttons
        P1 = new JPanel();
        P1.setLayout(new FlowLayout());
        P2 = new JPanel();
        P2.setLayout(new FlowLayout());
        P1_label  = new JLabel("nouvelle croisière");
        embarquer_boutton = new JButton("Embarquer");
        debarquer_boutton = new JButton("Débarquer");

        P1.add(P1_label);
        P2.add(embarquer_boutton);
        P2.add(debarquer_boutton);

        container.add(P1,BorderLayout.NORTH);
        container.add(P2,BorderLayout.CENTER);
        
        
    }
    /**
	 * @return le menu de la fenetre.
	 */
	public JMenuItem getAcces_cale() {
		return acces_cale;
	}
	/**
	 * @return le bouton donnant accès au formulaire d'embarquement.
	 */
	public JButton getEmbarquer_boutton() {
		return embarquer_boutton;
	}
	/**
	 * @return le bouton permettant le débarquement d'un véhicule.
	 */
	public JButton getDebarquer_boutton() {
		return debarquer_boutton;
	}    
}
