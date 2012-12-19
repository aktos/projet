package Jeu;
import java.awt.List;


public class Plateau {
	
	// Tableau : 28 colonnes pour les 24 flèches, les 2 barres et les 2 zones de dépôt
	
		private Grille grille;
		
		public Plateau(){
			
			grille =new Grille();
		}
		public Plateau(Grille plateau) {
			
			this.grille = plateau;
		}
		
		public Jeton getJeton(int li, int col){
			Jeton jeton = new Jeton();
			jeton = this.grille.getJeton(li,col);
			return jeton;			
		}
		public void initialiserPlateau(){
			
			this.grille=new Grille(); 
			
			// Cr�ation et positionnement des jetons
			
			Joueur joueurBlanc=new Joueur(true);
			Joueur joueurNoir = new Joueur(false);
			
			for(int i = 0;i<2;i++){
				Jeton jetonB=new Jeton(joueurBlanc,0);
				this.grille.putJeton(jetonB, i);
			}
			for(int i=0;i<5;i++){
				Jeton jetonN=new Jeton(joueurNoir,5);
				this.grille.putJeton(jetonN, i);
			}
			for(int i=0;i<3;i++){
				Jeton jetonN=new Jeton(joueurNoir,7);
				this.grille.putJeton(jetonN, i);
			}
			for(int i = 0;i<5;i++){
				Jeton jetonB=new Jeton(joueurBlanc,11);
				this.grille.putJeton(jetonB, i);
			}
			for(int i=0;i<5;i++){
				Jeton jetonN=new Jeton(joueurNoir,12);
				this.grille.putJeton(jetonN, i);
			}
			for(int i = 0;i<3;i++){
				Jeton jetonB=new Jeton(joueurBlanc,16);
				this.grille.putJeton(jetonB, i);
			}
			for(int i = 0;i<5;i++){
				Jeton jetonB=new Jeton(joueurBlanc,18);
				this.grille.putJeton(jetonB, i);
			}
			for(int i=0;i<2;i++){
				Jeton jetonN=new Jeton(joueurNoir,23);
				this.grille.putJeton(jetonN, i);
			}
			
			
			
		}

		// Déplacement horaire
public List indicationDepHoraire(Jeton jeton,int deA,int deB){
			// On crée une liste des places où le pion peut être déplacé :
				List places =new List();
			
				// On parcourt la grille constituant le plateau de jeu
				
					// On appelle jetonA (resp jetonB) le jeton situé à l'emplacement position+deA (resp position+deB)
					Jeton jetonA = this.grille.getJeton(0,jeton.getPosition()+deA);
					Jeton jetonB = this.grille.getJeton(0,jeton.getPosition()+deB);
					
					// On vérifie que la position correspondante est bien dans le plateau
				if(jeton.getPosition()+deA<24 && jeton.getPosition()+deB<24)
				{
					// S'il n'y a pas de jeton en position+deA, le pion y est déplaçable
					if(jetonA==null )
					{
						places.add("positions possibles",jeton.getPosition()+deA);
					}
					// S'il n'y a pas de jeton en position+deB, le pion y est déplaçable
					if(jetonB==null )
					{
					
						places.add("positions possibles",jeton.getPosition()+deB);
					}
				
				}
				
				// Si un pion est déjà présent on vérifie si sa couleur correspond à celle du jeton que l'on déplace
				else
				{
					if (jetonB.getCouleur() == jeton.getCouleur())  
					{
						places.add("positions possibles",jeton.getPosition()+deB);				
					}
					
					if (jetonA.getCouleur() == jeton.getCouleur()) 
					{
					places.add("positions possibles",jeton.getPosition()+deA);				
					}
				
				}
				
				
			// on renvoie la liste des places disponibles
				return places;
		}
		
		

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
				if(jetonA==null )
				{
					places.add("positions possibles",jeton.getPosition()-deA);
				}
				// S'il n'y a pas de jeton en position+deB, le pion y est déplaçable
				if(jetonB==null )
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
			boolean couleur=jeton.getCouleur();
			
			// si la couleur est true : déplacement horaire
			if (couleur == true)
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
				if (jetonC==null){
				mange.add("positions possibles",jeton.getPosition()+deB);	
				}
			}
			
			if (jetonA.getCouleur() == jeton.getCouleur()) 
			{
				Jeton jetonC=this.grille.getJeton(1,jeton.getPosition()+deA);
				if (jetonC==null){
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
				if (jetonC==null){
				mange.add("positions possibles",jeton.getPosition()-deB);	
				}
			}
			
			if (jetonA.getCouleur() == jeton.getCouleur()) 
			{
				Jeton jetonC=this.grille.getJeton(1,jeton.getPosition()-deA);
				if (jetonC==null){
				mange.add("positions possibles",jeton.getPosition()-deA);	
				}
			}
				
		}
	
	return mange;
}

public List indicationManger(Jeton jeton,int deA,int deB){

	List mange=new List();
	if (jeton.getCouleur() == true){
		
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
	
	if (jeton.getCouleur()== true){
		Joueur joueur = new Joueur(false);
		Jeton jetonM = new Jeton(joueur,25);
		int j =14;
		int n = 0;
		while(j>0){
			if(this.grille.getJeton(j,25)==null){
			n=j;	
			}
			j--;
			
		}
		this.grille.putJeton(jetonM, n);
	}
	if (jeton.getCouleur()== false){
		Joueur joueur = new Joueur(true);
		Jeton jetonM = new Jeton(joueur,24);
		int j =14;
		int n = 0;
		while(j>0){
			if(this.grille.getJeton(j,24)==null){
			n=j;	
			}
			j--;
			
		}
		this.grille.putJeton(jetonM, n);
	}
	
	}
	
		

}
	
	
	


