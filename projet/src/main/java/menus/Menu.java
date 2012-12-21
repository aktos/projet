//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Menu.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//


package menus; // on rappelle la localisation de la classe dans les packages

import java.util.Scanner;
import java.util.Vector; // On importe la bibliotéque Vector pour pouvoir l'utiliser pour le menu ( Menu = Vector<OptionMenu> )





// déclaration de la classe Menu

public class Menu {
	
	//déclaration des attributs: ici on déclare uniquement un Vector
	private  Vector<OptionMenu> menu;
	
	//déclaration du contructeur
	public Menu() {
		menu = new Vector<OptionMenu>();
	}

	// déclaration d'une méthode la méthode qui permet d'afficher le menu sous forme d'un tableau d'OptionMenu
	public void afficherMenu() {
		System.out.println(this.toString());	
	}
	
	// déclaration de la méthode toString qui décrit dans un string les différents paramètres contenu dans le menu c'est à dire la liste des OptionMenus
	public String toString() {
		String description_menu="";		
		for(int i=0; i<menu.size();i++){//ici on parcours le menu pour accéder aux OptionMenu
			description_menu= description_menu + menu.elementAt(i).toString() + "\n";
		}
		return description_menu;
	}
	
	//déclaration de la méthode permettant d'ajouter au menu de nouvelles OptionMenu
	public void ajouterOptionMenu(OptionMenu opt) {
		menu.addElement(opt);
	
	}
	
	public String demande(){
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toString();
		sc.close();
		return str;
	}
	
	//déclaration de la méthode exécuter qui permet de sélectionnner dans le menu l'option à exécuter 
	public void executer(){
		boolean fin=false;
		
		do
		{
			String reponse=this.demande();
			for(int i=0; i<menu.size();i++){//ici on parcours le menu pour accéder aux OptionMenu
					if (menu.elementAt(i).getKey().equals(reponse)){//on teste la reponse de l'utilisateur avec les clé du menus. Cette fonction est un début elle sera par la suite supprimer avec les clics .
						menu.elementAt(i).executer();// ici on exécute l'optio  sélectionné
						fin=true;
						break;}
				
				}
		}
			while(fin==false);
	}	
		

}
