package console;

import java.util.Scanner;

public class Requete {
	private Scanner sc;

	public Requete(){
		this.sc=new Scanner(System.in);
	}
	
	
	public int demanderEntier(String phrase){
		System.out.println(phrase);	
		double entier = sc.nextDouble();
		int entierF=(int)entier;
		System.out.println(entier);
		return  entierF;
	}
	
	public String demanderString(String phrase){
		System.out.println(phrase);
		String str = sc.nextLine();
		return str;
	}
	public char demanderChar(String phrase){		
		System.out.println(phrase);
		String str = sc.nextLine();
		char strR=str.charAt(0);
		return strR;
	}
	
	public void fermerScanner(){
		this.sc.close();
	}
	

}
