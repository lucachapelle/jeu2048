package vue;


import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import controlleur.FermerFenetreAdapter;
import controlleur.NewActionListner;
import controlleur.ToucheListner;
import controlleur.recupjeuActionListner;
import controlleur.sauvActionListener;
import controlleur.FermerFenetreListener;
import package2048.Jeu2048;

public class jeuFrame extends JFrame implements Observer {
	
	private static final long serialVersionUID = 1L;
	
	// Initialisation de la hauteur et de la largeur de la fen�tre----------
	private int LARGEUR=200;
	private int HAUTEUR=300;
	//-----------------------------------------------------------------------
	
	private Jeu2048 jeu;
	private Canvas c;
	private JLabel scoreLabel , meilLabel;
	private boolean vic;
	boolean cree = true;
	
	public jeuFrame(Jeu2048 jeu){
	this.jeu = jeu;
	
	// 
	this.jeu.addObserver(this);
	
	// Dimensionne la fen�tre selon le nombre de case de la grille de jeu --------------
	LARGEUR = jeu.getNbCols() *105;
	if (LARGEUR <750) {
		LARGEUR = 750;

	}
	
	HAUTEUR = jeu.getNbLignes() *130;
    this.setTitle("2048");
    this.setSize(LARGEUR, HAUTEUR);
   //------------------------------------------------------------------------------------
    
    
    //position centre
    this.setLocationRelativeTo(null);
    
    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
    
    //Emp�cher le redimensionnement de la fen�tre
   // this.setResizable(false);
    
    //Retirer les contours et les boutons de contr�le
    this.setUndecorated(false);
    //---------------------------------------------------------
    
    // Cr�ation des composants de ma fen�tre : Panels, Boutons ------------
	this.setLayout(new BorderLayout());
	JPanel p = new JPanel(new FlowLayout());
	
	JButton bnew = new JButton("Recommencer la Partie");
	JButton bsauv = new JButton("Sauvegarder la Partie");
	JButton boutonQ = new JButton("Menu");
	boutonQ.setForeground(Color.RED);

    JButton boutonR = new JButton("Recup�rer");
    boutonR.addActionListener(new recupjeuActionListner(this,jeu));
	
	
	// Affichage du score et meilleur score, en les recup�rant depuis le model
	this.scoreLabel = new JLabel("Score : " + this.jeu.getScore());
	this.meilLabel = new JLabel("Meilleur Score : " + this.jeu.getBestScore());
	
	p.add(this.scoreLabel);p.add(this.meilLabel);
	
	//Cr�ation et placement du canevas
	this.c = new JeuCanvas(jeu);	
	this.add(c,BorderLayout.CENTER);
	this.add(p,BorderLayout.SOUTH);
	p.add(bsauv);
	p.add(boutonR);
	bsauv.addActionListener(new sauvActionListener(jeu));
	p.add(bnew);
	bnew.addActionListener(new NewActionListner(jeu));	   
	

    
    // Ajout du bouton sur le panel
	// Action quand on appuie sur le bouton, ici on ferme la fen�tre et on ouvre le menu. 
	p.add(boutonQ);
	boutonQ.addActionListener(new FermerFenetreListener(this,jeu));    
    //--------------------------------------------------------------------------------------
	
	
	// On cre� un controlleur pour fermer la fen�tre  
	this.addWindowListener(new FermerFenetreAdapter(this));
	
	// On cre� un controlleur pour les commandes de jeu.
	c.addKeyListener(new ToucheListner(jeu,this));
	
	// On rend la fen�tre visible.
	this.setVisible(true);

    
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		// On met � jour le canevas, le score et le meilleur score
		this.c.repaint();
		this.scoreLabel.setText("Score : " + this.jeu.getScore());
		this.meilLabel.setText("Meilleir Score : " + this.jeu.getBestScore());
		
		// On verifie si le joueur est gagnant ou perdant, on affiche en cons�quence la fen�tre
		// de fin de jeu.

		
	}
}
