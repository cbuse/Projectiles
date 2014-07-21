package Shapes;

import Screen.Screen;
/***
 * 
 *
 *Draws a Square on the screen based on the coordinates of its tips.
 */
public class Square extends BasicShape {
	
	public void draw(Screen screen, int ref, 
			Point centerGrav){
		
		Point vA = centerGrav.translate(-ref, ref);
		Point vB = centerGrav.translate(ref,  ref);
		Point vC = centerGrav.translate(ref, -ref);
		Point vD = centerGrav.translate(-ref, -ref);
		
		
		Point[] startPoints = {vA, vB, vC, vD};
		Point[] endPoints = {vB, vC, vD, vA};
		
		screen.drawMultipleLinesOnScreen(startPoints,
				endPoints, 'S');
		
	}
}
