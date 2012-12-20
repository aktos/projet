//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Menu.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//

package menus;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
		Desktop dt = Desktop.getDesktop();
		try {
			dt.browse(new URI("http://www.ffbg.fr/index.php?Itemid=13&id=9&option=com_content&task=view"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
