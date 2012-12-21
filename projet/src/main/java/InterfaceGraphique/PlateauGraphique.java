package InterfaceGraphique;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;




public class PlateauGraphique extends JPanel implements MouseListener, MouseMotionListener, Pilote {
	
	// Pointeur vers la fenetre du jeu
	private Fenetre jeu;
	
	// Image de fond
	private Image imgPlateau = new ImageIcon("image\\back.jpg").getImage();
	
	// Tableau d'image des dés
	private Image[] des = new Image[6];
	
	// Image pions pour les déplacements possibles
	private Image deplacementPossible = new ImageIcon("image\\deplacementPossible").getImage();
	
	// Lisle des jetons graphiques
	 private ArrayList<JetonGraphique> jetons = new ArrayList<JetonGraphique>();
	
	// Coups des lancers. Modifiés aléatoirement au début.
	private int coup1, coup2;
	
	// Booléen permettant de savoir si l'animation du lancer est en cours
	private boolean anime = false;
	
	// Jeton graphique momentanée pour le déplacement
	private JetonGraphique jetonMomentanee = new JetonGraphique();
	
	// Booléen permettant de savoir si un déplacement est en cours
	private boolean deplacement;
	
	// Numéro de la flèche de départ
	private int flecheDepart = -1;
	
	// Liste des flèches possibles à chaque sélection d'un jeton
	private ArrayList<ArrayList<Integer>> flechePossible = new ArrayList<ArrayList<Integer>>();
	
	// Constructeur
	public PlateauGraphique() {
		this.setSize(600, 600);
		this.setLayout(null);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		// On initialise la tableau d'image de des
		for ( int i = 0; i < des.length; i++){
			des[i] = Toolkit.getDefaultToolkit().getImage("image\\d" + (i + 1) + ".png");
		}
	}
	
