package InterfaceGraphique;



import java.awt.*;
import javax.swing.*;

import Jeu.Partie;

import java.awt.event.*;
import menus.*;

public class Fenetre extends JFrame {
	
	// Conteneur du JFrame
	private JPanel content = new JPanel();
	
	// Instance du modèle
	//private Partie modele;
	
	// Instance du JPanel de bouton
	private Bouton bt;
	
	// Instance du JPanel du plateau de jeu
	private PlateauGraphique pg;
	
	// Image d'intro
	private JLabel imgIntro = new JLabel(new ImageIcon("image\\demarrage.jpg"));
	
	public Fenetre(){
		this.setName("BackGammon"); //ID de l'objet
		this.setTitle("BackGammon"); // Titre de la fenêtre
		this.setSize(600,590); // Taille de la fenêtre
		this.setResizable(false); // Taille fixe
		this.setLocationRelativeTo(null); // Centrer la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Action du bouton fermer
		
		// Initialisation du conteneur
		this.setContentPane(content);
		this.setLayout(new BorderLayout());
		
		// Initialisation du modèle
		// modele = modele;
		
		// Initialisation du menu
		Menu m = new Menu();
		m.setJeu(this);
		this.setJMenuBar(m);
		
		// Initialisation de bouton
		bt = new Bouton();
		bt.setJeu(this);
		content.add(bt, BorderLayout.NORTH);
		
		// Initialisation de l'image d'intro
		content.add(imgIntro, BorderLayout.CENTER);
		
	}
	
	// Initialisation du plateau de jeu et ajout au conteneur
	public void initPg(){
		content.remove(imgIntro);
		pg = new PlateauGraphique();
		pg.setJeu(this);
		content.add(pg, BorderLayout.CENTER);
	}
		
	// Méthode main du jeu !
	public static void main(String[] args){
		Fenetre f = new Fenetre();
		f.setVisible(true);
	}
	
	// Getters
	//public Partie getModel(){ return modele; }
	public Bouton getBouton(){ return bt; }
	public PlateauGraphique getPanel(){ return pg; }
}
