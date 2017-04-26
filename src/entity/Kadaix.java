package entity;

import java.io.*;

public class Kadaix extends Virtumon{
	public Kadaix(int x, int y) throws IOException{
		super("Kadaix", 320, 120, 190, x, y, 4);
		score = 15;
		tile = kadaix;
	}
}
