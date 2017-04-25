package entity;

import java.io.*;

public class Dugsect extends Virtumon{
	public Dugsect(int x, int y) throws IOException{
		super("Dugsect", 120, 50, 60, x, y, 2);
		tile = dugsect;
	}
}
