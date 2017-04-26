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
	 * static data member untuk gambar medicine
	 */
	static Image medicine;
	/**
	 * sprite untuk kelas medicine.
	 */
	Image sprite;
	/**
	 * posisi sumbu x
	 */
	int absis;
	/**
	 * posisi sumbu y
	 */
	int ordinat;
	/**
	 * penanda apakah medicine sudah diambil atau belum
	 */
	boolean taken;
	/**
	 * constructor
	 * @param _x input posisi sumbu x
	 * @param _y input posisi sumbu y
	 * @throws IOException jika file gagal dibuka.
	 */
	public Medicine(int _x, int _y) throws IOException {
		if (medicine == null) {
			BufferedImage temp = ImageIO.read(new File("data/medicine.png"));
			medicine = temp;
		}
		sprite = medicine;
		absis = _x;
		ordinat = _y;
		taken = false;
	}
	/**
	 * mengeset nilai taken
	 */
	public void setTaken(boolean input){
		taken = input;
	}
	/**
	 * mengembalikkan sprite dari medicine.
	 * @return sprite.
	 */
	public Image render(){
		return sprite;
	}
	/**
	 * mengembalikan posisi sumbu x
	 * @return absis
	 */
	public int getX(){
		return absis;
	}
	/**
	 * mengembalikan posisi sumbu y
	 * @return ordinat
	 */
	public int getY(){
		return ordinat;
	}
	/**
	 * Mengembalikan nilai taken
	 */
	public boolean isTaken(){
		return taken;
	}
}