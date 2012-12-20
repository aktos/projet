package InterfaceGraphique;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Bouton extends JPanel implements Pilote{
	
	/**
	 * Classe pour la gestion des boutons que l'on place dans la zone NORTH
	 * de la fen�tre de jeu
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Pointeur vers la fen�tre du jeu
	private Fenetre jeu;
	
	// Tableau des diff�rents noms de bouton
	private String[] tabNomBt = {"Lancer les d�s","Abandon"};
	
	// Tableau des boutons
	private JButton[] tabBt = new JButton[tabNomBt.length];
	
	// Constructeur du bouton
	public Bouton(){
		this.setSize(30,600); // On d�finit la taille du JPanel
		this.setVisible(false); // Invisible pendant l'intro
		initBt();
	}
	
	// M�thode d'initialisation des boutons avec les actions pour chacun
	public void initBt(){
		for(int i = 0; i < tabNomBt.length; i++){
			tabBt[i] = new JButton(tabNomBt[i]);
			tabBt[i].setSize(30,50); // Taille des boutons
			tabBt[i].setVisible(false);
			
			switch(i){
				case 0: 
					/* Lancer les d�s */
					tabBt[i].addActionListener(new ActionListener(){
            			public void actionPerformed(ActionEvent arg0) {
            				System.out.println("Lancer les d�s");
							// Appel de la m�thode de lancement des d�s
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
	
	// M�thode permettant d'afficher un bouton
	public void afficherBt(int i, boolean bool){
		tabBt[i].setVisible(bool);
	}
	
	// M�thode permettant d'activer un bouton
	public void activerBt(int i, boolean bool){
		tabBt[i].setEnabled(bool);
	}
	
	// Setter de Fenetre
	public void setJeu(Fenetre j){
		jeu = j;
	}
	
	// M�thode de mise � jour des boutons en fonction de la phase de jeu
	public void updateBouton(){
		// Pour afficher le JPanel Bouton seulement apr�s l'accueil
		this.setVisible(true);
		
		//On cache tout et on remet
		for(int i = 0; i <tabBt.length; i++) {
			afficherBt(i , true);
		}
		
		// TODO � compl�ter : affichage des boutons en fonction des phases de jeu
	}
	

}
