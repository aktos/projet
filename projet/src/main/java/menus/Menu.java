//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Menu.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//


package menus; // on rappelle la localisation de la classe dans les packages

import java.util.Scanner;
import java.util.Vector; // On importe la bibliot�que Vector pour pouvoir l'utiliser pour le menu ( Menu = Vector<OptionMenu> )





// d�claration de la classe Menu

public class Menu {
	
	//d�claration des attributs: ici on d�clare uniquement un Vector
	private  Vector<OptionMenu> menu;
	
	//d�claration du contructeur
	public Menu() {
		menu = new Vector<OptionMenu>();
	}

	// d�claration d'une m�thode la m�thode qui permet d'afficher le menu sous forme d'un tableau d'OptionMenu
	public void afficherMenu() {
		System.out.println(this.toString());	
	}
	
	// d�claration de la m�thode toString qui d�crit dans un string les diff�rents param�tres contenu dans le menu c'est � dire la liste des OptionMenus
	public String toString() {
		String description_menu="";		
		for(int i=0; i<menu.size();i++){//ici on parcours le menu pour acc�der aux OptionMenu
			description_menu= description_menu + menu.elementAt(i).toString() + "\n";
		}
		return description_menu;
	}
	
	//d�claration de la m�thode permettant d'ajouter au menu de nouvelles OptionMenu
	public void ajouterOptionMenu(OptionMenu opt) {
		menu.addElement(opt);
	
	}
	
	public String demande(){
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toString();
		sc.close();
		return str;
	}
	
	//d�claration de la m�thode ex�cuter qui permet de s�lectionnner dans le menu l'option � ex�cuter 
	public void executer(){
		boolean fin=false;
		
		do
		{
			String reponse=this.demande();
			for(int i=0; i<menu.size();i++){//ici on parcours le menu pour acc�der aux OptionMenu
					if (menu.elementAt(i).getKey().equals(reponse)){//on teste la reponse de l'utilisateur avec les cl� du menus. Cette fonction est un d�but elle sera par la suite supprimer avec les clics .
						menu.elementAt(i).executer();// ici on ex�cute l'optio  s�lectionn�
						fin=true;
						break;}
				
				}
		}
			while(fin==false);
	}	
		

}
