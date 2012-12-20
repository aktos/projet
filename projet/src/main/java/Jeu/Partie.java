package Jeu;

import java.awt.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Partie {
	private Grille plateau;
	
	public Partie(){
		this.plateau=new Grille();
	}
	
	public boolean fin(Joueur joueur){
			boolean fin = false;
		 for(int i =0;i<18;i++){
			 int parcours = this.plateau.getCouleur(0, i);
			 if (parcours == joueur.getCouleur()){
				 fin=true;
			 }
			 
		 	}
		 return fin;
		 }
	
	public void deplacer(Joueur joueur,int A){
		 
			 char reponse ='n';

			 int pos=0;
			 int j=0;
			 int coul = 0;
			 
			 Scanner rep= new Scanner(System.in);
			 if(joueur.getCouleur()== 1){
				coul =24;
			 }
			 if (joueur.getCouleur()== 2) {
				 coul=25;
				 }
			 
				 if (this.plateau.sizeColonne(coul)==0)
				 {		 
			 
					 // Boucle de recherche des deplacements possibles 
					 while(reponse=='n' && j<24){
				
						 int couleur = 0;
					
						 if (this.plateau.sizeColonne(j)==0) // si la taille de la colonne est nulle, la colonne est vide et donc couleur = 0
						 {
							 couleur = 0;
						 }
						 else
						 {
					 // Sinon on prend comme couleur la couleur du pion contenu en position taille-1
							 int col =this.plateau.sizeColonne(j)-1;
							 couleur = this.plateau.getCouleur(col, j);
						 }
				
						// on parcourt les jetons du joueur et on lui indique les deplacements possibles :
				
						 if(couleur==joueur.getCouleur()){					 
				
							 ArrayList<Integer> placesA = this.plateau.indicationDeplacement(j, A);
							 if (placesA != null){
						 // pour lire ce que dicte le joueur
						 
						 
								 System.out.println("Voici les places disponibles pour le pion "+j+" : "+placesA.toString()+" choisissez-vous de le deplacer o ou n ?");
								 String r = rep.nextLine();
								 reponse = r.charAt(0);
						 
							 }
										 
						 }
						 j++;
					 }
					 // Au sein de la liste des positions possibles, le joueur choisit la position pour son pion :
					 	System.out.println("Quelle position choisissez-vous pour ce pion ? (entier)");
					 	long position=rep.nextLong();
					 	
					 
					 	pos=(int)position; 
					 	this.plateau.deplacer(j-1,pos-j+1);	
					 
					 	System.out.println("deplacement reussi !");

					 	
		
				 }
				 if(this.plateau.sizeColonne(coul)!=0){
					System.out.println("Vous avez des pions piégés dans la barre !");
					
					for(int j1 = 0;j1<this.plateau.sizeColonne(coul);j1++){
						ArrayList<Integer> liste= new ArrayList<Integer>();
						liste = this.plateau.indicSortirPionsBarre(joueur, A);
						if (liste!=null){
							System.out.println("Vous pouvez sortir le pion"+j1+"aux positions suivante :"+ liste.toString());
							System.out.println("Souhaitez-vous le choisir ? o ou n");
							String ans=rep.nextLine();
							char answer = ans.charAt(0);
							if(answer=='o'){
								System.out.println("Quelle position choisissez-vous ?");
								long c = rep.nextLong();
								int choix=(int)c;
								this.plateau.sortirPionsBarre(joueur, choix);
							}
							else {
								System.out.println("Passez votre tour !");
							}
					 }
				 }
					 
					 
				 }
				 rep.close();
}
	public void initialiser(){
		this.plateau.initialiserGrille();
	}


	
	public void faireJouer(Joueur joueur){
		Dice deA = new Dice(),deB=new Dice();
		deA.lancerDice();
		deB.lancerDice();
		 
		 int A = deA.getNombre();
		 int B = deB.getNombre();
		 
		 if(fin(joueur)==false)
		 {		 
			 // cas de non double
			 if (A!=B){
				 deplacer(joueur,A);
				 deplacer(joueur,B);
			 }
			 else
			 { 
			 // Cas du double
				 for(int i=1;i<5;i++)
				 {
					 deplacer(joueur,A);
				 }
			 }
		 }
		 else {
			 
			 this.plateau.stocker(joueur,A);
			 this.plateau.stocker(joueur,B);
			 if(A==B){
				 this.plateau.stocker(joueur,A);
				 this.plateau.stocker(joueur,B); 
			 }
			 
		 }
	}
	
	
	public void lancerPartie(){
		initialiser();
		Joueur joueurA = new Joueur(1);
		Joueur joueurB = new Joueur(2);
		
		Dice deA = new Dice();
		Dice deB = new Dice();
		
		// Lancer de des initial pour determiner quel joueur debute la partie
		
		// Premier Joueur :
		
		 deA.lancerDice();
		 deB.lancerDice();
		 
		 int C = deA.getNombre()+deB.getNombre();
		 
		// Deuxieme Joueur :
			
		 deA.lancerDice();
		 deB.lancerDice();
		 
		 int D = deA.getNombre()+deB.getNombre();
		 
		 // le JoueurUn devient alors le vainqueur du lancer de des.
		 Joueur joueurUn = new Joueur();
		 Joueur joueurDeux = new Joueur();
		 if (D<C){
			 joueurUn=joueurA;	
			 joueurDeux=joueurB;
			 
		 }
		 if (D>C){
			 joueurUn=joueurB;	
			 joueurDeux=joueurA;
			 
		 }
		 
		 boolean FinUn = fin(joueurUn);
		 boolean FinDeux = fin(joueurDeux);
		 boolean Fin = false;
		 while(Fin==false){
			 faireJouer(joueurUn);
			 faireJouer(joueurDeux);
		 }
		 
		
	}
}


