package map;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*;

/**
 * Kelas untuk objek jalan di map.
 */
public class Road extends Cell {
	/**
	 * constructor.
	 * @throws IOException file gagal dibuka.
	 */
	public Road() throws IOException {
		BufferedImage x = ImageIO.read(new File("road.png"));
		tile = x;
	}
}
