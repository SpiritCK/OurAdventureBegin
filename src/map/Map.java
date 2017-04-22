package map;

import javax.swing.*;

import java.awt.*;
import java.io.*;
/**
 * Kelas untuk JPanel map.
 */
public class Map extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * data member MapModel.
	 */
	MapModel model;
	/**
	 * Posisi absis (kolom) player.
	 */
	int posX;
	/**
	 * posisi ordinat (baris) player.
	 */
	int posY;
	/**
	 * lebar map yang dirender.
	 */
	int renderWidth = 17;
	/**
	 * tinggi map yang dirender.
	 */
	int renderHeight = 11;

	/**
	 * constructor.
	 * @param file yang berisi map.
	 * @throws IOException jika file gagal dibuka.
	 */
    public Map(File filename) throws IOException {
    	super();
    	model = new MapModel(filename);
		posX = 0;
		posY = 2;
		setPreferredSize(new Dimension(model.GRID_WIDTH*renderWidth, model.GRID_HEIGHT*renderHeight));
		new MapController(this);
    }
    
    @Override
    /**
     * Menampilkan isi panel.
     */
    public void paintComponent(Graphics g) {
        // Important to call super class method
        super.paintComponent(g);
        // Clear the board
        g.clearRect(0, 0, getWidth(), getHeight());
        // Draw the grid
        int rectWidth = model.GRID_WIDTH;
        int rectHeight = model.GRID_HEIGHT;

        int startY = 0;
    	int startX = 0;
        if (posY >= renderHeight/2 && posY < (model.NUM_ROWS - renderHeight/2)) {
        	startY = posY - renderHeight/2;
        }
        else {
        	if (posY < renderHeight/2) {
        		startY = 0;
        	}
        	else {
        		startY = model.NUM_ROWS - renderHeight;
        	}
        }
        for (int i = startY; i < startY + renderHeight; i++) {
            if (posX >= renderWidth/2 && posX < (model.NUM_COLS - renderWidth/2)) {
            	startX = posX - renderWidth/2;
            }
            else {
            	if (posX < renderWidth/2) {
            		startX = 0;
            	}
            	else {
            		startX = model.NUM_COLS - renderWidth;
            	}
            }
            for (int j = startX; j < startX + renderWidth; j++) {
                // Upper left corner of this terrain rect
                int x = (j - startX) * rectWidth;
                int y = (i - startY) * rectHeight;
                Image terrainImage = model.terrainGrid[i][j].render().getScaledInstance(rectWidth, rectHeight, Image.SCALE_DEFAULT);
                g.drawImage(terrainImage, x, y, this);
            }
        }
        g.fillRect((posX - startX)*rectWidth, (posY - startY)*rectHeight, rectWidth, rectHeight);
    }
    
    /**
     * mengubah posisi absis (kolom) pemain.
     * @param inc true jika bergerak ke kanan. false jika bergerak ke kiri
     */
    public void IncrementX(boolean inc) {
		System.out.println("X "+inc+" "+posX+" "+model.NUM_COLS);
		if (inc && (posX < model.NUM_COLS-1)) {
	    	String classXp = model.terrainGrid[posY][posX+1].getClass().getSimpleName();
	    	System.out.println("inc "+classXp);
	    	if (classXp.equals("Road") || classXp.equals("Door") || classXp.equals("Finish")) {
	    		posX++;
				System.out.println("addX");
	    	}
		}
		else if (!inc && (posX > 0)) {
	    	String classXm = model.terrainGrid[posY][posX-1].getClass().getSimpleName();
	    	System.out.println("dec "+classXm);
	    	if (classXm.equals("Road") || classXm.equals("Door") || classXm.equals("Finish")) {
	    		posX--;
				System.out.println("decX");
	    	}
		}
	}
	/**
     * mengubah posisi ordinat (baris) pemain.
     * @param inc true jika bergerak ke bawah. false jika bergerak ke atas.
     */
	public void IncrementY(boolean inc) {
		System.out.println("Y "+inc+" "+posY+" "+model.NUM_ROWS);
		if (inc && (posY < model.NUM_ROWS-1)) {
	    	String classYp = model.terrainGrid[posY+1][posX].getClass().getSimpleName();
	    	System.out.println("inc "+classYp);
	    	if (classYp.equals("Road") || classYp.equals("Door") || classYp.equals("Finish")) {
				posY++;
				System.out.println("addY");
			}
		}
		else if (!inc && (posY > 0)) {
	    	String classYm = model.terrainGrid[posY-1][posX].getClass().getSimpleName();
	    	System.out.println("dec "+classYm);
	    	if (classYm.equals("Road") || classYm.equals("Door") || classYm.equals("Finish")) {
	    		posY--;
				System.out.println("decY");
	    	}
		}
	}
}