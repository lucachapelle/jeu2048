package vue;
import java.awt.*;


import package2048.Jeu2048;

public class JeuCanvas extends Canvas {
	
	private static final long serialVersionUID = 1L;
	private Jeu2048 jeu;
	
	public JeuCanvas(Jeu2048 jeu) {
		this.jeu = jeu;
	}
	
	public void paint (Graphics g){
		

		g.setColor(Color.black);
		
		// Variables qui definissent la largeur du canevas
		int col = jeu.getNbCols();
		int lig = jeu.getNbLignes();
		
		int y = 10;
		g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 40));
		
		for (int i = 0; i < lig; i++ ){
			int x =10;
			for (int j = 0; j < col; j++ ){
				int[][] couleur = jeu.getGrilleInt();
				if (couleur[i][j]==0) {
				      g.setColor(new Color(200,200,200));

				}else {
					  if (couleur[i][j]<64) {
						  g.setColor(new Color(0,255-(int) ( Math.log(couleur[i][j])/( Math.log(2)) *23 ),(int) ( Math.log(couleur[i][j])/( Math.log(2)) *23 ) ));

					  }
					  else {
					      
					      g.setColor(new Color(255-(int) ( Math.log(couleur[i][j])/( Math.log(2)) *23 ),0,(int) ( Math.log(couleur[i][j])/( Math.log(2)) *23 ) ));

					  }
				}	  

				g.fillRect(x, y, 90,90);
				g.setColor(Color.white);
				if (couleur[i][j] != 0){
					if (couleur[i][j] < 100) {
						g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 40));
						g.drawString(""+couleur[i][j], x+30, y+60);

					}
					else {
						g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 30));
						g.drawString(""+couleur[i][j], x+20, y+55);
					}
						
					}

				x += 100;
			}
			y +=100;
				
		}
		
	}

}
