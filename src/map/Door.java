package map;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*;

/**
 * Kelas untuk objek pintu di map.
 */
public class Door extends Cell{
	/**
	 * constructor.
	 * @throws IOException file gagal dibuka.
	 */
	public Door() throws IOException {
		BufferedImage x = ImageIO.read(new File("door.png"));
		tile = x;
	}
}
