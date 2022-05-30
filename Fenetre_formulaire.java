package carferry;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * la class Fenetre_formulaire permet de mettre à disposition de l'utilisateur un formulaire à remplir
 * concernant les informations du véhicules à embarquer.
 * les informations sont les suivantes:
 * -le numéro d'immatriculation.
 * -le nombre de passager (pour les voitures uniquement).
 * -le poids.
 * -la longueur.
 * -le poids de la cargaison (pour les camion uniquement).
 * -les informations du conducteur:
 * 		-le nom du conducteur.
 * 		-le prénom du conducteur.
 * 		-le numéro de permis.
 */
public class Fenetre_formulaire extends JFrame {
	private JPanel P1;
	private JPanel P2;
	private JPanel P3;
	private Container container;
	
	private JLabel label_voiture_camion;
	private JRadioButton rb_voiture;
	private JRadioButton rb_camion;

	//sous panel immatriculation
	private JPanel P2_1 ;
	private JLabel label_immatriculation;
	private JTextField tf_immatriculation;

	//sous panel nombre passager
	private JPanel P2_2 ;
	private JLabel label_nb_passagers;
	private JTextField tf_nb_passagers;

	//sous panel poids
	private JPanel P2_3 ;
	private JLabel label_poids;
	private JTextField tf_poids;

	//sous panel longueur
	private JPanel P2_4 ;
	private JLabel label_longueur;
	private JTextField tf_longueur;

	//sous panel poids cargaison camion
	private JPanel P2_5 ;
	private JLabel label_poids_cargaison;
	private JTextField tf_poids_cargaison;

	//sous panel nom conducteur
	private JPanel P2_6 ;
	private JLabel label_nom_conducteur;
	private JTextField tf_nom_conducteur;

	//sous panel prenom conducteur
	private JPanel P2_7 ;
	private JLabel label_prenom_conducteur;
	private JTextField tf_prenom_conducteur;

	//sous panel numero permis
	private JPanel P2_8 ;
	private JLabel label_num_permis;
	private JTextField tf_num_permis;

	//sous panel bouton valider
	private JButton bouton_valider;
	


	/**
	 * constructeur permettant de créer la fenêtre du formulaire.
	 */
	public Fenetre_formulaire() {
		super("formulaire");
		setSize(720, 720/12*9);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		container = this.getContentPane();
		container.setLayout(new BorderLayout());
		
		//création Panel 1: -----------------------------------------------------
		P1 = new JPanel();
		P1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		P1.setBackground(Color.red);
		
		//label
		label_voiture_camion = new JLabel("quel est le type du véhicule ?");
		
		//radio type button
		rb_voiture = new JRadioButton("Voiture");
		rb_camion = new JRadioButton("Camion");
		
		//add radio button to same button group
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb_voiture);
		bg.add(rb_camion);
		
		P1.add(label_voiture_camion);
		P1.add(rb_voiture);
		P1.add(rb_camion);
		
		container.add(P1,BorderLayout.NORTH);
		//-------------------------------------------------------------------------
		
		//création Panel 2:---------------------------------------------------------
		P2 = new JPanel();
		P2.setLayout( new BoxLayout( P2, BoxLayout.Y_AXIS ) );
		
		//plaque immatriculation:___________________________________
		//création souspanel
		P2_1 = new JPanel();
		P2_1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		P2_1.setBackground(Color.green);
		//creation JLabel
		label_immatriculation = new JLabel("entrez immatriculation du véhicule");
		//création JTextField 
		tf_immatriculation = new JTextField(20);
		P2_1.add(label_immatriculation);
		P2_1.add(tf_immatriculation);
		P2.add(P2_1);
		//___________________________________________________________

		//nombre de passagers:_______________________________________
		//création souspanel
		P2_2 = new JPanel();
		P2_2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		P2_2.setBackground(Color.green);
		//creation JLabel
		label_nb_passagers = new JLabel("entrez nombre de passagers");
		//creation JTextField
		tf_nb_passagers = new JTextField(2);
		P2_2.add(label_nb_passagers);
		P2_2.add(tf_nb_passagers);
		P2.add(P2_2);
		//___________________________________________________________
		//Poids du véhicule(en tonnes):______________________________
		//création souspanel
		P2_3 = new JPanel();
		P2_3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		P2_3.setBackground(Color.green);
		//creation JLabel
		label_poids = new JLabel("entrez poids du véhicule (en tonnes)");
		//creation JTextField
		tf_poids = new JTextField(5);
		P2_3.add(label_poids);
		P2_3.add(tf_poids);
		P2.add(P2_3);
		//___________________________________________________________

		//Longueur du véhicule(en mètres):______________________________
		//création souspanel
		P2_4 = new JPanel();
		P2_4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		P2_4.setBackground(Color.green);
		//creation JLabel
		label_longueur = new JLabel("entrez longueur du véhicule (en mètres)");
		//creation JTextField
		tf_longueur = new JTextField(2);
		P2_4.add(label_longueur);
		P2_4.add(tf_longueur);
		P2.add(P2_4);
		//___________________________________________________________

