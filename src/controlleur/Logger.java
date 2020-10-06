package controlleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Logger {
	private int level;
	private PrintWriter flot;
	public final static int ALL = 0;  
	public final static int DEBUG = 100;
	public final static int INFO = 500;
	public final static int IMPORTANT = 900;
	public final static int OFF = Integer.MAX_VALUE;

	
	
	public static Logger LOGGER = null;
	

	

	public Logger(int level, PrintWriter flot){
		this.level = level;
		this.flot = new PrintWriter(flot);
	}
	public Logger(){
		this.level = Logger.DEBUG;
		this.flot = new PrintWriter(System.err) ;
	}
	
	public Logger (String s) {
		File f = new File(s);
		String ligne = null;
		PrintWriter flo = null;
		int niv = Integer.MAX_VALUE;
		try {
			BufferedReader bw = new BufferedReader(new FileReader(f));
			ligne = bw.readLine();
			bw.close();
		}catch (IOException e1) {
			System.err.println("Error");			
		}
		int a = ligne.indexOf(" ");
		String var = ligne.substring(0 , a);
	
		switch (var)
		{
		  case "ALL":
		    niv =0;
		    break;    
		  case "DEBUG":
			    niv =100;
			    break;  
		  case "INFO":
			    niv =500;
			    break;  
		  case "IMPORTANT":
			    niv =900;
			    break;
		  default:
			  niv = Integer.MAX_VALUE  ;

		}
		String file2 = ligne.substring(a+1,ligne.length());
		
		switch (file2)
		{
		  case "System.err":
			flo =new PrintWriter(System.err);
		    break;    
		  case "System.out":
			flo =new PrintWriter(System.out);
		    break;    
		  default:
			  try {
				flo =new PrintWriter(file2);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		}

		Logger.init(niv,flo);

	}
	
	public static void init(int level, PrintWriter flot) {
		LOGGER = new Logger(level, flot);
	}
	
	public void nlog (int level, String message){
		if(this.level <= level){
			this.flot.println(message);
			this.flot.flush();
		}
	}
	
	public static void log (int level , String m) {
		LOGGER.nlog(level, m);
	}
	

}
