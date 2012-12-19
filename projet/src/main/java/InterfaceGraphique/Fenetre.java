package InterfaceGraphique;



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import menus.*;

public class Fenetre extends JFrame {
	JPanel content = new JPanel();
	CardLayout cl = new CardLayout();
	String[] listContent = {"EcranAccueil","EcranRègles","EcranJeu","EcranOptions"};
	int indice = 0;
	
	public Fenetre(){
	
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 *  Ecran d'accueil 
		 */
		JPanel ecranAccueil = new JPanel();
		ecranAccueil.setBackground(Color.blue);
		
			/**
			 *  MENU :
			 */
		Bouton jouer = new Bouton("Jouer");
		ecranAccueil.add(jouer);
		jouer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				// TODO ajouter action du bouton Jouer
				cl.show(content, "EcranJeu");
			}
		});
		
		Bouton options = new Bouton("Options");
		ecranAccueil.add(options);
		options.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				// TODO ajouter action du bouton Options
				cl.show(content, "EcranOptions");
				
			}
		});

		
		Bouton regles = new Bouton("Règles");
		ecranAccueil.add(regles);
		regles.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				// TODO ajouter action du bouton Règles	
				cl.show(content, "EcranRègles");
				go();
			}
		});
		
		
		/**
		 *  Ecran de Jeu :
		 */
		JPanel plateau = new JPanel();
		plateau.setBackground(Color.white);
		Image plateauImg = 
		Bouton retour = new Bouton("Retour");
		retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				cl.show(content, "EcranAccueil");
			}
		});
		JPanel ecranJeu = new JPanel();
		ecranJeu.setBackground(Color.green);
		ecranJeu.add(plateau);
		ecranJeu.add(retour);
		
		/** 
		 * Ecran des options du jeu :
		 */		
		Bouton retour2 = new Bouton("Retour");
		retour2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				cl.show(content, "EcranAccueil");
				
			}
		});
		JPanel ecranOptions = new JPanel();
		ecranOptions.setBackground(Color.yellow);
		ecranOptions.add(retour2);
		
		/**
		 * Ecran des règles du jeu :
		 */		
		Bouton retour3 = new Bouton("Retour");
		retour3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				cl.show(content, "EcranAccueil");
				
			}
		});
		JPanel ecranRegles = new JPanel();
		ecranRegles.setBackground(Color.red);
		ecranRegles.add(retour3);
		
		/*JPanel boutonPane = new JPanel();
		JButton bouton = new JButton("Conteneur suivant");
		bouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				cl.next(content);	
			}
		});
		JButton bouton2 = new JButton("Contenu par indice");
		bouton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(++indice > 2)
					indice = 0;
				cl.show(content, "ecranJeu");
			}
		});*/
		
		content.setLayout(cl);
		content.add(ecranAccueil, listContent[0]);
		content.add(ecranRegles, listContent[1]);
		content.add(ecranJeu, listContent[2]);
		content.add(ecranOptions, listContent[3]);
		
		//this.getContentPane().add(boutonPane, BorderLayout.NORTH);
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public void go(){
		OptionRules rules = new OptionRules();
		public void actionPerformed(ActionEvent ard0){
			final OptionRules rules = new OptionRules();
			rules.executer();
		}
	}
}

