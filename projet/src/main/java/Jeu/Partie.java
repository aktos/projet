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
	
	public void deplacer(Joueur joueur,int A){
		 
			 char reponse ='n';

			 int pos=0;
			 int j=0;
			 Scanner rep= new Scanner(System.in);
			 // Boucle de recherche des deplacements possibles
			 while(reponse=='n' && j<28){
				
				 int couleur = 0;
					
				 if (this.plateau.sizeColonne(j)==0)
				 {
					 couleur = 0;
				 }
				 else
				 {
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
					 System.out.println("Quelle position choisissez-vous pour ce pion ? (entier)");
					 long position=rep.nextLong();
					 System.out.println(position);
					 
					 pos=(int)position; 
					 this.plateau.deplacer(j-1,pos-j+1);	
					 
					 System.out.println("deplacement reussi !");

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
		 
		// cas de non double
		 if (A!=B){
			 deplacer(joueur,A);
			 deplacer(joueur,B);
		 }
		 else{ 
		 // Cas du double
		 for(int i=1;i<5;i++){
			 deplacer(joueur,A);
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
		 
		 boolean FinA = false;
		 boolean FinB=false;
		 
		 while (FinA==false && FinB == false){
			 // joueurUn
			 faireJouer(joueurUn);
			 
			 // JoueurDeux
			 faireJouer(joueurDeux);
			 
			// verification que tous les pions du joueur blanc sont prets a etre stockes
			 try{
			 for(int i =0;i<18;i++){
				 int parcours = this.plateau.getCouleur(0, i);
				 if (parcours == 2){
					 FinA=true;
				 }
			 }
			 }
			 catch(NullPointerException npe) {
					
				 System.out.println("Oups problème !"); 
			 }
			 }
			 
				
			  
				// verification que tous les pions du joueur noir sont prets a etre stockes
				
				 for(int i =23;i>5;i--){
					 int parcours = this.plateau.getCouleur(0, i);
					 if (parcours== 1){
						 FinB=true;
					 }
					
				 }
		 }
}
	


