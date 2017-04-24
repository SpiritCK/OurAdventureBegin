package map;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.Vector;

import entity.*;

/**
 * kelas model untuk map.
 */
public class MapModel{
	/**
	 * jumlah baris dari map.
	 */
	int NUM_ROWS;
	/**
	 * jumlah kolom dari map.
	 */
	int NUM_COLS;
	/**
	 * tinggi dari gambar yang dirender.
	 */
	int GRID_WIDTH;
	/**
	 * lebar dari gambar yang dirender
	 */
	int GRID_HEIGHT;
	/**
	 * matriks untuk menyimpan objek-objek yang ada dalam map
	 */
    final Cell[][] terrainGrid;
    
    Virtumon test;
    
    Vector<Virtumon> arrayOfVirtumonAtas;
    Vector<Virtumon> arrayOfVirtumonBawah;

    private boolean isExist(int x, int y, Vector<Virtumon> tabel){
    	boolean found = false;
    	int indexVector = 0;
    	if(!tabel.isEmpty()){
    		while(indexVector<tabel.size() && !found){
    			if(tabel.get(indexVector).getX() == x && tabel.get(indexVector).getY() == y){
    				found = true;
    			}
    			else{
    				indexVector++;
    			}
    		}
    	}
    	
    	return found;
    }
    
    private void randomVirtumonPosition() throws IOException{
    	int x;
    	int y;
    	int penentuJenisVirtumon;
    	
    	arrayOfVirtumonAtas = new Vector<Virtumon>();
    	
    	for(int i = 0; i<120; i++){
	    	Random rand = new Random();
	    	x = rand.nextInt(399);
	    	y = rand.nextInt(200);
	    	
	    	while(!((x!=0 || y!=0) && terrainGrid[y][x].getClass().getSimpleName().equals("Road") && !isExist(x, y, arrayOfVirtumonAtas))){
	    		x = rand.nextInt(399);
	    		y = rand.nextInt(200);
	    	}
	    	
	    	penentuJenisVirtumon = rand.nextInt(6) + 1;
	    	
	    	switch (penentuJenisVirtumon){
	    	case 1 :
	    		Belra b = new Belra(x, y);
	    		arrayOfVirtumonAtas.add(b);
	    		break;
	    	case 2 :
	    		Charwak c = new Charwak(x, y);
	    		arrayOfVirtumonAtas.add(c);
	    		break;
	    	case 3 :
	    		Dugsect d = new Dugsect(x, y);
	    		arrayOfVirtumonAtas.add(d);
	    		break;
	    	case 4 :
	    		Kingbat k = new Kingbat(x, y);
	    		arrayOfVirtumonAtas.add(k);
	    		break;
	    	case 5 :
	    		Oddchu o = new Oddchu(x, y);
	    		arrayOfVirtumonAtas.add(o);
	    	default :
	    		Ratung r = new Ratung(x, y);
	    		arrayOfVirtumonAtas.add(r);
	    	}
    	}
    }
    
    /**
     * constructor
     * @param nama file yang berisi data map.
     * @throws IOException jika gagal membuka file.
     */
    public MapModel(File filename) throws IOException {
    	Scanner in = new Scanner(filename);
    	NUM_ROWS = in.nextInt();
    	NUM_COLS = in.nextInt();
    	GRID_WIDTH = in.nextInt();
    	GRID_HEIGHT = in.nextInt();
        terrainGrid = new Cell[NUM_ROWS][NUM_COLS];
        test = new Pindrill(2,3);
        
        // Randomize the terrain
        String c;
        for (int i = 0; i < NUM_ROWS; i++) {
            c = in.next();
            for (int j = 0; j < NUM_COLS; j++) {
	           	switch(c.charAt(j)) {
	           	case 'D' :
	           		terrainGrid[i][j] = new Door();
	           		break;
	           	case 'f' :
	           		terrainGrid[i][j] = new Finish();
	           		break;
	           	case 'F' :
	           		terrainGrid[i][j] = new Forest();
	           		break;
	           	case 'R' :
	           		terrainGrid[i][j] = new River();
            		break;
	           	default :
	           		terrainGrid[i][j] = new Road();
	           	}
            }
        }
        in.close();
        
        randomVirtumonPosition();
    }

}
