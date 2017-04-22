package virtumon;


import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Kadaix extends Virtumon{
	public Kadaix(int x, int y) throws IOException{
		super("Kadaix", 320, 110, 90, x, y, 4);
		BufferedImage X = ImageIO.read(new File("kadaix.png"));
		tile = X;
	}
}
