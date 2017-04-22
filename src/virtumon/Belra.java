package virtumon;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Belra extends Virtumon {
	public Belra(int x, int y) throws IOException{
		super("Belra", 110, 20, 20, x, y, 1);
		BufferedImage X = ImageIO.read(new File("belra.png"));
		tile = X;
	}
}
