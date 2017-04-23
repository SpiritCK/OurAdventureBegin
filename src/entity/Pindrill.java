package entity;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Pindrill extends Virtumon{
	public Pindrill(int x, int y) throws IOException{
		super("Pindrill", 200, 70, 50, x, y, 3);
		BufferedImage X = ImageIO.read(new File("pindrill.png"));
		tile = X;
	}
}
