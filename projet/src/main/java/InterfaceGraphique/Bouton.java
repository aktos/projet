package InterfaceGraphique;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Bouton extends JPanel implements Pilote{
	
	/**
	 * Classe pour la gestion des boutons que l'on place dans la zone NORTH
	 * de la fenêtre de jeu
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Pointeur vers la fenêtre du jeu
	private Fenetre jeu;
	
	// Tableau des différents noms de bouton
	private String[] tabNomBt = {"Lancer les dés","Abandon"};
	
	// Tableau des boutons
	private JButton[] tabBt = new JButton[tabNomBt.length];
	
	// Constructeur du bouton
	public Bouton(){
		this.setSize(30,600); // On définit la taille du JPanel
		this.setVisible(false); // Invisible pendant l'intro
		initBt();
	}
	
	// Méthode d'initialisation des boutons avec les actions pour chacun
	public void initBt(){
		for(int i = 0; i < tabNomBt.length; i++){
			tabBt[i] = new JButton(tabNomBt[i]);
			tabBt[i].setSize(30,50); // Taille des boutons
			tabBt[i].setVisible(false);
			
			switch(i){
				case 0: 
					/* Lancer les dés */
					tabBt[i].addActionListener(new ActionListener(){
            			public void actionPerformed(ActionEvent arg0) {
            				System.out.println("Lancer les dés");
							// Appel de la méthode de lancement des dés
						}
					});
					// On ajoute le bouton au JPanel
					this.add(tabBt[i]);
				break;
			
				case 1:
					/* Abandonner */
					tabBt[i].addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0){
							System.out.println("Vous avez perdu !");	
						}
					});
					this.add(tabBt[i]);
				break;
			}
		}
	}
	
	// Méthode permettant d'afficher un bouton
	public void afficherBt(int i, boolean bool){
		tabBt[i].setVisible(bool);
	}
	
	// Méthode permettant d'activer un bouton
	public void activerBt(int i, boolean bool){
		tabBt[i].setEnabled(bool);
	}
	
	// Setter de Fenetre
	public void setJeu(Fenetre j){
		jeu = j;
	}
	
	// Méthode de mise à jour des boutons en fonction de la phase de jeu
	public void updateBouton(){
		// Pour afficher le JPanel Bouton seulement après l'accueil
		this.setVisible(true);
		
		//On cache tout et on remet
		for(int i = 0; i <tabBt.length; i++) {
			afficherBt(i , true);
		}
		
		// TODO à complèter : affichage des boutons en fonction des phases de jeu
	}
	

}
