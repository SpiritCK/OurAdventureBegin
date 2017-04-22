package map;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*;

/**
 * kelas untuk objek finish di map.
 */
public class Finish extends Cell {
	/**
	 * constructor.
	 * @throws IOException file gagal dibuka.
	 */
	public Finish() throws IOException {
		BufferedImage x = ImageIO.read(new File("finish.png"));
		tile = x;
	}
}
