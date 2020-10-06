	package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import package2048.Jeu2048;

public class FermerFenetrePListener implements ActionListener {
	private JFrame f;
	
	// Constructeur
	public FermerFenetrePListener(JFrame f){
		this.f=f;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Ferme la fenêtre.		
		f.dispose();
		Logger.log(Logger.DEBUG, "Fermeture fenetre");

		


	}

}
