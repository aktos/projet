package console;

import java.util.Scanner;

public class Requete {

	public Requete(){}
	
	public int demanderentier(){
		Scanner sc = new Scanner(System.in);
		int entier = sc.nextInt();
		sc.close();
		return entier;
	}
	
	public String demanderString(){
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toString();
		sc.close();
		return str;
	}
	

}
