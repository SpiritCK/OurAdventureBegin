package entity;

import java.io.*;

public class Belra extends Virtumon {
	public Belra(int x, int y) throws IOException{
		super("Belra", 110, 50, 50, x, y, 1);
		score = 2;
		tile = belra;
	}
}
