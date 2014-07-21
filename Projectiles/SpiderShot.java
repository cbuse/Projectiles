package Projectiles;


import Screen.Screen;
import Shapes.Dot;
import Shapes.Point;
import Shapes.Rectangle;
import ProcessingManagers.TimeManager;
/***
 * 
 * @author Cristina
 *
 *Processes the projectile SpiderShot, in a similar way with CanisterShot.
 */
public class SpiderShot extends Projectile{
	
	public SpiderShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	public void shoot(int dist, Point shooterPosition) {
	
		int d7 = 42 + (7 * 7 * currentTime.getH() + 7 * currentTime.getM() +
				currentTime.getS()) % 42;
		
		
		int id = 0;
		
		if (dist < d7)
			id = 7;	
			
		if (dist - d7 >= 0 )
			id = 8;
		
		
		if (id == 7) {
			
			shooterPosition.trans((int)Math.round(Math.sin(dist * Math.PI / 2)),
					(int)Math.round(Math.cos(dist * Math.PI / 2)));
			
			shapeChangingDist = -dist / 10 - 7;
			
			shape = new Rectangle();
			
		}
		
		if (id == 8) {
			
			shooterPosition.trans((int)Math.round(Math.sin(d7 * Math.PI / 2)),
					(int)Math.round(Math.cos(d7 * Math.PI / 2)));
			
			
			shapeChangingDist = -d7 / 10 - 8;
			
			shape = new Dot();
		}
		
		
		
	}
	
	
	
	
	public void hitScreenAction(Point shooterPosition, int ref){
		
		ref = ref + shapeChangingDist;
		
		Point centerGrav = shooterPosition;		
		
		shape.draw(screen, ref, centerGrav);
		
	}
	
}
