package entity;

import java.io.*;

public class Weehorn extends Virtumon{
	public Weehorn(int x, int y) throws IOException{
		super("Weehorn", 500, 100, 200, x, y, 4);
		tile = weehorn;
	}
}
