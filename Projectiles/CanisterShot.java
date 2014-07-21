package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Dot;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Rhombus;

/***
 * 
 * @author Cristina
 *
 *Processes the projectile CanisterShot.
 */
public class CanisterShot extends Projectile {
	
	public CanisterShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	public void shoot(int dist, Point shooterPosition) {
	
		//compute the neessary distances for the projectile to turn into another
		int d3 = 42 + (3 * 3 * currentTime.getH() + 3 * currentTime.getM() +
						currentTime.getS()) % 42;
		
		int d6 = 42 + (6 * 6 * currentTime.getH() + 6 * currentTime.getM() +
				currentTime.getS()) % 42;
		
		int d7 = 42 + (7 * 7 * currentTime.getH() + 7 * currentTime.getM() +
				currentTime.getS()) % 42;
		
		//keep the index of the projectile which will hit the screen	
		int id = 0;
		
		if (dist < d3)
			id = 3;
		
		if (dist >= d3 && (dist - d3) < d6 )
			id = 6;
		
		if (dist >= d3 + d6 && (dist - d3 - d6) < d7 )
			id = 7;
		
		if (dist - d3 - d6 - d7 >= 0 )
			id = 8;
		
		
		//according to the projectile which hits the screen, we compute
		//the transition of the center of gravity, the shrinking of the
		//reference and initialize the shape that will be drawn on the screen
		
		if (id == 3) {
			
			shooterPosition.trans(-dist, 0);
			
			shapeChangingDist = -dist / 10 - 3;
			
			shape = new Rectangle(); 
			
			
		}
		
		if (id == 6) {
			
			shooterPosition.trans(-d3, 0);
			
			shooterPosition.trans(0, (int)Math.round(Math.cos((dist-d3) * Math.PI / 2)));
			
			
			shapeChangingDist = -d3 / 10 - 3 + (-(dist-d3) / 10 - 6);
	
			
			shape = new Rhombus();
			
			
		}
		
		if (id == 7) {
			
			shooterPosition.trans(-d3, 0);
			shooterPosition.trans(0, (int)Math.round(Math.cos(d6 * Math.PI / 2)));
			shooterPosition.trans((int)Math.round(Math.sin((dist-d3-d6) * Math.PI / 2)),
					(int)Math.round(Math.cos((dist-d3-d6) * Math.PI / 2)));
			
			
			shapeChangingDist = -d3 / 10 - 3 + (-d6 / 10 - 6) +
								(-(dist - d3 - d6) / 10 - 7);
			shape = new Rectangle();
		}
		
		if (id == 8) {
			
			shooterPosition.trans(-d3, 0);
			shooterPosition.trans(0, (int)Math.round(Math.cos(d6 * Math.PI / 2)));
			shooterPosition.trans((int)Math.round(Math.sin(d7 * Math.PI / 2)),
					(int)Math.round(Math.cos(d7 * Math.PI / 2)));
			
			
			shapeChangingDist = -d3 / 10 - 3 + (-d6 / 10 - 6) +
								(-d7 / 10 - 7);
			
			shape = new Dot();
		}
		
		
	}
	
	
	
	
	public void hitScreenAction(Point shooterPosition, int ref){
		
		//compute the new reference
		ref = ref + shapeChangingDist;
		
		Point centerGrav = shooterPosition;
		//draw the appropriate form on the screen
		shape.draw(screen, ref, centerGrav);
		
	}
	
}


