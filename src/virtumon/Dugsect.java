package virtumon;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Dugsect extends Virtumon{
	public Dugsect(int x, int y) throws IOException{
		super("Dugsect", 150, 40, 30, x, y, 2);
		BufferedImage X = ImageIO.read(new File("dugsect.png"));
		tile = X;
	}
}
