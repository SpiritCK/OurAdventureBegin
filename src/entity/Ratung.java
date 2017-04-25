package entity;

import java.io.*;

public class Ratung extends Virtumon{
	public Ratung(int x, int y) throws IOException{
		super("Ratung", 120, 60, 60, x, y, 2);
		tile = ratung;
	}
}
