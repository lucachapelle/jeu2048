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
import controlleur.menujeuActionListner;
import package2048.Jeu2048;

public class scoreFrame extends JFrame {

	//Affiche le meilleur score
	
	private static final long serialVersionUID = 1L;
	Color bleu1= new Color(0, 255, 255);
	Color bleu2= new Color(0, 255, 200);
	Color bleu3= new Color(0, 255, 150);
	private int LARGEUR=200;
	private int HAUTEUR=300;
	private Jeu2048 jeu;

	
	public scoreFrame(Jeu2048 jeu){
    this.setTitle("Score");
    this.setSize(LARGEUR, HAUTEUR);
    
    //Place la fenêtre au centre de l'ecran.
    this.setLocationRelativeTo(null);
    
    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    
    //Empêcher le redimensionnement de la fenêtre
    this.setResizable(false);
    
    //Retirer les contours et les boutons de contrôle
    this.setUndecorated(false);    
    this.setLayout(new GridLayout(2, 1));

   
    JLabel titre = new JLabel("Score");
    
    Font f = new Font("Courier", Font.BOLD, 25);
    titre.setFont(f);
    
    //Création des panels.
    JPanel pan = new JPanel(new GridLayout(2, 1));
    JPanel pan1 = new JPanel();


    JLabel scoreLabel = new JLabel("Best Score : " + jeu.getBestScore());
    
    //Ajout des panels sur la frame.
    this.add(pan);
    this.add(pan1);

    pan.add(titre);
    pan.add(scoreLabel);
    
    //Création des boutons.
    JButton boutonN = new JButton("Menu");
    boutonN.setForeground(Color.MAGENTA);
    boutonN.addActionListener(new FermerFenetreListener(this,jeu));
    
    //L'objet servant à positionner les composants
    GridBagConstraints gbc = new GridBagConstraints();
    
    pan1.setLayout(new GridBagLayout());
    pan1.add(boutonN, gbc);

    //Rend la fenêtre visible.
    this.setVisible(true);
    
    
	}
}