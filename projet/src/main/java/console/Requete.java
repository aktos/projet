package console;

import java.util.Scanner;

public class Requete {
	private String requete;

	public Requete(){}
	
	public int demanderEntier(String phrase){
		Scanner sc = new Scanner(System.in);
		System.out.println(phrase);
		long entier = sc.nextLong();
		sc.close();
		int entierF=(int)entier;
		return  entierF;
	}
	
	public String demanderString(String phrase){
		Scanner sc = new Scanner(System.in);
		System.out.println(phrase);
		String str = sc.nextLine();
		sc.close();
		return str;
	}
	public char demanderChar(String phrase){
		Scanner sc = new Scanner(System.in);
		System.out.println(phrase);
		String str = sc.nextLine();
		char strR=str.charAt(0);
		sc.close();
		return strR;
	}
	
	

}
