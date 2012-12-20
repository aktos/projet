package Jeu;

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
	public void deplacer(int position,int arrivee) {
		if ((arrivee) <28){
		int couleur = this.grille[0][position];
		this.grille[sizeColonne(arrivee)+1][arrivee]=couleur;
		
		this.grille[sizeColonne(position)][position]=0;
		}
		
		else{ 
			System.out.println("position demand�e n'est pas sur le plateau");
		}
		}
	
	public ArrayList<Integer> indicationDeplacement(int position,int arrivee){
		
		ArrayList<Integer> places = new ArrayList<Integer>();
		if(this.grille[0][position]==1){
			places=indicationDepHoraire(position,arrivee);
			}
		if(this.grille[0][position]==2){
			places=indicationDepAntiHo(position,arrivee);
			}
		return places;
	}
	
	public ArrayList<Integer> indicationDepHoraire(int position,int arrivee){
		// On cree une liste des places ou le pion peut etre deplace :
		ArrayList<Integer> places =new ArrayList<Integer>();
		
			// On verifie que la position correspondante est bien dans le plateau
			if(arrivee<24)
			{

			
				// On appelle couleurA (resp couleurB) la couleur du jeton situe a� l'emplacement position+deA (resp position+deB)
					int couleurA = this.grille[0][arrivee];
					
					int couleur = this.grille[0][position];
				
			
				// S'il n'y a pas de jeton en position+deA, le pion y est deplacable
					if(couleurA==0 )
					{
						places.add(arrivee);
					}
			
					
			// Si un pion est deja� present on verifie si sa couleur correspond a� celle du jeton que l'on deplace
					else
					{
				
						if (couleurA == couleur) 
						{
							places.add(arrivee);				
						}
			
					}
			}
			
			
		// on renvoie la liste des places disponibles
			return places;
	}
	
	//Déplacement anti-horaire (idem déplacement horaire sauf dans l'autre sens)
	public ArrayList<Integer> indicationDepAntiHo(int position,int arrivee){

			// On cree une liste des places ou le pion peuteetre deplace :

			ArrayList<Integer> places =new ArrayList<Integer>();
	

			{
				// On vérifie que la position est sur le plateau
				if(0<=arrivee )
				{
					
				// On appelle jetonA (resp jetonB) le jeton situé à l'emplacement position-deA (resp position-deB)
					int couleurA = this.grille[0][arrivee];
					
					int couleur = this.grille[0][position];
					
				
				// S'il n'y a pas de jeton en position+deA, le pion y est déplaçable
					if(couleurA==0 )
					{
						places.add(arrivee);
					}
							
				// Si un pion est déjà présent on vérifie si sa couleur correspond à celle du jeton que l'on déplace
					else
					{
						
						if (couleurA == couleur) 
						{
							places.add(arrivee);				
						}
				
					}
					}
			}
			return places;
	}
			
			public ArrayList<Integer> indicationMangerHoraire(int position,int arrivee){
				ArrayList<Integer> mange = new ArrayList<Integer>();
				
				int couleurA = this.grille[0][arrivee];
				int couleur = this.grille[0][position];
				// On vérifie que la position correspondante est bien dans le plateau
				if(arrivee<24 && sizeColonne(arrivee)==1)
					{
					// Si un pion est déjà présent on vérifie si sa couleur correspond à celle du jeton que l'on déplace
					
						if (couleurA != couleur && couleurA!=0)  
						{
							mange.add(arrivee);						
						}
							
					}
				
				return mange;
			}
			
			
			public ArrayList<Integer> indicationMangerAntiHo(int position,int arrivee){
				ArrayList<Integer> mange = new ArrayList<Integer>();
				
				int couleurA = this.grille[0][arrivee];
				int couleur = this.grille[0][position];
				// On vérifie que la position correspondante est bien dans le plateau
				if(arrivee<24 && sizeColonne(arrivee)==1)
					{
					// Si un pion est déjà présent on vérifie si sa couleur correspond à celle du jeton que l'on déplace
					
						if (couleurA != couleur && couleurA!=0)  
						{
							mange.add(arrivee);						
						}
							
					}
				
				return mange;
			}
			public ArrayList<Integer> indicationManger(int position,int arrivee){

				ArrayList<Integer> mange=new ArrayList<Integer>();
				if (grille[0][position]==1){
					
					mange = indicationMangerHoraire(position,arrivee);
					
				}
				
				else {
					mange = indicationMangerAntiHo(position,arrivee);
				}
				

				return mange;

			}


				// Methode manger un autre pion
			public void manger(int position,int arrivee) {
				if ((arrivee) <24){
				int couleur = this.grille[0][arrivee];
				deplacer(position,arrivee);
				
				if (couleur == 1){
					deplacer(arrivee,24-(arrivee));
				}
				if (couleur == 2){
					deplacer(arrivee,25-(arrivee));
				}
				}
				
				else{ 
					System.out.println("position demand�e n'est pas sur le plateau");
				}
				}	
			
			public ArrayList<Integer> indicSortirPionsBarre(Joueur joueur, int de){
				
				ArrayList<Integer> places = new ArrayList<Integer>();
				
				if(joueur.getCouleur()==1){
					
					int j = 0;
					while(j<6){
						if (j==de-1){
						if (sizeColonne(j)==0){
							places.add(j);
						}
						if (this.grille[0][j]==1){
							places.add(j);
						}
						if (this.grille[0][j]==2 && sizeColonne(j)==1){
							places.add(j);
						}
						j++;
						
					}
					}
				}
				if(joueur.getCouleur()==2){
					
					int j = 23;
					while(j>17){
						if (j==24-de){
						if (sizeColonne(j)==0){
							places.add(j);
						}
						if (this.grille[0][j]==2){
							places.add(j);
						}
						if (this.grille[0][j]==1 && sizeColonne(j)==1){
							places.add(j);
						}
						j--;
						
					}
					}
				}
				return places;
				
			}
			public void sortirPionsBarre(Joueur joueur,int pos){
				int couleur = joueur.getCouleur();
				if(couleur==1){
					deplacer(24,pos-24);
				}
				if(couleur==2){
					deplacer(25,25-pos);
				}
			}
			
			public void stocker(Joueur joueur,int position){
				int couleur = joueur.getCouleur();
				if(couleur==1){
					deplacer(position,26);
				}
				if(couleur==2){
					deplacer(position,27);
				}
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

