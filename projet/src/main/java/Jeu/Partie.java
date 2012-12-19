package Jeu;

import java.awt.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Partie {
	private Grille plateau;
	
	public Partie(){
		this.plateau=new Grille();
	}
	
	public void deplacer(Joueur joueur,int A){
		 // Try and Catch
		 try{
			 String reponse ="n";

			 int pos=0;
			 int j=0;
			 
			 // Boucle de recherche des deplacements possibles
			 while(reponse=="n"){
				
				int couleur = this.plateau.getCouleur(this.plateau.sizeColonne(j)-1, j);
			//System.out.println(couleur);	
				
				
				
				// on parcourt les jetons du joueur et on lui indique les deplacements possibles :
				if(couleur==joueur.getCouleur()){					 
					 List placesA = this.plateau.indicationDeplacement(j, A, 0);
					 if (placesA != null){
						 // pour lire ce que dicte le joueur
						 Scanner rep= new Scanner(System.in);
						 System.out.println("Voici les places disponibles pour votre pion "+placesA.toString()+" choisissez-vous de le d√©placer o ou n ?");
						 reponse = rep.nextLine();
						 rep.close();
					 }
										 
				}
				 j++;
			 }
			 if (reponse=="o"){
						 System.out.println("Quelle position choisissez-vous pour ce pion ? (entier)");
							 // Try and Catch au cas ou la valeur dep rentree par l'utilisateur n'est pas un entier
							 try{
								 Scanner repo= new Scanner(System.in); 
								 pos=repo.nextInt();
								 this.plateau.deplacer(j,pos);	
								 repo.close();
							 }
							 catch(InputMismatchException ime) {
								
								 System.out.println("Valeur saisie non num√©rique\n" + "ou hors des limites int."); 
							 }
			 }
		 } 
		 catch(NullPointerException npe) {
				
			 System.out.println("Oups problËme !"); 
		 }
		 
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
		this.plateau.initialiserGrille();
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
					
				 System.out.println("Oups problËme !"); 
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
	


