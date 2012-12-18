//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Menu.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//



package menus;// on rappelle la localisation de la classe dans les packages

//d�claration de la classe OptionMenu
public class OptionMenu {
	
	//d�claration des attributs
	protected String key;//la cl� est ce qui permet d'identifier chaque options
	protected String description;// la description est une phrase qui permet de donner les principales caract�ristiques de l'option
	
	//constructeurs
	public OptionMenu() {
		key="toto";
		description="tata";
	
	}
	
	public OptionMenu( String cle, String com) {
		key=cle;
		description=com;
	
	}
	
	// r�cup�ration de la cl�
	public String getKey() {
		return key;
	
	}
	
	// r�cup�ration de la description
	public String getDescription() {
	return description;
	}
	
	// tansformation du menu en un string exploitable pour l'interface
	public String toString(){
		return key + " " + description;
	}
	
	// commande ex�cuter qui sera cod� dans les autres classes filles
	public void executer(){}
	
}

