
import FileParser.FileParser;
import FileParser.WriteFile;
import ProcessingManagers.TimeManager;
import Projectiles.CanisterShot;
import Projectiles.Carcass;
import Projectiles.ChainShot;
import Projectiles.HeatedShot;
import Projectiles.Shrapnel;
import Projectiles.SimpleShell;
import Projectiles.SpiderShot;
import Projectiles.TriGrapeShot;
import Screen.Screen;
import Shapes.Point;

/***
 * 
 * @author Cristina Buse
 * 
 * The Main class processes the projectiles from a file given as an argument
 * and writes the screen into a file.
 *
 */

public class Main {

	public static void main(String[] args) {	
				
		if (args.length != 1) {
			System.err.println("Usage: java -cp <classpath> Main <text file> ");
			System.exit(1);
		}		
		
		FileParser textFile = new FileParser(args[0]);
		textFile.open();
		
		String word;
		
		//the dimension of the screen on the OX axis
		word = textFile.getNextWord();
		int ex = Integer.parseInt(word);
		
		//the dimension of the screen on the OX axis
		word = textFile.getNextWord();
		int ey = Integer.parseInt(word);
		
		//initialize the screen
		Screen screen = new Screen(ex,ey);
		
		//the number of projectiles from the input file
		word = textFile.getNextWord();
		int N = Integer.parseInt(word);
		
		
		for(int i = 0; i < N; i ++){
						
			
			String projectile = textFile.getNextWord();
		
			int ref = Integer.parseInt(textFile.getNextWord());
			
			//the time in the format hh:mm:ss
			word = textFile.getNextWord();
			
			//extract the h,m,s from time and make them Integers
			int pos1 = word.indexOf(':');			
			int h = Integer.parseInt(word.substring(0,pos1));			
			int pos2 = word.lastIndexOf(':');
			int m = Integer.parseInt(word.substring(pos1+1,pos2));
			int s = Integer.parseInt(word.substring(pos2+1));
			
			//the dtance from the screen
			int dist = Integer.parseInt(textFile.getNextWord());
			
			//the position of the shooter
			int posx = Integer.parseInt(textFile.getNextWord());
			int posy = Integer.parseInt(textFile.getNextWord());			
			
			
			//in functie de tipul proiectilului, il initializez
						
			if (projectile.equals("trigrapeshot")){
				
				//initialize the time
				TimeManager time = new TimeManager(h, m, s);
				//initialize the projectile
				TriGrapeShot tgs = new TriGrapeShot(screen,ref,time);
				//initialize the shooter's position
				Point shooterPosition = new Point(posx,posy);
				
				//the projectile is shot possibly changing its shape
				tgs.shoot(dist, shooterPosition);
				//the projectile hits the screen and leaves a trace on the screen
				tgs.hitScreenAction(shooterPosition, ref);
				
				
				
			}
			
			else if (projectile.equals("carcass")){
				
				TimeManager time = new TimeManager(h, m, s);
				
				Carcass c = new Carcass(screen,ref,time);
				
				Point shooterPosition = new Point(posx,posy);
				
				c.shoot(dist, shooterPosition);				
				c.hitScreenAction(shooterPosition, ref);
				
				
				
			}
			
			else if (projectile.equals("canistershot")){
				
				TimeManager time = new TimeManager(h, m, s);
				
				CanisterShot c = new CanisterShot(screen,ref,time);
				
				Point shooterPosition = new Point(posx,posy);
				
				c.shoot(dist, shooterPosition);
				
				c.hitScreenAction(shooterPosition, ref);
				
				
				
				
				
			}
			
			
			else if (projectile.equals("heatedshot")){
				
				TimeManager time = new TimeManager(h, m, s);
				
				HeatedShot c = new HeatedShot(screen,ref,time);
				
				Point shooterPosition = new Point(posx,posy);
				
				c.shoot(dist, shooterPosition);
				
				c.hitScreenAction(shooterPosition, ref);
				
				
				
				
				
			}
			
			else if (projectile.equals("chainshot")){
				
				TimeManager time = new TimeManager(h, m, s);
				
				ChainShot c = new ChainShot(screen,ref,time);
				
				Point shooterPosition = new Point(posx, posy);
				
				c.shoot(dist, shooterPosition);
				
				c.hitScreenAction(shooterPosition, ref);
				
				
				
				
			}
			
			else if (projectile.equals("shrapnel")){
				
				TimeManager time = new TimeManager(h, m, s);
				
				Shrapnel c = new Shrapnel(screen,ref,time);
				
				Point shooterPosition = new Point(posx,posy);
				
				c.shoot(dist, shooterPosition);
				
				c.hitScreenAction(shooterPosition, ref);
				
				
				
				
			}
			
			else if (projectile.equals("spidershot")){
				
				TimeManager time = new TimeManager(h, m, s);
				
				SpiderShot c = new SpiderShot(screen,ref,time);
				
				Point shooterPosition = new Point(posx,posy);
				
				c.shoot(dist, shooterPosition);				
				c.hitScreenAction(shooterPosition, ref);
				
				
				
			}
			
			else if (projectile.equals("simpleshell")){
				
				TimeManager time = new TimeManager(h, m, s);
				
				SimpleShell ss = new SimpleShell(screen,ref,time);
				
				Point shooterPosition = new Point(posx,posy);
				
				ss.shoot(dist, shooterPosition);				
				ss.hitScreenAction(shooterPosition, ref);
				
				
			}
			
		}
		
		
		textFile.close();
		
		//write the screen in a file
		WriteFile output = new WriteFile(args[0]+"_out");
		output.open();
		output.write(screen);
		output.close();		
	}
}
		


