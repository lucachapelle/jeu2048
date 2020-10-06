package controlleur;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import package2048.Jeu2048;
import vue.menuFrame;
import vue.scoreFrame;

public class scoreActionListner implements ActionListener {
	private JFrame f;
	private Jeu2048 jeu;
	
	
	// Constructeur
	public scoreActionListner(JFrame f,Jeu2048 jeu){
		this.f=f;
		this.jeu = jeu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// On ferme la fenêtre et on ouvre la fenêtre du score.		
		f.dispose();
		Logger.log(Logger.DEBUG, "Fenetre score");
	   	int bestscore = 0;
			File f = new File("score");
			try {
				BufferedReader bw = new BufferedReader(new FileReader(f));
				bestscore = Integer.parseInt(bw.readLine());
				bw.close();
			}catch (IOException e1) {
				System.err.println("Error");			
			}
			jeu.setBestScore(bestscore);
		new scoreFrame(jeu);


	}
}
