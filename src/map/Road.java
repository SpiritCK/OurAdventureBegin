package map;

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
		tile = road;
	}
}
