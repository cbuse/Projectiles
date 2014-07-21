package Projectiles;


import Screen.Screen;
import Shapes.Dot;
import Shapes.Point;
import ProcessingManagers.TimeManager;
/***
 * 
 * @author Cristina
 *
 *Processes the projectile SimpleShell, in a similar way with CanisterShot.
 */
public class SimpleShell extends Projectile{
	
	public SimpleShell(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	public void shoot(int dist, Point shooterPosition) {

		shape = new Dot();
	}
	
	
	public void hitScreenAction(Point shooterPosition, int ref){
		
		Point centerGrav = shooterPosition;
		
		shape.draw(screen, ref, centerGrav);
		
	}
	
	
	
}
