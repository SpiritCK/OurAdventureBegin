package entity;

import java.io.*;

public class Moltres extends Virtumon{
	public Moltres(int x, int y) throws IOException{
		super("Moltres", 490, 310, 200, x, y, 5);
		tile = moltcuno;
	}
}