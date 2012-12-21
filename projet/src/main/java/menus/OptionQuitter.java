//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Menu.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//


package menus;

//ici on a la classe quitter qui permmettra de quitter le jeu
public class OptionQuitter extends OptionMenu {
	public OptionQuitter(){
		this.key="Quitter";
		this.description="Quitter la partie";
	}
	
	public void executer(){
		quitter();
	}
	
	public void quitter(){
		System.out.println("Quitter YOUPI");
	}

}
