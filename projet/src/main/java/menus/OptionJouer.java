//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Menu.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//

package menus;

// ici on code l'option JOuer qui permmettra de lancer le jeu
public class OptionJouer extends OptionMenu{
	
	public OptionJouer(){
		this.key="Jouer";
		this.description="Commencer la partie";
	}
	
	public void executer(){
		jouer();
	}
	
	public void jouer(){
		System.out.println("Jouer YOUPI");
	}
}
