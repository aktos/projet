//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Affichage.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//

package console;

public class Affichage {
	
	public Affichage(){};

		public static void affichertableau(int[][] grille){
			
			//cadre supérieur
			System.out.println("________________________________________________________");
			System.out.println("________________________________________________________");
			
			//chifffre de colonne haut
			System.out.print("||  "); //bord gauche  
			for(int i=13; i<19 ; i++){				
				System.out.print(i +" ");
			}
			
			System.out.print("  "+ 25 +"   ");
			
			for(int i=19; i<25 ; i++){				
				System.out.print(i +" ");
			}
			
			System.out.print("  "+26 +" ");
			
			System.out.print("  ||"); //bord droit 
			System.out.print("\n");
			
			//haut du plateau de jeu
			
			for(int i=0; i<15 ; i++){
				
				System.out.print("||   "); //bord gauche
				
				//Partie 3
				for(int j=12;j<18;j++){
					afficherpion(grille[i][j]);
				System.out.print("  ");}
				
				//colonne 25 barre du milieu
				System.out.print(" |");
				afficherpion(grille[i][25]);
				System.out.print("|   ");
					
				//partie 4
				for(int j=18;j<24;j++){
					afficherpion(grille[i][j]);
				System.out.print("  ");}
				
				//colonne 26 barre du milieu
				System.out.print(" |");
				afficherpion(grille[i][26]);
				System.out.print("|  ||"); //bord droit 
				
			System.out.print("\n");
			}
				
			//séparation bas/haut
			
			System.out.println("--------------------------------------------------------");
			System.out.println("--------------------------------------------------------");
			
			//bas du plateau de jeu
			
			for(int i=0; i<15 ; i++){ 
				System.out.print("||   ");//bord gauche
				
				//partie 2
				for(int j=6;j<12;j++){
					afficherpion(grille[i][j]);
					System.out.print("  ");}					
					
				//colonne 24 barre du milieu
				System.out.print(" |");
				afficherpion(grille[i][24]);
				System.out.print("|   ");
				
				//partie 1
				for(int j=0;j<6;j++){
					afficherpion(grille[i][j]);
				System.out.print("  ");}
				
				//colonne 27 barre du milieu
				System.out.print(" |");
				afficherpion(grille[i][27]);
				System.out.print("|  ||"); //bord droit 
			
			System.out.print("\n");
			}
			
			//chifffre de colonne bas
			System.out.print("||  "); //bord gauche  
			for(int i=12; i>9 ; i--){				
				System.out.print(i +" ");
			}
			
			System.out.print(" ");
			for(int i=9; i>6 ; i--){				
				System.out.print(i +"  ");
			}
			
			System.out.print(" "+24 +"    ");
			
			for(int i=6; i>0 ; i--){				
				System.out.print(i +"  ");
			}
			
			System.out.print(" "+27 +" ");
			
			System.out.print("  ||"); //bord droit 
			System.out.print("\n");
			
			//cadre inférieur
			System.out.println("________________________________________________________");
			System.out.println("________________________________________________________");
		}
			
			

		public static void afficherpion(int entier){
			switch (entier){			
			case 1: System.out.print("+"); break;
			case 2: System.out.print("-"); break;
			default : System.out.print(" "); break;			
			}
		}
		
		
		public static int[][] test(){
			int[][] tab=new int[15][28];
			
			for (int i=0; i<15 ;i++){
				for (int j=0; j<28 ;j++){
					tab[i][j]=1;
				}
				
			}
			
			
			return tab;
		}
		
		public static void main(String []args){
			affichertableau(test());
			//Grille grille = new Grille();
			//affichertableau(grille);
			}

}
