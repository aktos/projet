//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Menu.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//

package menus;

// ici on a la classe qui conservera les différentes règles du jeu
public class OptionRules extends OptionMenu{
	
	public OptionRules(){
		this.key="Règles";
		this.description="Affichage des règles";
	}
	
	public void executer(){
		rules();
	}
	
	public void rules(){
		System.out.println("Règles YOUPI");
	}
}
