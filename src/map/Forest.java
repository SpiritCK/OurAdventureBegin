package map;

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
		tile = forest;
	}
}
