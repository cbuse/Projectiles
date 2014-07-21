package Projectiles;


import Screen.Screen;
import Shapes.Dot;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Square;
import ProcessingManagers.TimeManager;
import Shapes.Triangle;
/***
 * 
 * @author Cristina
 *
 *Processes the projectile TriGrapeShot, in a similar way with CanisterShot.
 */
public class TriGrapeShot extends Projectile{
	
	public TriGrapeShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	public void shoot(int dist, Point shooterPosition) {
	
		
		int d1 = 42 + (1 * 1 * currentTime.getH() + 1 * currentTime.getM() +
						currentTime.getS()) % 42;
		
		int d5 = 42 + (5 * 5 * currentTime.getH() + 5 * currentTime.getM() +
				currentTime.getS()) % 42;
		
		int d7 = 42 + (7 * 7 * currentTime.getH() + 7 * currentTime.getM() +
				currentTime.getS()) % 42;
		
		
		
		int id = 0;
		
		if (dist < d1)
			id = 1;
		
		if (dist >= d1 && (dist - d1) < d5 )
			id = 5;
		
		if (dist >= d1 + d5 && (dist - d1 - d5) < d7 )
			id = 7;
		
		if (dist - d1 - d5 - d7 >= 0 )
			id = 8;
		
		
		if (id == 1) {
			
			shooterPosition.trans(dist, 0);
			
			shapeChangingDist = -dist / 10 - 1;
			
			shape = new Triangle(); 
			
		}
		
		
		if (id == 5) {
			
			shooterPosition.trans(d1, 0);			
			shooterPosition.trans((int)Math.round(Math.sin((dist-d1) * Math.PI / 2)), 0);
			
			
			shapeChangingDist = -d1 / 10 - 1 + (-(dist - d1) / 10 - 5) ;
			
			shape = new Square();
		}
		
		
		if (id == 7) {
			
			shooterPosition.trans(d1, 0);			
			shooterPosition.trans((int)Math.round(Math.sin(d5 * Math.PI / 2)), 0);			
			shooterPosition.trans((int)Math.round(Math.sin((dist - d1 -d5) * Math.PI / 2)),
					(int)Math.round(Math.cos((dist - d1 -d5) * Math.PI / 2)));
			
			shapeChangingDist = -d1 / 10 - 1 + (-d5 / 10 - 5) +
								(-(dist - d1 - d5) / 10 - 7);	
			
			shape = new Rectangle();
			
		}
		
		if (id == 8) {
			
			
			shooterPosition.trans(d1, 0);			
			shooterPosition.trans((int)Math.round(Math.sin(d5 * Math.PI / 2)), 0);			
			shooterPosition.trans((int)Math.round(Math.sin(d7 * Math.PI / 2)),
					(int)Math.round(Math.cos(d7 * Math.PI / 2)));
			
			shapeChangingDist = -d1 / 10 - 1 + (-d5 / 10 - 5) + (-d7 / 10 - 7);
			
			
			shape = new Dot();
		}	
		
	}
	
	
	
		public void hitScreenAction(Point shooterPosition, int ref){		
		
		ref = ref + shapeChangingDist;
		
		Point centerGrav = shooterPosition;
				
		shape.draw(screen, ref, centerGrav);
		
	}
	
}
