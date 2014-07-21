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
 *Processes the projectile ChainShot, in a similar way with CanisterShot.
 */
public class ChainShot extends Projectile{
	
	public ChainShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	public void shoot(int dist, Point shooterPosition) {
	
		//vedem in ce se transforma proiectilul cand atinge ecranul
		int d4 = 42 + (4 * 4 * currentTime.getH() + 4 * currentTime.getM() +
						currentTime.getS()) % 42;
		
		int d5 = 42 + (5 * 5 * currentTime.getH() + 5 * currentTime.getM() +
				currentTime.getS()) % 42;
		
		int d7 = 42 + (7 * 7 * currentTime.getH() + 7 * currentTime.getM() +
				currentTime.getS()) % 42;
		
		
		int id = 0;
		
		if (dist < d4)
			id = 4;
		
		if (dist >= d4 && (dist - d4) < d5 )
			id = 5;
		
		if (dist >= d4 + d5 && (dist - d4 - d5) < d7 )
			id = 7;
		
		if (dist - d4 - d5 - d7 >= 0 )
			id = 8;
		//pastreaza indicele proiectilului care va lovi ecranul
		
		//calculez deplasarea proiectilului pe masura ce inainteaza
		if (id == 4) {
			
			shooterPosition.trans(0, -dist);
			
			shapeChangingDist = -dist/10 - 4;
			
			shape = new Triangle();
			
		}
		
		if (id == 5) {
			
			shooterPosition.trans(0, -d4);
			shooterPosition.trans((int)Math.round(Math.sin((dist - d4) * Math.PI / 2)), 0);
			
			shapeChangingDist = -d4/10 - 4 + (-(dist - d4) / 10 - 5);
			
			shape = new Square();
			
		}
		
		if (id == 7) {
			
			shooterPosition.trans(0, -d4);
			shooterPosition.trans((int)Math.round(Math.sin(d5 * Math.PI / 2)), 0);
			shooterPosition.trans((int)Math.round(Math.sin((dist-d4-d5) * Math.PI / 2)),
					(int)Math.round(Math.cos((dist-d4-d5) * Math.PI / 2)));
			
			shapeChangingDist = -d4/10 - 4 + (-d5/10 - 5) + (-(dist - d4 - d5)/10 - 7);
			
			shape = new Rectangle();
			
		}
		
		if (id == 8) {
			shooterPosition.trans(0, -d4);
			shooterPosition.trans((int)Math.round(Math.sin(d5 * Math.PI / 2)), 0);
			shooterPosition.trans((int)Math.round(Math.sin(d7 * Math.PI / 2)),
					(int)Math.round(Math.cos(d7 * Math.PI / 2)));
			
			shapeChangingDist = -d4/10 - 4 + (-d5/10 - 5) +
								(-d7/10 - 7);
			
			shape = new Dot();
			
		}
		
		
		
	}
	
	
	public void hitScreenAction(Point shooterPosition, int ref){
		
		ref = ref + shapeChangingDist;
		
		Point centerGrav = shooterPosition;
		
		shape.draw(screen, ref, centerGrav);
		
	}
	
}

