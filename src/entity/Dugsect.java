package entity;

import java.io.*;

public class Dugsect extends Virtumon{
	public Dugsect(int x, int y) throws IOException{
		super("Dugsect", 150, 60, 60, x, y, 2);
		score = 3;
		tile = dugsect;
	}
}
