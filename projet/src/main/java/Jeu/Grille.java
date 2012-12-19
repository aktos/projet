package Jeu;

public class Grille {

	private int[][] grille;
	
	public Grille(){
		this.grille = new int[15][28];
		
		for (int i=1;i<15;i++){
			
			for (int j=1;j<28;j++){
				
				 this.grille[i][j]=0;
			}
		}
	}
	
	
	public int getCouleur(int i,int j){
		int couleur=0;
		
		if(i<15 && j<28){
		couleur=this.grille[i][j];
		}
		
		else System.out.println("taille trop grande !");
		return couleur;
		}
	

	public void putJeton(Jeton jeton,int j){
		 this.grille[sizeColonne(j)+1][j]=jeton.getCouleur();
		 jeton.setPosition(j);		 
	}
		 


	public int sizeColonne(int j) {

		boolean trouve = false;
		int i =0;
		while(trouve==false){
			if (this.grille[i][j]==0){
				trouve=true;
			}
			i++;
		}
		return i;
	}


public void initialiserGrille(){
	// Création et positionnement des jetons
	
				int vide =0;
				int Blanc=1;
				int Noir = 2;
				
				for(int i = 0;i<2;i++){
					this.grille[i][0]=Blanc;
				}
				for(int i=0;i<5;i++){
					this.grille[i][5]=Noir;
				}
				for(int i=0;i<3;i++){
					this.grille[i][7]=Noir;
				}
				for(int i = 0;i<5;i++){
					this.grille[i][11]=Blanc;
				}
				for(int i=0;i<5;i++){
					this.grille[i][12]=Noir;
				}
				for(int i = 0;i<3;i++){
					this.grille[i][16]=Blanc;
				}
				for(int i = 0;i<5;i++){
					this.grille[i][18]=Blanc;
				}
				for(int i=0;i<2;i++){
					this.grille[i][23]=Noir;
				}

}
}

