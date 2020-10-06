package vue;


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
import controlleur.recupjeuActionListner;
import controlleur.scoreActionListner;
import package2048.Jeu2048;

public class menuFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Color bleu1= new Color(0, 255, 255);
	Color bleu2= new Color(0, 255, 200);
	Color bleu3= new Color(0, 255, 150);
	
	// Initialisation de la largeur et de hauteur de la fenêtre.-----------
	private int LARGEUR=200;
	private int HAUTEUR=300;	
	//---------------------------------------------------------------------
	
	private Jeu2048 jeu;

	
	public menuFrame(Jeu2048 jeu){
    this.setTitle("Menu");
    this.setSize(LARGEUR, HAUTEUR);

    //Place la fenêtre au centre de l'ecran.
    this.setLocationRelativeTo(null);
    
    //Termine le processus lorsqu'on clique sur la croix rouge.
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    
    //Empêcher le redimensionnement de la fenêtre.
    this.setResizable(false);
    
    //Retirer les contours et les boutons de contrôle.
    this.setUndecorated(false);
    
    // Definis le nombre de composants du menu selon si c'est une nouvelle partie.-----------------------
        this.setLayout(new GridLayout(5, 1));
    //-----------------------------------------------------------------------------------------------------
    
    JLabel titre = new JLabel("JEU 2048");
    Font f = new Font("Courier", Font.BOLD, 25);
    titre.setFont(f);
    
    // Declaration des panel de la frame.
    JPanel pan = new JPanel();
    JPanel pan1 = new JPanel();
    JPanel pan2 = new JPanel();
    JPanel pan3 = new JPanel();
    JPanel pan4 = new JPanel();
    
   
    
    

    //Définition de sa couleur de fond.
    pan1.setBackground(bleu1);
    pan3.setBackground(bleu2);        
    pan4.setBackground(bleu3);   
   

    
	pan.setLayout(new FlowLayout());
	pan.setBackground(Color.white);
    pan1.setLayout(null);
    this.add(pan);
    this.add(pan1);

    
    // Ajoute un panel si ce n'est pas une nouvelle partie.-----------------------------------
        this.add(pan2); 
    //----------------------------------------------------------------------------------------
    this.add(pan3); 
    this.add(pan4);    
    pan.add(titre);
    
    // Création des boutons.
    JButton boutonN = new JButton("Nouvelle Partie");
    boutonN.setForeground(Color.MAGENTA);
    boutonN.addActionListener(new menujeuActionListner(this,jeu));    
    
    JButton boutonR = new JButton("Charger");
    boutonR.setForeground(Color.MAGENTA);
    boutonR.addActionListener(new recupjeuActionListner(this,jeu));
    
    JButton boutonS = new JButton("Score");
    boutonS.setForeground(Color.ORANGE);
    boutonS.addActionListener(new scoreActionListner(this,jeu));
    
    JButton boutonQ = new JButton("Quitter");
    boutonQ.setForeground(Color.RED);
    boutonQ.addActionListener(new FermerFenetrePListener(this));
    
    //L'objet servant à positionner les composants.
    GridBagConstraints gbc = new GridBagConstraints();
    
    //Ajout des boutons au panel.
    pan1.setLayout(new GridBagLayout());
    pan1.add(boutonN, gbc);
    pan2.add(boutonR, gbc);


    pan3.setLayout(new GridBagLayout());
    pan3.add(boutonS, gbc);

    pan4.setLayout(new GridBagLayout());
    pan4.add(boutonQ, gbc);
    
    
    
    //Rend la fenêtre visible.
    this.setVisible(true);
    
    
	}
}
