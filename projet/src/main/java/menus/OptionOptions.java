//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Menu.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//

package menus;

//ici on a la classe Options qui permettra de sélectionner les Options
public class OptionOptions extends OptionMenu{
	
	public OptionOptions(){
		this.key="Options";
		this.description="Affichage des options";
	}
	
	public void executer(){
		options();
	}
	
	public void options(){
		System.out.println("Options YOUPI");
	}
}
