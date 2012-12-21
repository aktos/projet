package Jeu;

import console.Requete;

//import console.Requete;

public class Partie {
	private Grille plateau;
	private int phase;
	
	public Partie(){
		this.plateau=new Grille();
		this.phase = 0;
	}
	public Grille getGrille(){
		return this.plateau;
	}
	public int getPhase(){
		return this.phase;
	}
	
	public int getDice(){
		int valeur=0;
		Dice dice = new Dice();
		dice.lancerDice();
		valeur = dice.getNombre();
		return valeur;
		
	}
	
	public boolean fin(Joueur joueur){
			boolean fin = true;
			if(joueur.getCouleur()==1){
			for(int i =0;i<18;i++){
			 int parcours = this.plateau.getCouleur(0, i);
			 if (parcours == joueur.getCouleur()){
				 fin=false;
				 break;
			 }
			}
			}
			if(joueur.getCouleur()==2){
				for(int j =6;j<25;j++){
					 int parcours = this.plateau.getCouleur(0, j);
					 if (parcours == joueur.getCouleur()){
						 fin=false;
						 break;
					 }
				}
			
			 
			 
		 	}System.out.println(fin);
		 return fin;
		 }
	
	public void deplacer(Joueur joueur,int positionDepart,int positionArrivee,int de){
		 
		int listeBarre = this.plateau.indicSortirPionsBarre(joueur, de);
		int listeDeplacement = this.plateau.indicationDeplacement(positionDepart, de);
		int listeManger = this.plateau.indicationManger(positionDepart,de);
		 int colonne = 0;
		 
		 switch (joueur.getCouleur()){
		 case 1 : colonne = 24; break;// Joueur blanc
		 case 2 : colonne =25; break;// Joueur noir
		default : break;
		 }
		 
		 if(this.plateau.sizeColonne(colonne)==0){
		
			 if(listeDeplacement== positionArrivee){
				 
				 this.plateau.deplacer(positionDepart, positionDepart-positionArrivee);
			 }
			 if(listeManger== positionArrivee){
				 this.plateau.manger(positionDepart, positionDepart-positionArrivee);
			 }
		 
			 System.out.println("Deplacement effectue !");
		 }
		 else{
			 if(listeBarre== positionArrivee){
				 this.plateau.sortirPionsBarre(joueur, positionArrivee);
			 }
			 else{System.out.println("Passez votre tour !");}
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
		Requete requete = new Requete();
		 
		 int A = deA.getNombre();
		 System.out.println("le premier de a pour valeur : "+A);
		 int B = deB.getNombre();
		 System.out.println("le deuxieme de a pour valeur : "+B);
		 
		 if(fin(joueur)==false)
		 {		 
			 // cas de non double
			 if (A!=B){
				
				int positionDepart = requete.demanderEntier("quelle est la position de départ ?");
				int positionArrivee = requete.demanderEntier("quelle est la position d'arrivee ? "); 
				requete.fermerScanner();
				deplacer(joueur,positionDepart,positionArrivee,A);
				
				
				int positionDepart1 = requete.demanderEntier("quelle est la position de départ ?");
				int positionArrivee1 = requete.demanderEntier("quelle est la position d'arrivee ? "); 
				 deplacer(joueur,positionDepart1,positionArrivee1,B);
				 requete.fermerScanner();
			 }
			 else
			 { 
			 // Cas du double
				 for(int i=1;i<5;i++)
				 {
					 int positionDepart2 = requete.demanderEntier("quelle est la position de départ ?");
					int positionArrivee2 = requete.demanderEntier("quelle est la position d'arrivee ? "); 
					 
						deplacer(joueur,positionDepart2,positionArrivee2,A);
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
		
		this.phase=1; // premiere phase du jeu
		
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
			 this.phase=2;
			 faireJouer(joueurUn);
			 this.phase=3;
			 faireJouer(joueurDeux);
			 
			 for(int j=0;j<26;j++){
				 if(this.plateau.getCouleur(0, j)==0){
					 Fin=true;
				}
				 
				 
			 }
		 }
		 
		
	}
}


