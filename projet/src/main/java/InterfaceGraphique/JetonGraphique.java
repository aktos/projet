package InterfaceGraphique;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// CLASSE DE GESTION DE JETON : ok !

public class JetonGraphique extends JLabel {
	
	// Position du jeton
	private Point pos = new Point(-25, -25);
	
	// Couleur du jeton
	private int couleur;
	
	// Rang du jeton dans la flèche
	private int rang;
	
	// Numéro de la flèche à laquelle il appartient
	private int numFleche = -1;
	
	// Taille de la flèche à laquelle il appartient
	private int tailleFleche = -1;
	
	// Permet de savoir si c'est le dernier jeton de la flèche à laquelle il appartient
	private boolean dernier;
	
	// Constructeur du pion
	public JetonGraphique(int num, int color, int ligne, int taille, boolean last) {
		this.setSize(25,25);
		
		numFleche = num;
		couleur = color;
		rang = ligne;
		dernier = last;
		tailleFleche = taille;
		
		// Image en fonction de la couleur
		if (couleur == 1)
			this.setIcon(new ImageIcon("image\\jetonBlanc.png"));
		else {
			if (couleur == 2)
				this.setIcon(new ImageIcon("image\\jetonNoir.png"));
		}
		placerJeton(numFleche, rang, false);
	}
	
	// Constructeur jeton momentannée
	public JetonGraphique() {
		this.setSize(25,25);
		numFleche = -1;
		couleur = -1;
		rang = 0;
		dernier = false;
		this.setIcon(new ImageIcon("image\\jetonMomentannee.png"));
	}
	
	// Méthode permetttant de placer un pion sur le JPanel du plateau de jeu
	public void placerJeton(int num, int ligne, boolean ratio){
		switch (num){
			case 0: pos = new Point(506,414); break;
			case 1: pos = new Point(474,414); break;
			case 2: pos = new Point(440,414); break;
			case 3: pos = new Point(406,414); break;
			case 4: pos = new Point(373,414); break;
			case 5: pos = new Point(339,414); break;
			case 6: pos = new Point(239,414); break;
			case 7: pos = new Point(206,414); break;
			case 8: pos = new Point(173,414); break;
			case 9: pos = new Point(139,414); break;
			case 10: pos = new Point(106,414); break;
			case 11: pos = new Point(72,414); break;
			  
			case 23: pos = new Point(506,16); break;
			case 22: pos = new Point(474,16); break;
			case 21: pos = new Point(440,16); break;
			case 20: pos = new Point(406,16); break;
			case 19: pos = new Point(373,16); break;
			case 18: pos = new Point(339,16); break;
			case 17: pos = new Point(239,16); break;
			case 16: pos = new Point(206,16); break;
			case 15: pos = new Point(173,16); break;
			case 14: pos = new Point(139,16); break;
			case 13: pos = new Point(106,16); break;
			case 12: pos = new Point(72,16); break;
			 
			case 24 : pos = new Point(288,416); break;
			case 25 : pos = new Point(288,16); break;
			case 26 : pos = new Point(556,187); break;
			case 27 : pos = new Point(556,412); break;
		}
		// Ratio d'affichage pour adapter la position des jetons s'il y en a beaucoup sur la flèche
		if (!ratio){
			if (num < 12 || num == 24 || num == 27 || num == 26)
				pos.y -= ligne*23;
			else
				pos.y += ligne*23;
		}
		else {
			if (num < 12 || num == 24 || num == 27 || num == 26)
				pos.y -= rang*184/tailleFleche;
			else
				pos.y += rang*184/tailleFleche;
		}
	}
	
	// Getters et setters
	public Point getPos(){
		return pos;
	}
	
	public void setPos(Point p){
		pos = p;
	}
	
	public int getNumFleche(){
		return numFleche;
	}
	
	public void setNumFleche(int num){
		numFleche = num;
	}
	
	public int getRang(){
		return rang;
	}
	
	public void setRang(int ligne){
		rang = ligne;
	}
	
	public boolean estDernier(){
		return dernier;
	}
	
	public void setDernier(boolean last){
		dernier = last;
	}
	
	public int getCouleur(){
		return couleur;
	}
}
