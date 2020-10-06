package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;

import package2048.Jeu2048;
import vue.jeuFrame;

public class recupjeuActionListner implements ActionListener {
	private JFrame f;
	private Jeu2048 jeu;
	
	public recupjeuActionListner(JFrame f,Jeu2048 jeu) {		
		this.f=f;
		this.jeu = jeu;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Jeu2048 j = new Jeu2048();		
		
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sauvegarde"));
			j = (Jeu2048) ois.readObject();
		   	int bestscore = 0;
			File f1 = new File("score");
			try {
				BufferedReader bw = new BufferedReader(new FileReader(f1));
				bestscore = Integer.parseInt(bw.readLine());
				bw.close();
				j.setBestScore(bestscore);
			}catch (IOException e1) {
				System.err.println("Error");			
			}
			
			Logger.log(Logger.DEBUG, "Charge la sauvgarde");

			new jeuFrame(j); 
			f.dispose();
			
			
//			BufferedReader br = new BufferedReader(new FileReader(file));
//			String ligne;
//			ligne = br.readLine();
//			System.out.println(ligne);
//			int score = Integer.parseInt(ligne);
//			j.setBestScore( score );
		
		}catch(IOException e2){
			System.err.println("Erreur !");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
