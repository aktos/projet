package Jeu;

public class Joueur {
	
		// Le joueur est représenté par sa couleur
	
		private boolean couleur;
		
		// Constructeurs du joueur
		
		public Joueur(){
			
			this.couleur=true;
		}
	
		public Joueur(boolean col) {
		
			this.couleur = col;
		}
		
		// Getters et setters
		
		public boolean getCouleur() {
		
			return couleur;
		
		}
		
		public void setCouleur(boolean col) {
		
			this.couleur = col;
		
		}	
	}



