package entity;

import java.io.*;

public class Charwak extends Virtumon {
	public Charwak(int x, int y) throws IOException{
		super("Charwak", 100, 50, 50, x, y, 1);
		tile = charwak;
	}
}
