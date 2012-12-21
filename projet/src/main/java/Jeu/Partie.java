package Jeu;

import java.util.ArrayList;
import console.Requete;

public class Partie {
	private Grille plateau;
	
	public Partie(){
		this.plateau=new Grille();
	}
	public Grille getGrille(){
		return this.plateau;
	}
	
	public boolean fin(Joueur joueur){
			boolean fin = true;
			if(joueur.getCouleur()==1){
			for(int i =0;i<18;i++){
			 int parcours = this.plateau.getCouleur(0, i);
			 if (parcours == joueur.getCouleur()){
				 fin=false;
			 }
			}
			if(joueur.getCouleur()==2){
				for(int i =25;i>6;i--){
					 int parcours = this.plateau.getCouleur(0, i);
					 if (parcours == joueur.getCouleur()){
						 fin=false;
					 }
				}
			}
			 
			 
		 	}
		 return fin;
		 }
	
	public void deplacer(Joueur joueur,int valeurdice){
		 	boolean testrep=false;
			 int pos=0;
			 int j=0;
			 int barre = 0; // identification de la barre correspondant au joueur
			 Requete requete = new Requete();
			 
			 switch(joueur.getCouleur()){
			 case 1 : barre=24;
			 case 2 : barre=25;
			 }
			 			 
			 switch(this.plateau.sizeColonne(barre)){
				 // Si la taille de la barre est nulle, la barre est vide donc le joueur peut deplacer ses pions normalement
				 case 0:					 
					 // Boucle de recherche des deplacements possibles 
					 do{				
						 int couleur = 0;// represente la couleur de la colonne
					
						 if (this.plateau.sizeColonne(j)!=0) // Sinon on prend comme couleur la couleur de la colonne j (couleur du pion contenu en position taille-1)
						 {	int colonne =this.plateau.sizeColonne(j)-1;
							 couleur = this.plateau.getCouleur(colonne, j);}
						 
						// on parcourt les jetons du joueur et on lui indique les deplacements possibles :				
						 if(couleur==joueur.getCouleur()){		 
							 ArrayList<Integer> placesA = this.plateau.indicationDeplacement(j, j+valeurdice);
							 
							 if (placesA != null){
						 // pour lire ce que dicte le joueur						 
						 
								 reponse=requete.demanderChar("Voici les places disponibles pour le pion "+j+" : "+placesA.toString()+" choisissez-vous de le deplacer o ou n ?");
								 }
							 
							 j++;
							 }
			
								 if (reponse=='o'){
								 // Au sein de la liste des positions possibles, le joueur choisit la position pour son pion :
									 pos =requete.demanderEntier("Quelle position choisissez-vous pour ce pion ? (entier)") ;
									 this.plateau.deplacer(j-1,pos);	
									 System.out.println("deplacement reussi !");
								 }
					 }
				 while (testrep=false);
							 			 
				 
				 default : 
					System.out.println("Vous avez des pions piégés dans la barre !");
					
					for(int j1 = 0;j1<this.plateau.sizeColonne(barre);j1++){
						ArrayList<Integer> liste= new ArrayList<Integer>();
						liste = this.plateau.indicSortirPionsBarre(joueur, valeurdice);
						if (liste!=null){
							System.out.println("Vous pouvez sortir le pion"+j1+"aux positions suivante :"+ liste.toString());

							char answer = requete.demanderChar("Souhaitez-vous le choisir ? o ou n");
							if(answer=='o'){
								int choix= requete.demanderEntier("Quelle position choisissez-vous ?");
								this.plateau.sortirPionsBarre(joueur, choix);
							}
							else {
								System.out.println("Passez votre tour !");
							}
					 }
				 }
					 
					 
				 }
				
}
	public void initialiser(){
		this.plateau.initialiserGrille();
	}
	
	public void faireJouer(Joueur joueur){
		Dice deA = new Dice();
		Dice deB=new Dice();
		deA.lancerDice();
		deB.lancerDice();
		 
		 int A = deA.getNombre();
		 System.out.println("le premier de a pour valeur : "+A);
		 int B = deB.getNombre();
		 System.out.println("le deuxieme de a pour valeur : "+B);
		 
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
			 System.out.println("le joueur A commence");
			 
		 }
		 if (D>C){
			 joueurUn=joueurB;	
			 joueurDeux=joueurA;
			 System.out.println("le joueur B commence");
			 
		 }
		 
		 
		 boolean Fin = false;
		 while(Fin==false){
			 faireJouer(joueurUn);
			 faireJouer(joueurDeux);
			 
			 for(int j=0;j<26;j++){
				 if(this.plateau.getCouleur(0, j)==0){
					 Fin=true;
				 }
				 
				 
			 }
		 }
		 
		
	}
}


