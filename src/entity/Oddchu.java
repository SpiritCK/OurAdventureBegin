package entity;

import java.io.IOException;

public class Oddchu extends Virtumon{
	public Oddchu(int x, int y) throws IOException{
		super("Oddchu", 70, 40, 35, x, y, 1);
		tile = oddchu;
	}
}
