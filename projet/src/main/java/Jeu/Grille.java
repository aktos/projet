package Jeu;

public class Grille {

	private int[][] grille;
	
	public Grille(){
		this.grille = new int[15][28];
		
		for (int i=1;i<15;i++){
			
			for (int j=1;j<28;j++){
				
				 this.grille[i][j]=0;
			}
		}
	}
	
	public Jeton getJeton(int i,int j){
		Jeton jeton=new Jeton();
		if(i<15 && j<28){
		jeton=this.grille[i][j];
		if(jeton!=null){
		jeton.setPosition(j);
		}
		else System.out.println("jeton null");
		}
		else System.out.println("taille trop grande !");
		return jeton;
		}
	
	public void putJeton(Jeton jeton, int i){
		this.grille[i][jeton.getPosition()]=jeton;
		
	}


public void initialiserGrille(){
	// Création et positionnement des jetons
	
				Joueur joueurBlanc=new Joueur(1);
				Joueur joueurNoir = new Joueur(2);
				
				for(int i = 0;i<2;i++){
					Jeton jetonB=new Jeton(joueurBlanc,0);
					this.grille[i][0]=jetonB;
				}
				for(int i=0;i<5;i++){
					Jeton jetonN=new Jeton(joueurNoir,5);
					this.grille[i][5]=jetonN;
				}
				for(int i=0;i<3;i++){
					Jeton jetonN=new Jeton(joueurNoir,7);
					this.grille[i][7]=jetonN;
				}
				for(int i = 0;i<5;i++){
					Jeton jetonB=new Jeton(joueurBlanc,11);
					this.grille[i][11]=jetonB;
				}
				for(int i=0;i<5;i++){
					Jeton jetonN=new Jeton(joueurNoir,12);
					this.grille[i][12]=jetonN;
				}
				for(int i = 0;i<3;i++){
					Jeton jetonB=new Jeton(joueurBlanc,16);
					this.grille[i][16]=jetonB;
				}
				for(int i = 0;i<5;i++){
					Jeton jetonB=new Jeton(joueurBlanc,18);
					this.grille[i][18]=jetonB;
				}
				for(int i=0;i<2;i++){
					Jeton jetonN=new Jeton(joueurNoir,23);
					this.grille[i][23]=jetonN;
				}

}
}

