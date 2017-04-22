package map;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Kelas untuk objek medicine.
 */
public class Medicine {
	/**
	 * sprite untuk kelas medicine.
	 */
	Image sprite;
	/**
	 * constructor
	 * @throws IOException jika file gagal dibuka.
	 */
	public Medicine() throws IOException {
		BufferedImage x = ImageIO.read(new File("medicine.png"));
		sprite = x;
	}
	/**
	 * mengembalikkan sprite dari medicine.
	 * @return sprite.
	 */
	public Image render(){
		return sprite;
	}
}
