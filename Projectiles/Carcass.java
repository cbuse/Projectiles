package Projectiles;


import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Dot;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Rhombus;
import Shapes.Square;

/***
 * 
 * @author Cristina
 *
 *Processes the projectile Carcass, in a similar way with CanisterShot.
 */
public class Carcass extends Projectile{
	
	public Carcass(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	public void shoot(int dist, Point shooterPosition) {
	
		int d2 = 42 + (2 * 2 * currentTime.getH() + 2 * currentTime.getM() +
						currentTime.getS()) % 42;
		
		int d6 = 42 + (6 * 6 * currentTime.getH() + 6 * currentTime.getM() +
				currentTime.getS()) % 42;
		
		int d7 = 42 + (7 * 7 * currentTime.getH() + 7 * currentTime.getM() +
				currentTime.getS()) % 42;
		
		int id = 0;
		
		
		if (dist < d2)
			id = 2;
		
		if (dist >= d2 && (dist - d2) < d6 )
			id = 6;
		
		if (dist >= d2 + d6 && (dist - d2 - d6) < d7 )
			id = 7;
		
		if (dist - d2 - d6 - d7 >= 0 )
			id = 8;
		
		
		if (id == 2) {
			
			shooterPosition.trans(0, dist);
			
			shapeChangingDist = -dist / 10 - 2;
			
			shape = new Square(); 
			
		}
		
		if (id == 6) {
			
			shooterPosition.trans(0, d2);			
			shooterPosition.trans(0, (int)Math.round(Math.cos((dist-d2) * Math.PI / 2)));
			
			
			shapeChangingDist = -d2 / 10 - 2 + (-(dist - d2) / 10 - 6);			

			shape = new Rhombus();
		}
		
		
		if (id == 7) {
			
			shooterPosition.trans(0, d2);
			shooterPosition.trans(0, (int)Math.round(Math.cos(d6 * Math.PI / 2)));
			shooterPosition.trans((int)Math.round(Math.sin((dist - d2 - d6) * Math.PI / 2)),
					(int)Math.round(Math.cos((dist - d2 - d6) * Math.PI / 2)));
			
			shapeChangingDist = -d2 / 10 - 2 + (-d6 / 10 - 6) + (-(dist - d2 - d6) / 10 - 7);
						
			shape = new Rectangle();
			
		}
		
		if (id == 8) {
			
			shooterPosition.trans(0, d2);			
			shooterPosition.trans(0, (int)Math.round(Math.cos(d6 * Math.PI / 2)));
			shooterPosition.trans((int)Math.round(Math.sin(d7 * Math.PI / 2)),
					(int)Math.round(Math.cos(d7 * Math.PI / 2)));
			
			shapeChangingDist = -d2 / 10 - 2 + (-d6 / 10 - 6) + 
					(-d7 / 10 - 7);
			
			
			shape = new Dot();
			
		}		
	}
	
	
	
	public void hitScreenAction(Point shooterPosition, int ref){
		
		ref = ref + shapeChangingDist;
				
		Point centerGrav = shooterPosition;
		
		shape.draw(screen, ref, centerGrav);
		
	}
	
}

