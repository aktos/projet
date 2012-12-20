package Jeu;

public class Dice {
	private  int nombre; // face du dé de 1 à 6
	
	public Dice() {
		
		this.nombre=1; // initialisation
		
	}
	
	
	// Classe lancer Dé
	
	public void lancerDice() {
	
		int nb;
		nb = (int) (Math.random()*6+1); // Lancer au hasard
		
		this.nombre = nb; 
		
	}
	
	public int getNombre() {
		
		return this.nombre; // retourne la valeur du dé
	
	}
	public void setNombre(int i){
		this.nombre=i;
	}
}
