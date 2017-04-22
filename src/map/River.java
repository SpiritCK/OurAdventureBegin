package map;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*;

/**
 * Kelas untuk objek sungai di map.
 */
public class River extends Cell {
	/**
	 * constructor.
	 * @throws IOException file gagal dibuka.
	 */
	public River() throws IOException {
		BufferedImage x = ImageIO.read(new File("river.png"));
		tile = x;
	}
}
