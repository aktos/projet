package Jeu;

import java.awt.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Partie {
	private Plateau plateau;
	
	public Partie(){
		this.plateau=new Plateau();
	}
	
	public void deplacer(Joueur joueur,int A){
			 
			 String reponse =" n";
			 int pos=0;
			 // Boucle de recherche des déplacements possibles
			 while(reponse!="o"){
				
				 for(int j=0; j<24;j++){
					 Jeton jeton = this.plateau.getJeton(0, j);
					 
				
					 Scanner rep= new Scanner(System.in); // pour lire ce que dicte le joueur 
					if(jeton.getCouleur()==joueur.getCouleur()){
					 
					 List placesA = this.plateau.indicationDeplacement(jeton, A, 0);
					 if (placesA != null){
						 System.out.println("Voici les places disponibles pour votre pion "+placesA.toString()+" choisissez-vous de le déplacer o ou n ?");
						 reponse = rep.nextLine();
						 System.out.println("Quelle position choisissez-vous pour ce pion ? (entier)");
						// Try and Catch au cas où la valeur dep rentrée par l'utilisateur n'est pas un entier
							try{
								pos=rep.nextInt();
								this.plateau.deplacer(jeton,pos);															
							}
							catch(InputMismatchException ime) {
								
								System.out.println("Valeur saisie non numérique\n" + "ou hors des limites int."); 
							}
					 }
					 else {
						 System.out.println("Passez votre tour");
						 reponse="o";
					 }
					}
				 }
					
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
		this.plateau.initialiserPlateau();
		Joueur joueurA = new Joueur(true);
		Joueur joueurB = new Joueur(false);
		
		Dice deA = new Dice();
		Dice deB = new Dice();
		
		// Lancer de dés initial pour déterminer quel joueur débute la partie
		
		// Premier Joueur :
		
		 deA.lancerDice();
		 deB.lancerDice();
		 
		 int C = deA.getNombre()+deB.getNombre();
		 
		// Deuxième Joueur :
			
		 deA.lancerDice();
		 deB.lancerDice();
		 
		 int D = deA.getNombre()+deB.getNombre();
		 
		 // le JoueurUn devient alors le vainqueur du lancé de dés.
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
		 
		 boolean Fin = false;
		 
		 while (Fin=false){
			 // joueurUn
			 faireJouer(joueurUn);
			 
			 // JoueurDeux
			 faireJouer(joueurDeux);
			 
			// vérification que tous les jetons sont prêts à être stockés
			 boolean ready=false;
			 for(int i =0;i<18;i++){
				 Jeton parcours = this.plateau.getJeton(0, i);
				 if (parcours.getCouleur() == false){
					 ready = true;
				 }
				 Fin=true;
			 }
			 
			 
			 
			 
			}
				 
			 
			 
		
		
		
		
		
	}
	
	

}
