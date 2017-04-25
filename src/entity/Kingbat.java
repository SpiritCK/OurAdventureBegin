package entity;

import java.io.*;

public class Kingbat extends Virtumon{
	public Kingbat(int x, int y) throws IOException{
		super("Kingbat", 80, 45, 35, x, y, 1);
		tile = kingbat;
	}
}
