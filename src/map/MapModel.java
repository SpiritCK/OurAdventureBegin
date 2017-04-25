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
    /**
     * list virtumon yang tertangkap
     */
    Vector<Virtumon> arrayOfVirtumon;

    /**
     * mengecek pakah ada virtumon pada posisi x,y
     * @param x posisi absis
     * @param y posisi ordinat
     * @param tabel list virtumon
     * @return true jika ada, false jika tidak
     */
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
    
    /**
     * method untuk memunculkan virtumon pada map
     * @throws IOException
     */
    void spawnVirtumon() throws IOException{
    	int x;
    	int y;
    	int penentuJenisVirtumon;
    	
    	arrayOfVirtumon = new Vector<Virtumon>();
    	
    	for(int i = 0; i<500; i++){
	    	Random rand = new Random();
	    	x = rand.nextInt(399);
	    	y = rand.nextInt(399);
	    	
	    	while(!((x!=0 || y!=0) && terrainGrid[y][x].getClass().getSimpleName().equals("Road") && !isExist(x, y, arrayOfVirtumon))){
	    		x = rand.nextInt(399);
	    		y = rand.nextInt(399);
	    	}
	    	if(y<=200){
		    	penentuJenisVirtumon = rand.nextInt(6) + 1;
		    	
		    	switch (penentuJenisVirtumon){
		    	case 1 :
		    		Belra b = new Belra(x, y);
		    		arrayOfVirtumon.add(b);
		    		break;
		    	case 2 :
		    		Charwak c = new Charwak(x, y);
		    		arrayOfVirtumon.add(c);
		    		break;
		    	case 3 :
		    		Dugsect d = new Dugsect(x, y);
		    		arrayOfVirtumon.add(d);
		    		break;
		    	case 4 :
		    		Kingbat k = new Kingbat(x, y);
		    		arrayOfVirtumon.add(k);
		    		break;
		    	case 5 :
		    		Oddchu o = new Oddchu(x, y);
		    		arrayOfVirtumon.add(o);
		    		break;
		    	default :
		    		Ratung r = new Ratung(x, y);
		    		arrayOfVirtumon.add(r);
		    	}
	    	}
	    	else{
	    		penentuJenisVirtumon = rand.nextInt(4) + 1;
	    		
	    		switch(penentuJenisVirtumon){
	    		case 1 :
	    			Kadaix k = new Kadaix(x, y);
	    			arrayOfVirtumon.add(k);
	    			break;
	    		case 2 :
	    			Moltcuno m = new Moltcuno(x, y);
	    			arrayOfVirtumon.add(m);
	    			break;
	    		case 3 :
	    			Pindrill p = new Pindrill(x, y);
	    			arrayOfVirtumon.add(p);
	    			break;
	    		default :
	    			Weehorn w = new Weehorn(x, y);
	    			arrayOfVirtumon.add(w);
	    		}
	    	}
    	}
    }
    
    /**
     * constructor
     * @param nama file yang berisi data map.
     * @throws IOException jika gagal membuka file.
     */
    public MapModel(File filename) throws IOException {
    	boolean check = filename != null;
    	assert check;
    	Scanner in = new Scanner(filename);
    	NUM_ROWS = in.nextInt();
    	NUM_COLS = in.nextInt();
    	GRID_WIDTH = in.nextInt();
    	GRID_HEIGHT = in.nextInt();
        terrainGrid = new Cell[NUM_ROWS][NUM_COLS];
        
        // Randomize the terrain
        String c;
        for (int i = 0; i < NUM_ROWS; i++) {
            c = in.next();
            System.out.println(i+" : "+c);
            for (int j = 0; j < NUM_COLS; j++) {
                System.out.println("    "+j+" : "+c.charAt(j));
                if(c.charAt(j) == '-') {
                	System.out.println("    ok");
                }
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
	           	case '-' :
	           		terrainGrid[i][j] = new Road();
	           		break;
	           	default :
	           		assert false;
	           	}
            }
        }
        in.close();
    	arrayOfVirtumon = new Vector<Virtumon>();
    }

}
