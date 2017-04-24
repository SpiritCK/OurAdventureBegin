package map;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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

    /**
     * constructor
     * @param nama file yang berisi data map.
     * @throws IOException jika gagal membuka file.
     */
    public MapModel(File filename) throws IOException {
    	Scanner in = new Scanner(filename);
    	System.out.println("    1");
    	NUM_ROWS = in.nextInt();
    	System.out.println("    2");
    	NUM_COLS = in.nextInt();
    	System.out.println("    3");
    	GRID_WIDTH = in.nextInt();
    	System.out.println("    4");
    	GRID_HEIGHT = in.nextInt();
    	System.out.println("    5");
        terrainGrid = new Cell[NUM_ROWS][NUM_COLS];
    	System.out.println("    6");
        test = new Belra(4,2);
    	System.out.println("    7");
        
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
    }

}
