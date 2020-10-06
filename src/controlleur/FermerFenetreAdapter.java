package controlleur;
import java.awt.*;
import java.awt.event.*;

public class FermerFenetreAdapter extends WindowAdapter {
	
	//Ferme la fen�tre lorsque qu'on clique surla croix.
	
	private Frame f;
	
	// Constructeur 
	public FermerFenetreAdapter(Frame f){
		this.f=f;
		
	}
	
	@Override
	public void windowClosing(WindowEvent arg0){
		// Ferme la fen�tre.
		this.f.dispose();
		Logger.log(Logger.DEBUG, "Fermeture fenetre");

	}
	

}
