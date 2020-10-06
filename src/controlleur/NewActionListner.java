package controlleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package2048.Jeu2048;

public class NewActionListner implements ActionListener {
	private Jeu2048 jeu;
	
	// Constructeur
	public NewActionListner(Jeu2048 jeu) {
		this.jeu=jeu;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// On initialise la grille de jeu.
		jeu.nouveauJeu();
		jeu.setScore(0);
		Logger.log(Logger.DEBUG, "Click sur \"Recommencer la patie\" ");
	}

}
