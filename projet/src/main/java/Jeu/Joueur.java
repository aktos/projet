package Jeu;

public class Joueur {
	
		// Le joueur est représenté par sa couleur
	
		private int couleur;
		
		// Constructeurs du joueur
		
		public Joueur(){
			
			this.couleur=1;
		}
	
		public Joueur(int col) {
		
			this.couleur = col;
		}
		
		// Getters et setters
		
		public int getCouleur() {
		
			return couleur;
		
		}
		
		public void setCouleur(int col) {
		
			this.couleur = col;
		
		}	
	}



