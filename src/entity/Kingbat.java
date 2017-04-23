package entity;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Kingbat extends Virtumon{
	public Kingbat(int x, int y) throws IOException{
		super("Kingbat", 80, 20, 10, x, y, 1);
		BufferedImage X = ImageIO.read(new File("kingbat.png"));
		tile = X;
	}
}
