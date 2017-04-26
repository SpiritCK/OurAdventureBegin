package entity;

import java.io.*;

public class Pindrill extends Virtumon{
	public Pindrill(int x, int y) throws IOException{
		super("Pindrill", 180, 100, 80, x, y, 3);
		score = 9;
		tile = pindrill;
	}
}
