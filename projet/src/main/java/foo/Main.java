//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Menu.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//


package foo;

import menus.Menu;
import menus.OptionJouer;
import menus.OptionMenu;
import menus.OptionOptions;
import menus.OptionQuitter;
import menus.OptionRules;


public class Main {
	public static void main(String[]args){
		
		OptionMenu opt1= new OptionMenu("1","desk1") ;
		OptionMenu opt2= new OptionJouer() ;
		OptionMenu opt3= new OptionRules() ;
		OptionMenu opt4= new OptionOptions() ;
		OptionMenu opt5= new OptionQuitter() ;
		Menu menu1=new Menu();
		menu1.ajouterOptionMenu(opt1);
		menu1.ajouterOptionMenu(opt2);
		menu1.ajouterOptionMenu(opt3);
		menu1.ajouterOptionMenu(opt4);
		menu1.ajouterOptionMenu(opt5);
		menu1.afficherMenu();
		menu1.executer();
	}
}