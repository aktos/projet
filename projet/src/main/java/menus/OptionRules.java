//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Menu.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//

package menus;

// ici on a la classe qui conservera les diff�rentes r�gles du jeu
public class OptionRules extends OptionMenu{
	
	public OptionRules(){
		this.key="R�gles";
		this.description="Affichage des r�gles";
	}
	
	public void executer(){
		rules();
	}
	
	public void rules(){
		System.out.println("R�gles YOUPI");
	}
}
