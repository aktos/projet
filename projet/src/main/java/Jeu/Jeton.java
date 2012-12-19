package Jeu;


	public class Jeton {
		
		// ATTRIBUTS
		private  int couleur; // True = blanc, False = noir.
		private int position; // Position du de sur le plateau
		
		
		// METHODES
		public Jeton() {
			
			this.couleur=0;
			this.position=1;
		
		}
		
		public Jeton(Joueur joueur, int pos) {
			
			// Construction d'un jeton à partir d'une couleur et d'une position
			
			this.couleur=joueur.getCouleur();
			this.position=pos;
		
		}
		
			
	/*	public void afficherJeton() {
		
		}*/
		
		public int getCouleur() {
			
			return this.couleur;
		
		}
		
		public int getPosition() {
			
			return this.position;
		
		}
		
		public void setPosition(int pos){
			this.position=pos;
		}
		
		
	}



