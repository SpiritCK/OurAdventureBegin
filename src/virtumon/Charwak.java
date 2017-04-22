package virtumon;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Charwak extends Virtumon {
	public Charwak(int x, int y) throws IOException{
		super("Charwak", 100, 30, 10, x, y, 1);
		BufferedImage X = ImageIO.read(new File("charwak.png"));
		tile = X;
	}
}
