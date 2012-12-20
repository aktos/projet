package InterfaceGraphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar implements Pilote{
	
	// Pointeur vers la fenêtre du jeu
	private Fenetre jeu;
	
	// Instance d'une barre de menu
	private JMenuBar menuBar = new JMenuBar();
	
	// Instance du menu Fichier
	private JMenu fichier = new JMenu("Fichier");
	
	// Instance du menu Aide
	private JMenu aide = new JMenu("Aide");
		
	// Tableau des noms du menu Fichier
	private String[] tabFichier = {"Nouvelle partie","Options"};
	
	// Tableau des items du menu
	private JMenuItem[] tabMenu = new JMenuItem[tabFichier.length];
	
	// Constructeur
	public Menu(){
		initMenu();
		this.add(menuBar);
	}
	
	// Méthode d'initialisation des différents éléments du menu Fichier
	public void initMenu(){
		for (int i = 0; i < tabFichier.length; i++){
			tabMenu[i] = new JMenuItem(tabFichier[i]);
			switch(i){
				case 0:
					// Action de l'item "Nouvelle partie"
					tabMenu[i].addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
							jeu.initPg();
							jeu.getPanel().updatePlateau();
							System.out.println("Nouvelle partie");
						}
					});
					
					fichier.add(tabMenu[i]); // On l'ajoute au menu
				break;
				
				case 1:
					tabMenu[i].addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
							System.out.println("Options");
						}
					});
					fichier.add(tabMenu[i]);
				break;
			}
		}
		menuBar.add(fichier);
		menuBar.add(aide);
	}
	
	public JMenuBar getmenuBar(){
		return menuBar;
	}
	
	public void setJeu(Fenetre j){
		jeu = j;
	}
}
