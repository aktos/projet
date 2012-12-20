//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Menu.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//



package menus;// on rappelle la localisation de la classe dans les packages

//déclaration de la classe OptionMenu
public class OptionMenu {
	
	//déclaration des attributs
	protected String key;//la clé est ce qui permet d'identifier chaque options
	protected String description;// la description est une phrase qui permet de donner les principales caractéristiques de l'option
	
	//constructeurs
	public OptionMenu() {
		key="toto";
		description="tata";
	
	}
	
	public OptionMenu( String cle, String com) {
		key=cle;
		description=com;
	
	}
	
	// récupération de la clé
	public String getKey() {
		return key;
	
	}
	
	// récupération de la description
	public String getDescription() {
	return description;
	}
	
	// tansformation du menu en un string exploitable pour l'interface
	public String toString(){
		return key + " " + description;
	}
	
	// commande exécuter qui sera codé dans les autres classes filles
	public void executer(){}
	
}

