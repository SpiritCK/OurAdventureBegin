package entity;

import java.io.*;

public class Kadaix extends Virtumon{
	public Kadaix(int x, int y) throws IOException{
		super("Kadaix", 320, 110, 90, x, y, 4);
		tile = kadaix;
	}
}
