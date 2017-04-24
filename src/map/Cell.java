package map;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Kelas astrak untuk objek-objek yang ada di map.
 */
public abstract class Cell {
	static Image door;
	static Image finish;
	static Image forest;
	static Image river;
	static Image road;
	static boolean rendered = false;
	/**
	 * gambar objek.
	 */
	Image tile;
	
	public Cell() throws IOException {
		if (!rendered) {
			rendered = true;
			BufferedImage a = ImageIO.read(new File("door.png"));
			door = a;
			BufferedImage b = ImageIO.read(new File("finish.png"));
			finish = b;
			BufferedImage c = ImageIO.read(new File("forest.png"));
			forest = c;
			BufferedImage d = ImageIO.read(new File("river.png"));
			river = d;
			BufferedImage e = ImageIO.read(new File("road.png"));
			road = e;
		}
	}
	
	/**
	 * mengembalikan gambar objek.
	 * @return gambar objek
	 */
	public Image render() {
		return tile;
	}
}