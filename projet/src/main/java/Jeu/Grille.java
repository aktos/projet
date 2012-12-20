package Jeu;

import java.awt.List;
import java.util.ArrayList;

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
		else{ 
			System.out.println("position demand�e n'est pas sur le plateau");
		}
		}
	
	public ArrayList<Integer> indicationDeplacement(int position,int deA){
		
		ArrayList<Integer> places = new ArrayList<Integer>();
		if(this.grille[0][position]==1){
			places=indicationDepHoraire(position,deA);
			}
		if(this.grille[0][position]==2){
			places=indicationDepAntiHo(position,deA);
			}
		return places;
	}
	
	public ArrayList<Integer> indicationDepHoraire(int position,int deA){
		// On cree une liste des places ou le pion peut etre deplace :
		ArrayList<Integer> places =new ArrayList<Integer>();
		
			// On verifie que la position correspondante est bien dans le plateau
			if(position+deA<24)
			{

			
				// On appelle couleurA (resp couleurB) la couleur du jeton situe a� l'emplacement position+deA (resp position+deB)
					int couleurA = this.grille[0][position+deA];
					
					int couleur = this.grille[0][position];
				
			
				// S'il n'y a pas de jeton en position+deA, le pion y est deplacable
					if(couleurA==0 )
					{
						places.add(position+deA);
					}
			
					
			// Si un pion est deja� present on verifie si sa couleur correspond a� celle du jeton que l'on deplace
					else
					{
				
						if (couleurA == couleur) 
						{
							places.add(position+deA);				
						}
			
					}
			}
			
			
		// on renvoie la liste des places disponibles
			return places;
	}
	
	//Déplacement anti-horaire (idem déplacement horaire sauf dans l'autre sens)
	public ArrayList<Integer> indicationDepAntiHo(int position,int deA){

			// On cree une liste des places ou le pion peuteetre deplace :

			ArrayList<Integer> places =new ArrayList<Integer>();
	

			{
				// On vérifie que la position est sur le plateau
				if(0<=position-deA )
				{
					
				// On appelle jetonA (resp jetonB) le jeton situé à l'emplacement position-deA (resp position-deB)
					int couleurA = this.grille[0][position-deA];
					
					int couleur = this.grille[0][position];
					
				
				// S'il n'y a pas de jeton en position+deA, le pion y est déplaçable
					if(couleurA==0 )
					{
						places.add(position-deA);
					}
							
				// Si un pion est déjà présent on vérifie si sa couleur correspond à celle du jeton que l'on déplace
					else
					{
						
						if (couleurA == couleur) 
						{
							places.add(position-deA);				
						}
				
					}
					}
			}
			return places;
			}
	
    public static String listToString(ArrayList<Integer>list,String header, String separator, String footer) {
            String delim = "";
            StringBuilder sb = new StringBuilder(header);

            for (int i = 0; i < list.size(); i++) {
                sb.append(delim).append("" + list.get(i));
                delim = separator;
            }

            return sb.append(footer).toString();
        }
	}

