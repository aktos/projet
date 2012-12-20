package console;

import java.util.Scanner;

public class Requete {

	public Requete(){}
	
	public int demanderEntier(String phrase){
		Scanner sc = new Scanner(System.in);
		System.out.println(phrase);
		long entier = sc.nextLong();
		sc.close();
		return (int) entier;
	}
	
	public String demanderString(String phrase){
		Scanner sc = new Scanner(System.in);
		System.out.println(phrase);
		String str = sc.next().toString();
		sc.close();
		return str;
	}
	public char demanderChar(String phrase){
		Scanner sc = new Scanner(System.in);
		System.out.println(phrase);
		String str = sc.next().toString();
		char strR=str.charAt(0);
		sc.close();
		return strR;
	}

}
