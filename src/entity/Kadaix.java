package entity;

import java.io.*;

public class Kadaix extends Virtumon{
	public Kadaix(int x, int y) throws IOException{
		super("Kadaix", 250, 140, 90, x, y, 4);
		tile = kadaix;
	}
}
