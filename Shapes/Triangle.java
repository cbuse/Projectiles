package Shapes;

import Screen.Screen;
/***
 * 
 *
 *Draws a Triangle on the screen based on the coordinates of its tips.
 */
public class Triangle extends BasicShape{
	
	public void draw(Screen screen, int ref, 
			Point centerGrav){
		
		Point v1 = centerGrav.translate(0, -2*ref);
		Point v2 = centerGrav.translate(ref, ref);
		Point v3 = centerGrav.translate(-ref, ref);
		
		Point[] startPoints = {v1, v1, v2};
		Point[] endPoints = {v3, v2, v3};
		
		screen.drawMultipleLinesOnScreen(startPoints,
				endPoints, 'T');
		
	}
}
