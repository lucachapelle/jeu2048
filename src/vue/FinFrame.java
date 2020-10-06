package vue;

import javax.swing.JFrame;



	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.*;

	import controlleur.FermerFenetreAdapter;
	import controlleur.NewActionListner;
	import controlleur.FermerFenetreListener;
	import controlleur.FermerFenetrePListener;
	import controlleur.JeuActionListner;
import controlleur.Logger;
import controlleur.menujeuActionListner;
	import package2048.Jeu2048;

	public class FinFrame extends JFrame {
		
		private static final long serialVersionUID = 1L;
		Color bleu1= new Color(0, 255, 255);
		Color bleu2= new Color(0, 255, 200);
		Color bleu3= new Color(0, 255, 150);
		
		// Initialisation des dimensions de la fenêtre
		private int LARGEUR=200;
		private int HAUTEUR=300;
		
		private boolean vic;
		private Jeu2048 jeu;

		// Création de la fenêtre de fin de jeu
		public FinFrame(Jeu2048 jeu,boolean vic){
	    this.setTitle("Fin du jeu");
	    this.setSize(LARGEUR, HAUTEUR);
	    this.vic = vic;
	    
	    //Centrer la fenêtre
	    this.setLocationRelativeTo(null);
	    
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    
	    //Empêcher le redimensionnement de la fenêtre
	    this.setResizable(false);
	    
	    //Retirer les contours
	    this.setUndecorated(false);	   
	        this.setLayout(new GridLayout(4, 1));


	    
	    
	    JLabel titre = new JLabel("JEU 2048");
	    Font f = new Font("Courier", Font.BOLD, 25);
	    titre.setFont(f);
	    
	    JPanel message = new JPanel();
	    JPanel AfScore = new JPanel();
	    JPanel pan = new JPanel();
	    JPanel pan1 = new JPanel();
	    JPanel pan3 = new JPanel();
	    

	    
	    //Définition de sa couleur de fond	    
	    pan1.setBackground(bleu1);	          
	    pan3.setBackground(bleu3);   
	    

	    
		pan.setLayout(new FlowLayout());
		pan.setBackground(Color.white);
	    pan1.setLayout(null);
	    
	    
	    this.add(pan);
	    this.add(message);
	    this.add(AfScore);
	    this.add(pan3);    
	    pan.add(titre);
	    
    	JLabel msgVic = null;	        
        Font f1 = new Font("Courier", Font.BOLD, 15);
        
        // Test de victoire ou défaite et affiche un message en conséquence
	    if (vic){
	    	msgVic = new JLabel("Vous avez gagné !!!!");	 
			new Logger().log(Logger.DEBUG, "Victoire");

	    }else{
	    	
	    	msgVic = new JLabel("Vous avez perdu !!!");
			new Logger().log(Logger.DEBUG, "Perdu");

	    }
	    
	    
	    msgVic.setFont(f1);
	    
	    // Affichage du score en le recupérant sur model
	    JLabel msgScore = new JLabel("Votre Score" + jeu.getScore());  

	    // Création des boutons d'actions
	    JButton boutonN = new JButton("Menu");
	    boutonN.setForeground(Color.MAGENTA);
	    boutonN.addActionListener(new FermerFenetreListener(this,jeu));
	    

	    JButton boutonQ = new JButton("Quitter");
	    boutonQ.setForeground(Color.RED);
	    boutonQ.addActionListener(new FermerFenetrePListener(this));
	    
	  	// Disposition des éléments de la fenêtre.   
	    pan1.setLayout(new GridBagLayout());
	    
	    message.add(msgVic);
	    AfScore.add(msgScore);
	    pan3.add(boutonN);
	    pan3.add(boutonQ);
	    

	    
	    
	    
	    // Rend la fenêtre visible
	    this.setVisible(true);
	    
	    
		}
	


}

