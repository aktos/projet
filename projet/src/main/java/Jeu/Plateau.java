package Jeu;
import java.awt.List;


public class Plateau {
	
	// Tableau : 28 colonnes pour les 24 flèches, les 2 barres et les 2 zones de dépôt
	
		private Grille grille;
		
		public Plateau(){
			
			this.grille = new Grille();
			this.grille.initialiserGrille();
		}
		public Plateau(Grille plateau) {
			
			this.grille = plateau;
		}
		
		public Jeton getJeton(int li, int col){
			Jeton jeton = new Jeton();
			jeton = this.grille.getJeton(li,col);
			return jeton;			
		}
		public Grille initialiserPlateau(){
			
			this.grille.initialiserGrille();
			Grille grille = new Grille();
			grille = this.grille;
			return grille;		
						
		}

		// Deplacement horaire

		
		

		//Déplacement anti-horaire (idem déplacement horaire sauf dans l'autre sens)
public List indicationDepAntiHo(Jeton jeton,int deA,int deB){

		// On crée une liste des places où le pion peut être déplacé :

		List places =new List();


		// On parcourt l'ensemble du plateau de jeu		

		{
			// On appelle jetonA (resp jetonB) le jeton situé à l'emplacement position-deA (resp position-deB)
			Jeton jetonA = this.grille.getJeton(0,jeton.getPosition()-deA);
			Jeton jetonB = this.grille.getJeton(0,jeton.getPosition()-deB);
				
			// On vérifie que la position est sur le plateau
			if(0<=jeton.getPosition()-deA && 0<=jeton.getPosition()-deB)
			{
				// S'il n'y a pas de jeton en position+deA, le pion y est déplaçable
				if(jetonA.getCouleur()==0 )
				{
					places.add("positions possibles",jeton.getPosition()-deA);
				}
				// S'il n'y a pas de jeton en position+deB, le pion y est déplaçable
				if(jetonB.getCouleur()==0 )
				{
				
					places.add("positions possibles",jeton.getPosition()-deB);
				}
			
			}
			
			// Si un pion est déjà présent on vérifie si sa couleur correspond à celle du jeton que l'on déplace
			else
			{
				if (jetonB.getCouleur() == jeton.getCouleur())  
				{
					places.add("positions possibles",jeton.getPosition()-deB);				
				}
				
				if (jetonA.getCouleur() == jeton.getCouleur()) 
				{
				places.add("positions possibles",jeton.getPosition()-deA);				
				}
			
			}
			}
		return places;
		}

		// Indication des déplacements
		
public List indicationDeplacement(Jeton jeton,int deA,int deB)
	{
			
			// On crée une liste des places où le pion peut être déplacé :
			List places =new List() ;
			
			// On récupère la couleur du jeton pour identifier le déplacement (horaire ou anti-horaire)
			int couleur=jeton.getCouleur();
			
			// si la couleur est true : déplacement horaire
			if (couleur == 1)
			{
			
				places=indicationDepHoraire(jeton,deA,deB);
			}
			
			else
			{
				
				places=indicationDepAntiHo(jeton,deA,deB);
					
			}
		// On retourne la liste des places
			return places;
			
}

		//Méthode déplacement d'un pion

public void deplacer(Jeton jeton,int i) {
		int position = jeton.getPosition()+i;
		jeton.setPosition(position);
		
	}

public List indicationMangerHoraire(Jeton jeton,int deA, int deB){
	List mange = new List();
	// On appelle jetonA (resp jetonB) le jeton situé à l'emplacement position+deA (resp position+deB)
	Jeton jetonA = this.grille.getJeton(0,jeton.getPosition()+deA);
	Jeton jetonB = this.grille.getJeton(0,jeton.getPosition()+deB);
	
	// On vérifie que la position correspondante est bien dans le plateau
	if(jeton.getPosition()+deA<24 && jeton.getPosition()+deB<24)
		{
		// Si un pion est déjà présent on vérifie si sa couleur correspond à celle du jeton que l'on déplace
		
			if (jetonB.getCouleur() == jeton.getCouleur())  
			{
				Jeton jetonC=this.grille.getJeton(1,jeton.getPosition()+deB);
				if (jetonC.getCouleur()==0){
				mange.add("positions possibles",jeton.getPosition()+deB);	
				}
			}
			
			if (jetonA.getCouleur() == jeton.getCouleur()) 
			{
				Jeton jetonC=this.grille.getJeton(1,jeton.getPosition()+deA);
				if (jetonC.getCouleur()==0){
				mange.add("positions possibles",jeton.getPosition()+deA);	
				}
			}
				
		}
	
	return mange;
}
public List indicationMangerAntiHo(Jeton jeton,int deA, int deB){
	List mange = new List();
	// On appelle jetonA (resp jetonB) le jeton situé à l'emplacement position-deA (resp position-deB)
	Jeton jetonA = this.grille.getJeton(0,jeton.getPosition()-deA);
	Jeton jetonB = this.grille.getJeton(0,jeton.getPosition()-deB);
	
	// On vérifie que la position correspondante est bien dans le plateau
	if(0<=jeton.getPosition()-deA && 0<=jeton.getPosition()-deB)
		{
		// Si un pion est déjà présent on vérifie si sa couleur correspond à celle du jeton que l'on déplace
		
			if (jetonB.getCouleur() == jeton.getCouleur())  
			{
				Jeton jetonC=this.grille.getJeton(1,jeton.getPosition()-deB);
				if (jetonC.getCouleur()==0){
				mange.add("positions possibles",jeton.getPosition()-deB);	
				}
			}
			
			if (jetonA.getCouleur() == jeton.getCouleur()) 
			{
				Jeton jetonC=this.grille.getJeton(1,jeton.getPosition()-deA);
				if (jetonC.getCouleur()==0){
				mange.add("positions possibles",jeton.getPosition()-deA);	
				}
			}
				
		}
	
	return mange;
}

public List indicationManger(Jeton jeton,int deA,int deB){

	List mange=new List();
	if (jeton.getCouleur() == 1){
		
		mange = indicationMangerHoraire(jeton,deA,deB);
		
	}
	
	else {
		mange = indicationMangerAntiHo(jeton,deA,deB);
	}
	

	return mange;

}


	// Méthode manger un autre pion
public void manger (Jeton jeton, int i){
	int position = jeton.getPosition()+i;
	jeton.setPosition(position);
	
	if (jeton.getCouleur()== 1){
		Joueur joueur = new Joueur(2);
		Jeton jetonM = new Jeton(joueur,25);
		int j =14;
		int n = 0;
		while(j>0){
			if(this.grille.getJeton(j,25).getCouleur()==0){
			n=j;	
			}
			j--;
			
		}
		this.grille.putJeton(jetonM, n);
	}
	if (jeton.getCouleur()== 2){
		Joueur joueur = new Joueur(1);
		Jeton jetonM = new Jeton(joueur,24);
		int j =14;
		int n = 0;
		while(j>0){
			if(this.grille.getJeton(j,24).getCouleur()==0){
			n=j;	
			}
			j--;
			
		}
		this.grille.putJeton(jetonM, n);
	}
	
	}
	
		

}
	
	
	


