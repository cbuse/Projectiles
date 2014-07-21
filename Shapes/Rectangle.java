package Shapes;

import Screen.Screen;

/***
 * 
 * 
 *Draws a Rectangle on the screen based on the coordinates of its tips.
 */
public class Rectangle extends BasicShape {
	
	
	public void draw(Screen screen, int ref, 
			Point centerGrav){
		
		Point vA = centerGrav.translate(-2 * ref, ref);		
		Point vB = centerGrav.translate(2 *ref, ref);
		Point vC = centerGrav.translate(2 * ref, -ref);
		Point vD = centerGrav.translate(-2 * ref, -ref);
		
		
		Point[] startPoints = {vA, vB, vC, vD};
		Point[] endPoints = {vB, vC, vD, vA};
		
		screen.drawMultipleLinesOnScreen(startPoints,
				endPoints, 'D');
		
	}
}
