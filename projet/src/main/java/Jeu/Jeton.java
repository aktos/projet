//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Menu.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//

package Jeu;


	public class Jeton {
		
		// ATTRIBUTS
		private  boolean couleur; // True = blanc, False = noir.
		private int position; // Position du dé sur le plateau
		
		
		// METHODES
		public Jeton() {
			
			this.couleur=true;
			this.position=1;
		
		}
		
		public Jeton(Joueur joueur, int pos) {
			
			// Construction d'un jeton à partir d'une couleur et d'une position
			
			this.couleur=joueur.getCouleur();
			this.position=pos;
		
		}
		
		
		
	/*	public void afficherJeton() {
		
		}*/
		
		public boolean getCouleur() {
			
			return this.couleur;
		
		}
		
		public int getPosition() {
			
			return this.position;
		
		}
		
		public void setPosition(int pos){
			this.position=pos;
		}
		
		
	}



