package map;

import javax.swing.*;

import entity.Player;
import entity.Virtumon;

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
	 * data member MapController.
	 */
	MapController control;
	/**
	 * data member player.
	 */
	Player player;
	/**
	 * status battle
	 */
	int battleStatus;
	/**
	 * lebar map yang dirender.
	 */
	final int renderWidth = 17;
	/**
	 * tinggi map yang dirender.
	 */
	final int renderHeight = 11;

	/**
	 * constructor.
	 * @param file yang berisi map.
	 * @throws IOException jika file gagal dibuka.
	 */
    public Map(File filename, Player p) throws IOException {
    	super();
    	model = new MapModel(filename);
    	player = p;
		p.setX(0);
		p.setY(2);
		p.setState(2);
		setPreferredSize(new Dimension(model.GRID_WIDTH*renderWidth, model.GRID_HEIGHT*renderHeight));
		control = new MapController(this);
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
        if (player.getY() >= renderHeight/2 && player.getY() < (model.NUM_ROWS - renderHeight/2)) {
        	startY = player.getY() - renderHeight/2;
        }
        else {
        	if (player.getY() < renderHeight/2) {
        		startY = 0;
        	}
        	else {
        		startY = model.NUM_ROWS - renderHeight;
        	}
        }
        for (int i = startY; i < startY + renderHeight; i++) {
            if (player.getX() >= renderWidth/2 && player.getX() < (model.NUM_COLS - renderWidth/2)) {
            	startX = player.getX() - renderWidth/2;
            }
            else {
            	if (player.getX() < renderWidth/2) {
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
        for (int i = 0; i < model.arrayOfVirtumonAtas.size(); i++) {
        	int tempX = model.arrayOfVirtumonAtas.get(i).getX();
        	int tempY = model.arrayOfVirtumonAtas.get(i).getY();
        	if (model.arrayOfVirtumonAtas.get(i).isAlive() && tempX >=startX && tempX < startX + renderWidth && tempY>=startY && tempY<startY+renderHeight ) {
        		Image p = model.arrayOfVirtumonAtas.get(i).render().getScaledInstance(rectWidth, rectHeight, Image.SCALE_DEFAULT);
                g.drawImage(p, (model.arrayOfVirtumonAtas.get(i).getX() - startX)*rectWidth, (model.arrayOfVirtumonAtas.get(i).getY() - startY)*rectHeight, this);
        	}
        }
        Image p = player.getSprite().getScaledInstance(rectWidth, rectHeight, Image.SCALE_DEFAULT);
        g.drawImage(p, (player.getX() - startX)*rectWidth, (player.getY() - startY)*rectHeight, this);
        //p = model.test.render().getScaledInstance(rectWidth, rectHeight, Image.SCALE_DEFAULT);
        //g.drawImage(p, (model.test.getX() - startX)*rectWidth, (model.test.getY() - startY)*rectHeight, this);
    }
    
    /**
     * mengubah posisi absis (kolom) pemain.
     * @param inc true jika bergerak ke kanan. false jika bergerak ke kiri
     */
    public void IncrementX(boolean inc) {
		System.out.println("X "+inc+" "+player.getX()+" "+model.NUM_COLS);
		if (inc && (player.getX() < model.NUM_COLS-1)) {
	    	String classXp = model.terrainGrid[player.getY()][player.getX()+1].getClass().getSimpleName();
	    	System.out.println("inc "+classXp);
	    	if (classXp.equals("Road") || classXp.equals("Door") || classXp.equals("Finish")) {
	    		player.setX(player.getX()+1);
				System.out.println("addX");
	    	}
		}
		else if (!inc && (player.getX() > 0)) {
	    	String classXm = model.terrainGrid[player.getY()][player.getX()-1].getClass().getSimpleName();
	    	System.out.println("dec "+classXm);
	    	if (classXm.equals("Road") || classXm.equals("Door") || classXm.equals("Finish")) {
	    		player.setX(player.getX()-1);
				System.out.println("decX");
	    	}
		}
		if (inc) {
			player.setState(2);
		}
		else {
			player.setState(1);
		}
		//isBattle();
	}
	/**
     * mengubah posisi ordinat (baris) pemain.
     * @param inc true jika bergerak ke bawah. false jika bergerak ke atas.
     */
	public void IncrementY(boolean inc) {
		System.out.println("Y "+inc+" "+player.getY()+" "+model.NUM_ROWS);
		if (inc && (player.getY() < model.NUM_ROWS-1)) {
	    	String classYp = model.terrainGrid[player.getY()+1][player.getX()].getClass().getSimpleName();
	    	System.out.println("inc "+classYp);
	    	if (classYp.equals("Road") || classYp.equals("Door") || classYp.equals("Finish")) {
	    		player.setY(player.getY()+1);
				System.out.println("addY");
			}
		}
		else if (!inc && (player.getY() > 0)) {
	    	String classYm = model.terrainGrid[player.getY()-1][player.getX()].getClass().getSimpleName();
	    	System.out.println("dec "+classYm);
	    	if (classYm.equals("Road") || classYm.equals("Door") || classYm.equals("Finish")) {
	    		player.setY(player.getY()-1);
				System.out.println("decY");
	    	}
		}
		if (inc) {
			player.setState(0);
		}
		else {
			player.setState(3);
		}
		//isBattle();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Virtumon getVirtumon() {
		return model.test;
	}
	
	public boolean isBattle(int x, int y) {
		return (x == model.test.getX() && y == model.test.getY());
	}
	
	public boolean isBattle() {
		return (player.getX() == model.test.getX() && player.getY() == model.test.getY());
	}
}