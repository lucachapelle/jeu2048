import java.io.PrintWriter;

import controlleur.Logger;
import package2048.Jeu2048;
import vue.menuFrame;


public class Main {

	public static void main(String[] args) {
		Jeu2048 jeu = new Jeu2048();
		Logger lo = new Logger("config.txt");
	    new menuFrame(jeu);
	    
	}

}
