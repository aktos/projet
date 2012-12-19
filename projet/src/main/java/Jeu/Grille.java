package Jeu;

public class Grille {

	private Jeton[][] grille;
	
	public Grille(){
		this.grille = new Jeton[15][28];
		Jeton jeton = new Jeton();
		
		for (int i=1;i<15;i++){
			
			for (int j=1;j<28;j++){
				
				 this.grille[i][j]=jeton;
			}
		}
	}
	
	public Jeton getJeton(int i,int j){
		Jeton jeton;
		jeton=this.grille[i][j];
		return jeton;
		}
	
	public void putJeton(Jeton jeton, int i){
		this.grille[i][jeton.getPosition()]=jeton;
	}
}
