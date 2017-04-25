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
	/**
	 * gambar untuk kelas Door
	 */
	static Image door;
	/**
	 * gambar untuk kelas Finish
	 */
	static Image finish;
	/**
	 * gambar untuk kelas Forest
	 */
	static Image forest;
	/**
	 * gambar untuk kelas River
	 */
	static Image river;
	/**
	 * gambar untuk kelas Road
	 */
	static Image road;
	/**
	 * penanda apakah static data member sudah dibuat
	 */
	static boolean rendered = false;
	/**
	 * gambar objek.
	 */
	Image tile;
	
	/**
	 * Constructor.
	 * @throws IOException
	 */
	public Cell() throws IOException {
		if (!rendered) {

	    	System.out.println("    lalala");
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