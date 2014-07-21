package Shapes;

import Screen.Screen;
/***
 * 
 *
 *Draws a Rhombus on the screen based on the coordinates of its tips.
 */
public class Rhombus extends BasicShape {
	
	public void draw(Screen screen, int ref, 
			Point centerGrav){
		
		Point vA = centerGrav.translate(0, -2 * ref);
		Point vB = centerGrav.translate(ref, 0);
		Point vC = centerGrav.translate(0, 2 * ref);
		Point vD = centerGrav.translate(-ref, 0);
		
		Point[] startPoints = {vA, vB, vC, vD};
		Point[] endPoints = {vB, vC, vD, vA};
		
		screen.drawMultipleLinesOnScreen(startPoints,
				endPoints, 'R');
		
	}
}
