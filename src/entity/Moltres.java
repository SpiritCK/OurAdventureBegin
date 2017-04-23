package entity;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Moltres extends Virtumon{
	public Moltres(int x, int y) throws IOException{
		super("Moltres", 490, 310, 200, x, y, 5);
		BufferedImage X = ImageIO.read(new File("moltres.png"));
		tile = X;
	}
}