		//Poids de la cargaison du camion(en tonnes):_____________________
		//création souspanel
		P2_5 = new JPanel();
		P2_5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		P2_5.setBackground(Color.green);
		//creation JLabel
		label_poids_cargaison = new JLabel("entrez poids de la cargaison du camion (en tonnes)");
		//creation JTextField
		tf_poids_cargaison = new JTextField(5);
		P2_5.add(label_poids_cargaison);
		P2_5.add(tf_poids_cargaison);
		P2.add(P2_5);
		//___________________________________________________________
		
		//nom du conducteur:___________________________________________
		//création souspanel
		P2_6 = new JPanel();
		P2_6.setLayout(new FlowLayout(FlowLayout.RIGHT));
		P2_6.setBackground(Color.green);
		//creation JLabel
		label_nom_conducteur = new JLabel("entrez nom du conducteur");
		//creation JTextField
		tf_nom_conducteur = new JTextField(20);
		P2_6.add(label_nom_conducteur);
		P2_6.add(tf_nom_conducteur);
		P2.add(P2_6);
		//___________________________________________________________
		
		//prénom du conducteur:___________________________________________
		//création souspanel
		P2_7 = new JPanel();
		P2_7.setLayout(new FlowLayout(FlowLayout.RIGHT));
		P2_7.setBackground(Color.green);
		//creation JLabel
		label_prenom_conducteur = new JLabel("entrez prénom du conducteur");
		//creation JTextField
		tf_prenom_conducteur = new JTextField(20);
		P2_7.add(label_prenom_conducteur);
		P2_7.add(tf_prenom_conducteur);
		P2.add(P2_7);
		//___________________________________________________________

       	//numéro de permis du conducteur:___________________________________________
		//création souspanel
		P2_8 = new JPanel();
		P2_8.setLayout(new FlowLayout(FlowLayout.RIGHT));
		P2_8.setBackground(Color.green);
		//creation JLabel
		label_num_permis = new JLabel("entrez numéro de permis du conducteur");
		//creation JTextField
		tf_num_permis = new JTextField(20);
		P2_8.add(label_num_permis);
		P2_8.add(tf_num_permis);
		P2.add(P2_8);
		//___________________________________________________________

		
		
		
		
		container.add(P2,BorderLayout.CENTER);
		
		//--------------------------------------------------------------------------
		
		
		//création Panel 3:-----------------------------------------------------------
		P3 = new JPanel();
		//bouton valider:___________________________________________
		//création du bouton
		bouton_valider = new JButton("valider");
		P3.setLayout(new GridLayout(1,1));
		P3.add(bouton_valider);
		container.add(P3,BorderLayout.SOUTH);
		//---------------------------------------------------------------------------

		
	}

	/**
	 * fonction permettant de reset le formulaire (remettre tout les textfield a vide) et déselectionner les boutons radio.
	 */
	public void reset(){
		rb_camion.setSelected(false);
		rb_voiture.setSelected(false);
		tf_immatriculation.setText("");
		tf_nb_passagers.setText("");
		tf_poids.setText("");
		tf_longueur.setText("");
		tf_poids_cargaison.setText("");
		tf_nom_conducteur.setText("");
		tf_prenom_conducteur.setText("");
		tf_num_permis.setText("");
	}



	/**
	 * getter pour le bouton radio à la valeur de voiture.
	 * @return le bouton.
	 */
	public JRadioButton getRb_voiture() {
		return rb_voiture;
	}



	/**
	 * getter pour le bouton radio à la valeur de camion.
	 * @return le bouton
	 */
	public JRadioButton getRb_camion() {
		return rb_camion;
	}



	/**
	 * getter pour le textfield de l'immatriculation.
	 * @return le textfield.
	 */
	public JTextField getTf_immatriculation() {
		return tf_immatriculation;
	}


	/**
	 * getter pour le textfield du nombre de passagers.
	 * @return le textfield.
	 */
	public JTextField getTf_nb_passagers() {
		return tf_nb_passagers;
	}


	/**
	 * getter pour le textfield du poids.
	 * @return le textfield.
	 */
	public JTextField getTf_poids() {
		return tf_poids;
	}


	/**
	 * getter pour le textfield de la longueur.
	 * @return le textfield.
	 */
	public JTextField getTf_longueur() {
		return tf_longueur;
	}


	/**
	 * getter pour le textfield du poids de la cargaison.
	 * @return le textfield.
	 */
	public JTextField getTf_poids_cargaison() {
		return tf_poids_cargaison;
	}


	/**
	 * getter pour le textfield du nom du conducteur.
	 * @return le textfield.
	 */
	public JTextField getTf_nom_conducteur() {
		return tf_nom_conducteur;
	}


	/**
	 * getter pour le textfield du prénom du passagers.
	 * @return le textfield.
	 */
	public JTextField getTf_prenom_conducteur() {
		return tf_prenom_conducteur;
	}


	/**
	 * getter pour le textfield du numéro du permis.
	 * @return le textfield.
	 */
	public JTextField getTf_num_permis() {
		return tf_num_permis;
	}


	/**
	 * getter pour le textfield du bouton valider.
	 * @return le bouton.
	 */
	public JButton getBouton_valider() {
		return bouton_valider;
	}
}
