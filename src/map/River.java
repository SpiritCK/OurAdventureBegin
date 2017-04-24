package map;

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
		tile = river;
	}
}
