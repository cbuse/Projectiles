package FileParser;

import java.io.FileWriter;
import java.io.IOException;


import Screen.Screen;

/***
 * 
 * @author Cristina Buse
 * 
 * Opens a file for writing and writes a matrix in it.
 *
 */
public class WriteFile {
	FileWriter writer;
	String filePath;
	
	public WriteFile(String filePath) {
		this.filePath = filePath;
		this.writer = null;
		
	}
	
	public void open() {
		if (writer != null) {
			throw new IllegalStateException("File already opened for reading");
		}
		try {
			
			writer = new FileWriter(filePath);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void close() {
		
		if (writer != null) {
			try {
				writer.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public  void write(Screen screen) {

	    try {

	        for(int i = 0; i < screen.getMatrix()[0].length; i++) {
				for(int j = 0; j < screen.getMatrix().length; j++) {
					String c = screen.getMatrix()[i][j] + "";
					writer.write(c);
					writer.flush();
				}	
				writer.write('\n');
			}
	        
	        
	    } catch(IOException ex) {
	        ex.printStackTrace();
	    }	    
	}
}
