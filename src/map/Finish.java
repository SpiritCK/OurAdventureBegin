package map;

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
		tile = finish;
	}
}
