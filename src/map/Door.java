package map;

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
		tile = door;
	}
}
