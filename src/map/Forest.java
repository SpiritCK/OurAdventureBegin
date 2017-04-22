package map;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*;

/**
 * Kelas untuk objek hutan dalam map.
 */
public class Forest extends Cell {
	/**
	 * constructor.
	 * @throws IOException file gagal dibuka.
	 */
	public Forest() throws IOException {
		BufferedImage x = ImageIO.read(new File("forest.png"));
		tile = x;
	}
}
