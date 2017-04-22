package map;

import java.awt.*;

/**
 * Kelas astrak untuk objek-objek yang ada di map.
 */
public abstract class Cell {
	/**
	 * gambar objek.
	 */
	Image tile;
	
	/**
	 * mengembalikan gambar objek.
	 * @return gambar objek
	 */
	public Image render() {
		return tile;
	}
}
