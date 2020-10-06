package controlleur;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import package2048.Jeu2048;
import vue.jeuFrame;
import vue.menuFrame;

public class JeuActionListner implements ActionListener {
	
	// Classe qui permet de définir la grille de jeu, en choisissant le nombre 
	// de colonnes et de lignes puis le score à atteindre.
	
	private JComboBox nblignes;
	private JComboBox nbCols;
	private JComboBox  nbBut;
	private JFrame f;
	private Jeu2048 jeu;

	// Constructeur
	public JeuActionListner(JComboBox combo1, JComboBox combo2, JComboBox combo3,JFrame f,Jeu2048 jeu){
		this.f=f;
		this.nblignes = combo1;
		this.nbCols = combo2;
		this.nbBut = combo3;
		this.jeu = jeu;

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Récupération des choix du joueur. 
    	int bestscore = 0;
		File f = new File("score");
		try {
			BufferedReader bw = new BufferedReader(new FileReader(f));
			bestscore = Integer.parseInt(bw.readLine());
			bw.close();
		}catch (IOException e1) {
			System.err.println("Error");			
		}
		int lignes = Integer.parseInt((String) nblignes.getSelectedItem());
		int Cols = Integer.parseInt((String) nbCols.getSelectedItem());;
		int But = Integer.parseInt((String) nbBut.getSelectedItem());;	    


		
	// Test d'une nouvelle partie (Supprimant le meilleur score) ou non(Gardant le le meilleur score
		
	// Si oui, demande de confirmation
//	        if(!newP) {
//	    		JOptionPane jop = new JOptionPane();      
//
//		        int option = JOptionPane.showConfirmDialog(null, 
//
//		          "Etes vous sur de recrer une partie \n" + 
//		          "cela va supprimer le score", 
//
//		          "Lancement de l'animation", 
//
//		          JOptionPane.YES_NO_OPTION, 
//
//		          JOptionPane.QUESTION_MESSAGE);
//		        
//		        // Si il y'a confirmation, on lance le jeu avec les données recuperées.
//		        if(option == JOptionPane.OK_OPTION){
//		        	Jeu2048 jeu = new Jeu2048(lignes,Cols,But);
//		        	new jeuFrame(jeu);
//
//	        	}
//		        // Si non, on retourne sur le menu.
//	        	else {
//	        		new menuFrame(jeu);
//	        	}
//    
//	        }
//	        // Si on garde le score, on lance le jeu avec les anciennes donneés.
//	        else {
				Logger.log(Logger.DEBUG, "Click sur \"jouer\". ");
				Logger.log(Logger.DEBUG, " Nouveau jeu. NbCols : "+ jeu.getNbCols() +", NbLignes : "+ jeu.getNbLignes() + ", But à attenindre : "+ jeu.getNbBut());
	        	Jeu2048 jeu = new Jeu2048(lignes,Cols,But);


				jeu.setBestScore(bestscore);
	        	new jeuFrame(jeu);
//}
	     
	    // On ferme la fenêtre
		this.f.dispose();

		
	}

}
