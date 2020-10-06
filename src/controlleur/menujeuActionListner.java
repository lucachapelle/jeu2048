package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import package2048.Jeu2048;
import vue.menuJeuFrame;

public class menujeuActionListner implements ActionListener {
	private JFrame f;
	private Jeu2048 jeu;
	
	// Constructeur
	public menujeuActionListner(JFrame f,Jeu2048 jeu){
		this.f=f;
		this.jeu = jeu;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// On ferme la fenêtre et on ouvre la fenêtre de configuration de la grille.
		this.f.dispose();
		Logger.log(Logger.DEBUG, "Click sur \"Nouvelle Partie\" ");

		new menuJeuFrame(jeu);

	}

}
