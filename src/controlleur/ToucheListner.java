package controlleur;
import java.awt.event.*;

import javax.swing.JFrame;

import package2048.Jeu2048;
import vue.FinFrame;

public class ToucheListner extends KeyAdapter {
	private Jeu2048 jeu;
	private JFrame f;
	private Jeu2048 jeu1;
	
	// Constructeur
	public ToucheListner (Jeu2048 jeu , JFrame f){
		this.jeu= jeu;
		this.f = f;
		jeu1 = jeu;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// Selon la touche pressée on appelle le model en conséquence, pour fusionner les cases.
		
		
		
		if (arg0.getKeyCode() == KeyEvent.VK_UP){
			Logger.log(Logger.DEBUG, "Décalage flèche HAUT");
			if(!jeu.decaler(Jeu2048.HAUT)) {
				Logger.log(Logger.IMPORTANT, "Décalage impossible");

			}
		}else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT){	
			Logger.log(Logger.DEBUG, "Décalage flèche DROITE");
			if(!jeu.decaler(Jeu2048.DROITE)) {
				Logger.log(Logger.IMPORTANT, "Décalage impossible");

			}
			
		}else if (arg0.getKeyCode() == KeyEvent.VK_LEFT){
			Logger.log(Logger.DEBUG, "Décalage flèche GAUCHE");
			if(!jeu.decaler(Jeu2048.GAUCHE)) {
				Logger.log(Logger.IMPORTANT, "Décalage impossible");

			}
			
		}else if (arg0.getKeyCode() == KeyEvent.VK_DOWN){
			Logger.log(Logger.DEBUG, "Décalage flèche BAS");
			if(!jeu.decaler(Jeu2048.BAS)) {
				Logger.log(Logger.IMPORTANT, "Décalage impossible");

			}


		}
		
		for(int i=0;i<jeu.getNbLignes();i++){
			for(int j =0;j<jeu.getNbCols();j++){
				if(jeu.tableauFusions()[i][j] == true){
					Logger.log(Logger.INFO, jeu.getGrilleInt()[i][j] +  " resultat d'une fusion  dans (" + i + ","+ j+")");
				}
			}
		}
		
		
		if ((jeu.estVainquer()) || (jeu.estTermine())){
			new FinFrame(jeu,(jeu.estVainquer()) || (!jeu.estTermine()));
			f.dispose();
		}
		
	}
}



