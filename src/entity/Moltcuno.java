package entity;

import java.io.*;

public class Moltcuno extends Virtumon{
	public Moltcuno(int x, int y) throws IOException{
		super("Moltcuno", 490, 310, 200, x, y, 5);
		score = 50;
		tile = moltcuno;
	}
}