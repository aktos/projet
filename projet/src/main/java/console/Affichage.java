//  Projet Informatique Java TSE
//
//  @ Project : Backgammon
//  @ File Name : Affichage.java
//  @ Date : 17/12/2012
//  @ Author : Barty - Gramont - Montlouis-Calixte
//

package console;

public class Affichage {
	private Integer entier;
	
	public Affichage(){
		entier= new Integer(entier);
		
	};

		/*public static void affichertableau(Grille grille){
			for(int i=0; i<12 ; i++){
				for(int j=0;j<11;j++){
					if (grille.getJeton(i,j).getCouleur()==true){
						System.out.println("+");
					}
						else{
							if(grille.getJeton(i,j).getCouleur()==false){
								System.out.println("-");
							}
							else {
								System.out.println(" ");
							}
						}
					System.out.println(" ");
					}
				System.out.println("\n");
					
					
				}
			System.out.println("-----------------------------");
			System.out.println("-----------------------------");
			
			for(int i=0; i<11 ; i++){
				for(int j=12;j<24;j++){
					if (grille.getJeton(i,j).getCouleur()==true){
						System.out.println("+");
					}
						else{
							if(grille.getJeton(i,j).getCouleur()==false){
								System.out.println("-");
							}
							else {
								System.out.println(" ");
							}
						}
					System.out.println(" ");
					}
				System.out.println("\n");
					
					
				}
			}*/
		

		
		public static void test(){
			System.out.println("tata"+"poule");
		}
		
		public static void main(String []args){
			test();
			//Grille grille = new Grille();
			//affichertableau(grille);
			}

}
