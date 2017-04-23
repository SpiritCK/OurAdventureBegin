package entity;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Weehorn extends Virtumon{
	public Weehorn(int x, int y) throws IOException{
		super("Weehorn", 390, 100, 170, x, y, 4);
		BufferedImage X = ImageIO.read(new File("weehorn.png"));
		tile = X;
	}
}
