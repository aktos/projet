package Jeu;

import java.awt.List;

public class Grille {

	private int[][] grille;
	
	public Grille(){
		this.grille = new int[15][28];
		
		for (int i=0;i<15;i++){
			
			for (int j=0;j<28;j++){
				
				 this.grille[i][j]=0;
			}
		}
	}
	
	
	public int getCouleur(int i,int j){
		int couleur=0;
		
		couleur=this.grille[i][j];
		
		return couleur;
		}
		 


	public int sizeColonne(int j) {
		
		
		boolean trouve = false;
		int i =0;
		while(trouve==false && i<15){
			if (this.grille[i][j]==0){
				trouve=true;
			}
			i++;
		
		}
		return i-1;
		
	}


public void initialiserGrille(){
	// Cr�ation et positionnement des jetons
	
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
	public void deplacer(int position,int dice) {
		if (position+dice<28){
		int couleur = this.grille[0][position];
		this.grille[sizeColonne(position+dice)+1][position+dice]=couleur;
		
		this.grille[sizeColonne(position)][position]=0;
		}
		}
	public List indicationDeplacement(int position,int deA,int deB){
		
		List places = new List();
		if(this.grille[0][position]==1){
			places=indicationDepHoraire(position,deA,deB);
			}
		if(this.grille[0][position]==2){
			places=indicationDepAntiHo(position,deA,deB);
			}
		return places;
	}
	
	public List indicationDepHoraire(int position,int deA,int deB){
		// On cree une liste des places ou le pion peut etre deplace :
			List places =new List();
		
			// On verifie que la position correspondante est bien dans le plateau
			if(position+deA<24 && position+deB<24)
			{

			
				// On appelle couleurA (resp couleurB) la couleur du jeton situe a� l'emplacement position+deA (resp position+deB)
					int couleurA = this.grille[0][position+deA];
					int couleurB = this.grille[0][position+deB];
					int couleur = this.grille[0][position];
				
			
				// S'il n'y a pas de jeton en position+deA, le pion y est deplacable
					if(couleurA==0 )
					{
						places.add("positions possibles",position+deA);
					}
				// S'il n'y a pas de jeton en position+deB, le pion y est deplacable
					if(couleurB==0 )
					{
				
						places.add("positions possibles",position+deB);
					}
			
					
			// Si un pion est deja� present on verifie si sa couleur correspond a� celle du jeton que l'on deplace
					else
					{
						if (couleurB == couleur)  
						{
							places.add("positions possibles",position+deB);				
						}
				
						if (couleurA == couleur) 
						{
							places.add("positions possibles",position+deA);				
						}
			
					}
			}
			
			
		// on renvoie la liste des places disponibles
			return places;
	}
	
	//Déplacement anti-horaire (idem déplacement horaire sauf dans l'autre sens)
	public List indicationDepAntiHo(int position,int deA,int deB){

			// On cree une liste des places ou le pion peuteetre deplace :

			List places =new List();
	

			{
				// On vérifie que la position est sur le plateau
				if(0<=position-deA && 0<=position-deB)
				{
					
				// On appelle jetonA (resp jetonB) le jeton situé à l'emplacement position-deA (resp position-deB)
					int couleurA = this.grille[0][position-deA];
					int couleurB = this.grille[0][position-deB];
					int couleur = this.grille[0][position];
					
				
				// S'il n'y a pas de jeton en position+deA, le pion y est déplaçable
					if(couleurA==0 )
					{
						places.add("positions possibles",position-deA);
					}
					// S'il n'y a pas de jeton en position+deB, le pion y est déplaçable
					if(couleurB==0 )
					{
					
						places.add("positions possibles",position-deB);
					}
							
				// Si un pion est déjà présent on vérifie si sa couleur correspond à celle du jeton que l'on déplace
					else
					{
						if (couleurB == couleur)  
						{
							places.add("positions possibles",position-deB);				
						}
					
						if (couleurA == couleur) 
						{
							places.add("positions possibles",position-deA);				
						}
				
					}
					}
			}
			return places;
			}
	}

