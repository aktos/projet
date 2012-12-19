package backgammon.projet1;



import java.awt.List;

import Jeu.Dice;
import Jeu.Grille;
import Jeu.Jeton;
import Jeu.Joueur;
import Jeu.Partie;
import Jeu.Plateau;

import ressources.Array2D;
import junit.framework.Test;
import junit.framework.TestCase;


public class test extends TestCase {
	
		
	
	//--------- Test de la classe Dice
	
	public void testGetterD(){
		
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
		Joueur joueurB = new Joueur(false);
		
		boolean couleurA =joueurA.getCouleur();
		boolean couleurB =joueurB.getCouleur();
		
		System.out.println(couleurA + " " + couleurB);
	}
	
	public void testSetterJo(){
		Joueur joueurA = new Joueur();
		joueurA.setCouleur(false);
		boolean couleurA =joueurA.getCouleur();
		System.out.println(couleurA);
		
		
	}
	
	// ------------ Test de la classe Jeton------------
	
	
	public void testGettersJ(){
		
		Joueur joueur = new Joueur();
		Jeton jetonA = new Jeton();
		Jeton jetonB =new Jeton(joueur,4);
		
		boolean couleurA=jetonA.getCouleur();
		int positionB=jetonB.getPosition();
		
		System.out.println(couleurA + " " + positionB);
		
		
	}
	
	public void testSettersJ(){
		
		Joueur joueur = new Joueur();
		Jeton jetonB =new Jeton(joueur,4);
		
		jetonB.setPosition(5);
		int positionB=jetonB.getPosition();
		
		System.out.println( positionB);
		
	}
	

	
	//-----------Test Grille
	
	public void testGrille(){
		
		Grille grille = new Grille();
		Jeton jeton = grille.getJeton(1,2);
		int a = jeton.getPosition();
		System.out.println(a);
	}
	
	// ------------- Test de la classe Plateau 
	
	public void testConstructor(){
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
		Jeton jeton = new Jeton();
		Plateau plateauA = new Plateau();
		plateauA.manger(jeton,2);
		System.out.println("position : "+jeton.getPosition());
		
	}
	// Test de la classe Partie
	public void testPartie(){
		Partie jeu = new Partie();
		jeu.lancerPartie();
	}
	}

