package vue;

import java.awt.Color;
//import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import controlleur.FermerFenetreListener;
import controlleur.JeuActionListner;
import package2048.Jeu2048;
public class menuJeuFrame extends JFrame{
	// Fenêtre qui permet de configurer la grille de jeu et le score à atteindre.
	
	
	private static final long serialVersionUID = 1L;
	private int LARGEUR=300;
	private int HAUTEUR=400;
	private Jeu2048 jeu;

	
	public menuJeuFrame(Jeu2048 jeu){
		
    this.setTitle("Menu-Jeu");
    this.setSize(LARGEUR, HAUTEUR);
    
    //Place la fenêtre au centre de l'ecran.
    this.setLocationRelativeTo(null);
    
    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
    
    //Empêcher le redimensionnement de la fenêtre
    this.setResizable(false);
    
    //Retirer les contours et les boutons de contrôle
    this.setUndecorated(false);
    
    this.setLayout(new GridLayout(4, 1));
    JLabel titre = new JLabel("JEU 2048");
    Font f = new Font("Courier", Font.BOLD, 25);
    titre.setFont(f);
    
    //Création des panels.
    JPanel pan = new JPanel();
    JPanel pan1 = new JPanel();
    JPanel pan2 = new JPanel();
    JPanel pan3 = new JPanel();
    
    // On les ajoute à la frame.
    this.add(pan);this.add(pan1);this.add(pan2);this.add(pan3);
    
    //Choix du nombre de lignes de la grille.
    JLabel labelLignes = new JLabel("selectionner le nb de lignes");
    String[] tab1 = {"2","3","4","5","6"};

    JComboBox combo1 = new JComboBox(tab1);
    combo1.setSelectedItem("4");
    pan.add(labelLignes);pan.add(combo1);
    
    //Choix du nombre de colonnes.
    JLabel labelColonnes = new JLabel("selectionner le nb de colonnes");
    String[] tab2 = {"2","3","4","5","6"};
    JComboBox combo2 = new JComboBox(tab2);
    combo2.setSelectedItem("4");
    
    pan1.add(labelColonnes);pan1.add(combo2);

    
    //Choix du score à atteindre.
    JLabel labelBut = new JLabel("selectionner le score a atteindre");
    String[] tab3 = { "4", "8","16","32","64","128","256","512","1024","2048"};
    JComboBox combo3 = new JComboBox(tab3);
    combo3.setSelectedItem("2048");

    pan2.add(labelBut);pan2.add(combo3);

    // Création des boutons.
    JButton boutonJ = new JButton("Jouer");
    boutonJ.setForeground(Color.MAGENTA);
    boutonJ.addActionListener(new JeuActionListner(combo1,combo2, combo3,this,jeu));
    
    JButton boutonQ = new JButton("Menu");
    boutonQ.setForeground(Color.RED);
    boutonQ.addActionListener(new FermerFenetreListener(this,jeu));
    
    //L'objet servant à positionner les composants

    pan3.add(boutonJ);
    pan3.add(boutonQ);
    
    
    // Rend la fenêtre visile.
    this.setVisible(true);
    
    
	}
}