	// Méthode permettant l'animation des dés
	public void animation(){
		Thread td = new Thread() {
			public void run(){
				Random r = new Random();
				anime = true;
				for( int i = 0; i< 8; i++) {
					coup1 = Math.abs(r.nextInt(5));
					coup2 = Math.abs(r.nextInt(5));
				
					try {
						Thread.sleep(150);
						jeu.repaint();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				anime = false;				
			}
		};
		td.start();
	}
	
	// Redéfinition de la méthode paintComponent
	public void paintComponent ( Graphics g ) {
		super.paintComponents(g);
		g.drawImage(imgPlateau, 0, 0, this);
		updatePlateau();
		updateDes(g);
		// TODO A complèter paintComponent
	}
	
	// Méthode permettant de mettre à jor les dés en fonction des dés du modèle
	public void updateDes( Graphics g){
		// TODO A remplir updateDes
	}
	
	// Méthode permettant l'affichage des déplacements possibles
	public void updateDeplacementPossible ( Graphics g){
		// TODO A remplir updateDéplacementPossible
	}
	
	// Méthode permettant d'afficher la correspondance Tour/Jeton
	public void updateInfo ( Graphics g){
		// TODO A remplir updateInfo
		// PAS IMPORTANT COMME METHODE
	}
	// Méthode permettant de mettre à jour le plateau
	public void updatePlateau(){
		// TODO A remplir updatePlateau
		jeu.getBouton().updateBouton();
		
		// On supprime toute la liste de jetons
		jetons.clear();
		
		// On la remplie :
		for ( int i = 0; i < 3/*jeu.getModel().get_listeFleche().size()*/; i++ ) {
			int nbpion = 2/*jeu.getModel().get_listeFleche().getFleche(i).nombrePion()*/;
			
			for ( int j = 0; j < nbpion; j++ ) {
				boolean dernier = false;
				if ( j == nbpion - 1 )
					dernier = true;

				jetons.add(new JetonGraphique(i, 1 /*jeu.getModel().get_listeFleche().getFleche(i).dernierPion().getCouleur()*/, j, nbpion, dernier));

				// si plus de 8 pion on active le ratio !
				if ( nbpion > 8 )
					jetons.get(jetons.size() - 1).placerJeton(
						jetons.get(jetons.size() - 1).getNumFleche(),
						jetons.get(jetons.size() - 1).getRang(), 
						true);
			}
		}
		
		// on supprime tout , et on rajoute les nouveau
		this.removeAll();
			
		for ( int i = jetons.size() - 1; i >= 0; i-- )
			this.add(jetons.get(i));

		// Pion tmp
		this.add(jetonMomentanee);
		jetonMomentanee.setBounds(jetonMomentanee.getPos().x, jetonMomentanee.getPos().y, 25, 25);

		// On place tout les pions sur le plateau par rapport a leur position
		for ( int i = 0; i < jetons.size(); i++ ) {
			jetons.get(i).setBounds(jetons.get(i).getPos().x, jetons.get(i).getPos().y, 25, 25);
		}
		
	}
	
	public void mouseClicked ( MouseEvent e ) {
	}

	public void mouseEntered ( MouseEvent e ) {
	}

	public void mouseExited ( MouseEvent e ) {
	}

	public void mouseMoved ( MouseEvent e ) {
	}
	
	// Méthode permettant de gérer la souris lorsqu'un clique est effectué dans la zone du plateau de jeu
	public void mousePressed ( MouseEvent e ) {
		// TODO A complèter mousePressed
	}

	// Méthode permettant de gérer la souris lorsqu'un clique est relâché dans la zone du plateau de jeu
	public void mouseReleased ( MouseEvent e ) {
		/*if (deplacement){
			int flecheTo = flecheSelectionner(e.getPoint());
			System.out.println("mousePressed on " + flecheTo);
			
			jetonMomentanee.setVisible(false);
		}*/
		// TODO A complèter mouse Released
	}
	
	// Méthode permettant le déplacement graphique du jeton momentannée en fonction de la souris.
	public void mouseDragged ( MouseEvent e ) {
		if (deplacement)
			jetonMomentanee.setPos(new Point(e.getPoint().x - 12, e.getPoint().y - 12));
	}
	
	// Setter
	public void setJeu ( Fenetre f ) {
		jeu = f;
	}
	
	// Méthode qui renvoie la position en pixel par rapport à un numéro de flèche
	public Point posFleche (int num) {
		Point pos = new Point(0,0);
		
		switch(num) {
			case 0: pos = new Point(506,414); break;
			case 1: pos = new Point(474,414); break;
			case 2: pos = new Point(440,414); break;
			case 3: pos = new Point(406,414); break;
			case 4: pos = new Point(373,414); break;
			case 5: pos = new Point(339,414); break;
			case 6: pos = new Point(239,414); break;
			case 7: pos = new Point(206,414); break;
			case 8: pos = new Point(173,414); break;
			case 9: pos = new Point(139,414); break;
			case 10: pos = new Point(106,414); break;
			case 11: pos = new Point(72,414); break;
			  
			case 23: pos = new Point(506,16); break;
			case 22: pos = new Point(474,16); break;
			case 21: pos = new Point(440,16); break;
			case 20: pos = new Point(406,16); break;
			case 19: pos = new Point(373,16); break;
			case 18: pos = new Point(339,16); break;
			case 17: pos = new Point(239,16); break;
			case 16: pos = new Point(206,16); break;
			case 15: pos = new Point(173,16); break;
			case 14: pos = new Point(139,16); break;
			case 13: pos = new Point(106,16); break;
			case 12: pos = new Point(72,16); break;
			 
			case 24 : pos = new Point(288,416); break;
			case 25 : pos = new Point(288,16); break;
			case 26 : pos = new Point(556,187); break;
			case 27 : pos = new Point(556,412); break;
		}
		return pos;
		// TODO A compléter
	}
	
	// A partir d'une position en pixel (Point) on renvoie le numéro de la flèche
	public int flecheSelectionner (Point pos){
		System.out.println(pos);
		// Bas
		if (pos.y >= 235 && pos.y <= 438){
			if (pos.x < 539 && pos.x >= 506) return 0;
			if (pos.x < 506 && pos.x >= 473) return 1;
			if (pos.x < 473 && pos.x >= 440) return 2;
			if (pos.x < 440 && pos.x >= 407) return 3;
			if (pos.x < 407 && pos.x >= 374) return 4;
			if (pos.x < 374 && pos.x >= 341) return 5;
			
			// Barre - 71px
			if (pos.x >= 287 && pos.x <= 312) return 24;
			
			if (pos.x < 270 && pos.x >= 237) return 6;
			if (pos.x < 237 && pos.x >= 204) return 7;
			if (pos.x < 204 && pos.x >= 171) return 8;
			if (pos.x < 171 && pos.x >= 138) return 9;
			if (pos.x < 138 && pos.x >= 105) return 10;
			if (pos.x < 105 && pos.x >= 72) return 11;
			
			// Dehors
			if (pos.x >= 550 && pos.x <= 585) return 27;
		}
		// Haut
		else if (pos.y >= 16 && pos.y <= 220){
			if (pos.x < 539 && pos.x >= 506) return 23;
			if (pos.x < 506 && pos.x >= 473) return 22;
			if (pos.x < 473 && pos.x >= 440) return 21;
			if (pos.x < 440 && pos.x >= 407) return 20;
			if (pos.x < 407 && pos.x >= 374) return 19;
			if (pos.x < 374 && pos.x >= 341) return 18;
			
			// Barre - 71px
			if (pos.x >= 287 && pos.x <= 312) return 25;
			
			if (pos.x < 270 && pos.x >= 237) return 17;
			if (pos.x < 237 && pos.x >= 204) return 16;
			if (pos.x < 204 && pos.x >= 171) return 15;
			if (pos.x < 171 && pos.x >= 138) return 14;
			if (pos.x < 138 && pos.x >= 105) return 13;
			if (pos.x < 105 && pos.x >= 72) return 12;
			
			// Dehors
			if (pos.x >= 550 && pos.x <= 585) return 26;
		}
		
		return -1;
	}
}
