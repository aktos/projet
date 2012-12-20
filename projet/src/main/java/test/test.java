package test;




import java.util.Scanner;

import Jeu.Dice;
import Jeu.Grille;

import Jeu.Joueur;
import Jeu.Partie;



import junit.framework.Test;
import junit.framework.TestCase;


public class test extends TestCase {
	
		
	
	//--------- Test de la classe Dice
	
/*	public void testGetterD(){
		
		Dice deA = new Dice();
		
		int valeurA= deA.getNombre();
		System.out.println(valeurA);
		
		
	}
	
	public void testSetterD(){
		Dice deA = new Dice();
		
		deA.setNombre(6);
		int valeurA= deA.getNombre();
		System.out.println(valeurA);
		
	}
	
	public void testLancer(){
		
		Dice deA = new Dice();
		deA.lancerDice();
		
		int valeurA= deA.getNombre();
		System.out.println(valeurA);
		
	}
	
	//--------Test de la classe Joueur
	
	public void testGetterJo(){
		
		Joueur joueurA = new Joueur();
		Joueur joueurB = new Joueur(1);
		
		int couleurA =joueurA.getCouleur();
		int couleurB =joueurB.getCouleur();
		
		System.out.println(couleurA + " " + couleurB);
	}
	
	public void testSetterJo(){
		Joueur joueurA = new Joueur();
		joueurA.setCouleur(2);
		int couleurA =joueurA.getCouleur();
		System.out.println(couleurA);
		
		
	}
	*/
	// ------------ Test de la classe Jeton------------
	
/*	
	public void testGettersJ(){
		
		Joueur joueur = new Joueur();
		Jeton jetonA = new Jeton();
		Jeton jetonB =new Jeton(joueur,4);
		
		int couleurA=jetonA.getCouleur();
		int positionB=jetonB.getPosition();
		
		System.out.println(couleurA + " " + positionB);
		
		
	}
	
	public void testSettersJ(){
		
		Joueur joueur = new Joueur();
		Jeton jetonB =new Jeton(joueur,4);
		
		jetonB.setPosition(5);
		int positionB=jetonB.getPosition();
		
		System.out.println( positionB);
		
	}*/
	

	
	//-----------Test Grille
	
	/*public void testGrille(){
		
		Grille grille = new Grille();
		int a = grille.getCouleur(1,2);
		System.out.println(a);
		grille.initialiserGrille();
		for(int i=0;i<15;i++){
			for(int j=0;j<28;j++){
				System.out.println(grille.getCouleur(i, j));
			}
			grille.deplacer(1, 6);
		}
		grille.indicationDepAntiHo(4, 5, 1);
		grille.indicationDepHoraire(3, 2, 1);
		System.out.println(grille.sizeColonne(7));
	}*/
	
	// ------------- Test de la classe Plateau 
	
	/*public void testConstructor(){
		Grille grille= new Grille();
		
		Plateau plateauA = new Plateau();
		
		Plateau plateauB= new Plateau(grille);
		
	}
	
	
	public void testIndication(){
		
		Jeton jeton = new Jeton();
		Plateau plateauA = new Plateau();
		List L =plateauA.indicationDeplacement(jeton, 1, 5);
		System.out.println(L.toString());
		
	}

	public void testDeplacement(){
		Jeton jeton = new Jeton();
		Plateau plateauA = new Plateau();
		plateauA.deplacer(jeton,2);
		System.out.println("position : "+jeton.getPosition());
		
	}
	public void testManger(){
		
		plateauA.manger(jeton,2);
		System.out.println("position : "+jeton.getPosition());
		
	}*/
	// Test de la classe Partie
	public void testPartie(){
		Joueur joueur = new Joueur(1);
		Partie jeu = new Partie();
		Grille grille = new Grille();
		grille.initialiserGrille();
		System.out.println(grille.sizeColonne(23));
		grille.deplacer(1, 6);
		int j = 0;
		
		//jeu.deplacer(joueur,3);
		
		int pos=0;
		Scanner rep= new Scanner(System.in);
		 System.out.println("Quelle position choisissez-vous pour ce pion ? (entier)");
		 String position=rep.nextLine();
		 pos=(int)position.charAt(0);
		 rep.close();
		 grille.deplacer(j,pos);
	
			
	}
	
}