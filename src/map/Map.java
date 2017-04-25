package map;

import javax.swing.*;

import entity.Player;
import entity.Virtumon;

import java.awt.*;
import java.io.*;
import java.util.Random;
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
	final int renderWidth = 19;
	/**
	 * tinggi map yang dirender.
	 */
	final int renderHeight = 13;
	/**
	 * jarak dari tempat render dimana thread masih diproses
	 */
	final int threadProcessingRange = 20;

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
		battleStatus = -1;
		model.spawnVirtumon();
		startThread();
    }
    
    /**
     * method untuk mengulang permainan
     * @throws IOException 
     */
    public void refresh() throws IOException {
		battleStatus = -1;
		player.refresh();
		player.setX(0);
		player.setY(2);
		player.setState(2);
		model.spawnVirtumon();
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
        for (int i = 0; i < model.arrayOfVirtumon.size(); i++) {
        	int tempX = model.arrayOfVirtumon.get(i).getX();
        	int tempY = model.arrayOfVirtumon.get(i).getY();
        	if (model.arrayOfVirtumon.get(i).isAlive() && tempX >=startX && tempX < startX + renderWidth && tempY>=startY && tempY<startY+renderHeight ) {
        		Image p = model.arrayOfVirtumon.get(i).render().getScaledInstance(rectWidth, rectHeight, Image.SCALE_DEFAULT);
                g.drawImage(p, (model.arrayOfVirtumon.get(i).getX() - startX)*rectWidth, (model.arrayOfVirtumon.get(i).getY() - startY)*rectHeight, this);
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
			getBattle(player.getX(), player.getY());
			if (battleStatus != -1) {
				player.setX(player.getX()-1);
			}
		}
		else {
			player.setState(1);
			getBattle(player.getX(), player.getY());
			if (battleStatus != -1) {
				player.setX(player.getX()+1);
			}
		}
		startThread();
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
			getBattle(player.getX(), player.getY());
			if (battleStatus != -1) {
				player.setY(player.getY()-1);
			}
		}
		else {
			player.setState(3);
			getBattle(player.getX(), player.getY());
			if (battleStatus != -1) {
				player.setY(player.getY()+1);
			}
		}
		startThread();
		//isBattle();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Virtumon getVirtumon(int i) {
		return model.arrayOfVirtumon.get(i);
	}
	
	public void getBattle(int x, int y) {
		boolean found = false;
		int index = 0;
		while(!found && index<model.arrayOfVirtumon.size()){
			if(model.arrayOfVirtumon.get(index).getX() == x && model.arrayOfVirtumon.get(index).getY() == y && model.arrayOfVirtumon.get(index).isAlive()){
				found = true;
			}
			else{
				index++;
			}
		}
		
		if(found){
			battleStatus = index;
		}
		
	}
	
	public int getBattle() {
		return battleStatus;
	}
	
	public void battleConfirmed(int result) {
		if (result == 1) {
			model.arrayOfVirtumon.get(battleStatus).kill();
		}
		battleStatus = -1;
	}
	
	public Cell[][] getTerrain(){
		return model.terrainGrid;
	}
	
	public int getNumRows(){
		return model.NUM_ROWS;
	}
	
	public int getNumCols(){
		return model.NUM_COLS;
	}
	
	public void setNama(String s) {
		player.setName(s);
	}
	
	public void startThread(){
		int startX,startY,endX,endY;
		startX = player.getX() - ((renderWidth - 1) / 2) - threadProcessingRange;
		if(startX < 0){
			startX = 0;
		}
		startY = player.getY() - ((renderHeight - 1) / 2) - threadProcessingRange;
		if(startY < 0){
			startY = 0;
		}
		endX = player.getX() + ((renderWidth - 1) / 2) + threadProcessingRange;
		if(endX >= model.NUM_COLS){
			endX = model.NUM_COLS - 1;
		}
		endY = player.getY() + ((renderHeight - 1) / 2) + threadProcessingRange;
		if(endY >= model.NUM_ROWS){
			endY = model.NUM_ROWS - 1;
		}
		
		for(int i=0; i<model.arrayOfVirtumon.size(); i++){
			boolean inRange = getVirtumon(i).getX() >= startX && getVirtumon(i).getX() <= endX && getVirtumon(i).getY() >= startY && getVirtumon(i).getY() <= endY;
			if(!getVirtumon(i).getIsActive() && inRange && getVirtumon(i).isAlive()){
				final int index = i;
				new Thread(new Runnable(){
					final int indexVirtumon = index;

					@Override
					public void run() {
						int startX = player.getX() - ((renderWidth - 1) / 2) - threadProcessingRange;
						if(startX < 0){
							startX = 0;
						}
						int startY = player.getY() - ((renderHeight - 1) / 2) - threadProcessingRange;
						if(startY < 0){
							startY = 0;
						}
						int endX = player.getX() + ((renderWidth - 1) / 2) + threadProcessingRange;
						if(endX >= model.NUM_COLS){
							endX = model.NUM_COLS - 1;
						}
						int endY = player.getY() + ((renderHeight - 1) / 2) + threadProcessingRange;
						if(endY >= model.NUM_ROWS){
							endY = model.NUM_ROWS - 1;
						}
						getVirtumon(indexVirtumon).setIsActive(true);
						
						while(getVirtumon(indexVirtumon).getX() >= startX && getVirtumon(indexVirtumon).getX() <= endX && getVirtumon(indexVirtumon).getY() >= startY && getVirtumon(indexVirtumon).getY() <= endY && getVirtumon(indexVirtumon).isAlive()){
							while(getBattle() != -1){Thread.yield();}
							Random rand = new Random();
							try{
								Thread.sleep((rand.nextInt(5) + 1)*200);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							boolean moved = false;
							while (!moved){
								switch(rand.nextInt(4) + 1){
									case 1:
										//gerak atas
										if(getVirtumon(indexVirtumon).getY() - 1 >= 0){
											if(getTerrain()[getVirtumon(indexVirtumon).getY() - 1][getVirtumon(indexVirtumon).getX()].getClass().getSimpleName().equals("Road")){
												getVirtumon(indexVirtumon).setY(getVirtumon(indexVirtumon).getY() - 1);
												moved = true;
											}
										}
										break;
									case 2:
										//gerak bawah
										if(getVirtumon(indexVirtumon).getY() + 1 < getNumRows()){
											if(getTerrain()[getVirtumon(indexVirtumon).getY() + 1][getVirtumon(indexVirtumon).getX()].getClass().getSimpleName().equals("Road")){
												getVirtumon(indexVirtumon).setY(getVirtumon(indexVirtumon).getY() + 1);
												moved = true;
											}
										}
										break;
									case 3:
										//gerak kiri
										if(getVirtumon(indexVirtumon).getX() - 1 >= 0){
											if(getTerrain()[getVirtumon(indexVirtumon).getY()][getVirtumon(indexVirtumon).getX() - 1].getClass().getSimpleName().equals("Road")){
												getVirtumon(indexVirtumon).setX(getVirtumon(indexVirtumon).getX() - 1);
												moved = true;
											}
										}
										break;
									case 4:
										//gerak kanan
										if(getVirtumon(indexVirtumon).getX() + 1 < getNumCols()){
											if(getTerrain()[getVirtumon(indexVirtumon).getY()][getVirtumon(indexVirtumon).getX() + 1].getClass().getSimpleName().equals("Road")){
												getVirtumon(indexVirtumon).setX(getVirtumon(indexVirtumon).getX() + 1);
												moved = true;
											}
										}
										break;
								}
							}
							if(player.getX() == getVirtumon(indexVirtumon).getX() && player.getY() == getVirtumon(indexVirtumon).getY()){
								battleStatus = indexVirtumon;
							}
						}
						getVirtumon(indexVirtumon).setIsActive(false);
					}
					
				}).start();
			}
		}
	}
}