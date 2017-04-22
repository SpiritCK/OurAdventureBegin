package virtumon;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Ratung extends Virtumon{
	public Ratung(int x, int y) throws IOException{
		super("Ratung", 120, 40, 20, x, y, 2);
		BufferedImage X = ImageIO.read(new File("ratung.png"));
		tile = X;
	}
}
