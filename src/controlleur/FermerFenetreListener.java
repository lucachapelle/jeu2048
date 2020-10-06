package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JFrame;

import package2048.Jeu2048;
import vue.menuFrame;

public class FermerFenetreListener implements ActionListener {
	private JFrame f;
	private Jeu2048 jeu;
	
	// Constructeur
	public FermerFenetreListener(JFrame f,Jeu2048 jeu){
		this.f=f;
		this.jeu = jeu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Ferme la fenêtre et ouvre la fenêtre du menu.
		f.dispose();
		int bestscore = 0;

		Logger.log(Logger.DEBUG, "Click sur \"menu \"");
		new menuFrame(jeu);
		
		File f = new File("score");
		
		try {
			BufferedReader bw = new BufferedReader(new FileReader(f));
			bestscore = Integer.parseInt(bw.readLine());
			bw.close();
		}catch (IOException e1) {
			System.err.println("Error");			
		}
		if (jeu.getBestScore() > bestscore) {
			try {
				String score = Integer.toString(jeu.getBestScore());
				BufferedWriter bv = new BufferedWriter(new FileWriter(f));
				bv.write(score);
				bv.close();			
			}catch (IOException e1) {
				System.err.println("Error");			
			}
		}


	}

}
