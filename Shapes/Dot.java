package Shapes;

import Screen.Screen;
/***
 * 
 * The class draws the DOT_SYMBOL on the screen.
 */
public class Dot extends BasicShape {
	
	public void draw(Screen screen, int ref, 
			Point centerGrav){
		
		screen.drawLineOnScreen(centerGrav, centerGrav, 'P');	
		
	}
}
