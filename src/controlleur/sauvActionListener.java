package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.print.DocFlavor.STRING;

import package2048.Jeu2048;

public class sauvActionListener implements ActionListener {
	private Jeu2048 jeu;
	
	public sauvActionListener(Jeu2048 jeu){
		this.jeu = jeu;

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		
		try{			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sauvegarde"));
			oos.writeObject(jeu);
			Logger.log(Logger.DEBUG, "Click sur \"Sauvegarder la partie\"");

			oos.close();	
			
			
//			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
//			String best = Integer.toString(jeu.getBestScore());
//			bw.write(best);
//			bw.close();
		}catch(IOException e1){
			System.err.println("Erreur!");
		}
	}

}
