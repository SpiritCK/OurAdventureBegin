package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Oddchu extends Virtumon{
	public Oddchu(int x, int y) throws IOException{
		super("Oddchu", 70, 35, 20, x, y, 1);
		BufferedImage X = ImageIO.read(new File("oddchu.png"));
		tile = X;
	}
}
