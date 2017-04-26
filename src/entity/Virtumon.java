package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Virtumon extends Entity {
	/**
	 * data gambar untuk Belra
	 */
	static Image belra;
	/**
	 * data gambar untuk Charwak
	 */
	static Image charwak;
	/**
	 * data gambar untuk Dugsect
	 */
	static Image dugsect;
	/**
	 * data gambar untuk Kadaix
	 */
	static Image kadaix;
	/**
	 * data gambar untuk Kingbat
	 */
	static Image kingbat;
	/**
	 * data gambar untuk Moltcuno
	 */
	static Image moltcuno;
	/**
	 * data gambar untuk Oddchu
	 */
	static Image oddchu;
	/**
	 * data gambar untuk Pindrill
	 */
	static Image pindrill;
	/**
	 * data gambar untuk Ratung
	 */
	static Image ratung;
	/**
	 * data gambar untuk Weehorn
	 */
	static Image weehorn;
	/**
	 * penanda apakah static data member sudah diisi
	 */
	static boolean rendered = false;
	/**
	 * nama virtumon
	 */
	String nama;
	/**
	 * damage virtumon
	 */
	int damage;
	/**
	 * defense virtumon
	 */
	int defense;
	/**
	 * posisi absis virtumon
	 */
	int absis;
	/**
	 * posisi ordinat virtumon
	 */
	int ordinat;
	/**
	 * level virtumon
	 */
	int level;
	/**
	 * penanda apakah virtumon hidup
	 */
	boolean alive;
	/**
	 * gambar virtumon
	 */
	Image tile;
	/**
	 * penanda apakah virtumon sedang berjalan
	 */
	boolean isActive;
	/**
	 * score yang didapat jika virtumon kalah
	 */
	int score;
	
	/**
	 * Constructor class
	 * @param _nama nama dari virtumon
	 * @param _maxHp hp maksimum dari virtumon
	 * @param _damage damage untuk mengurangi hp musuh
	 * @param _defense defense untuk mengurangi damage yang masuk
	 * @param _absis koordinat sumbu-X
	 * @param _ordinat koordinat sumbu-Y
	 * @param _level level dari virtumon
	 * @throws IOException 
	 */
	public Virtumon(String _nama, int _maxHp, int _damage, int _defense, int _absis, int _ordinat, int _level) throws IOException{
		nama = _nama;
		maxHp = _maxHp;
		hp = maxHp;
		damage = _damage;
		defense = _defense;
		absis = _absis;
		ordinat = _ordinat;
		level = _level;
		alive = true;
		if (!rendered) {
			rendered = true;
			BufferedImage a = ImageIO.read(new File("data/belra.png"));
			belra = a;
			BufferedImage b = ImageIO.read(new File("data/charwak.png"));
			charwak = b;
			BufferedImage c = ImageIO.read(new File("data/dugsect.png"));
			dugsect = c;
			BufferedImage d = ImageIO.read(new File("data/kadaix.png"));
			kadaix = d;
			BufferedImage e = ImageIO.read(new File("data/kingbat.png"));
			kingbat = e;
			BufferedImage f = ImageIO.read(new File("data/moltcuno.png"));
			moltcuno = f;
			BufferedImage g = ImageIO.read(new File("data/oddchu.png"));
			oddchu = g;
			BufferedImage h = ImageIO.read(new File("data/pindrill.png"));
			pindrill = h;
			BufferedImage i = ImageIO.read(new File("data/ratung.png"));
			ratung = i;
			BufferedImage j = ImageIO.read(new File("data/weehorn.png"));
			weehorn = j;
		}
		isActive = false;
	}
	
	/**
	 * getter isAlive
	 * @returnisAlive
	 */
	public boolean isAlive(){
		return alive;
	}
	/**
	 * method untuk membunuh virtumon
	 */
	public void kill() {
		alive = false;
	}
	/**
	 * getter level
	 * @return level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * fungsi untuk mendapatkan nama virtumon
	 * @return nama
	 */
	public String getNama(){
		return nama;
	}
	
	/**
	 * fungsi untk mendapatkan damage
	 * @return damage
	 */
	public int getDamage(){
		return damage;
	}
	
	/**
	 * fungsi untuk mendapatkan defense
	 * @return defense
	 */
	public int getDefense(){
		return defense;
	}
	
	/**
	 * fungsi untuk mendapatkan absis
	 * @return absis
	 */
	public int getX(){
		return absis;
	}
	
	/**
	 * fungsi untuk mendapatkan ordinat
	 * @return ordinat
	 */
	public int getY(){
		return ordinat;
	}
	/**
	 * mengembalikan true jika status thread active
	 * @return status thread
	 */
	public boolean getIsActive(){
		return isActive;
	}
	
	/**
	 * fungsi untuk mengubah absis
	 * @param _absis
	 */
	public void setX(int _absis){
		absis = _absis;
	}
	
	/**
	 * fungsi untuk mengubah ordinat
	 * @param _ordinat
	 */
	public void setY(int _ordinat){
		ordinat = _ordinat;
	}
	/**
	 * getter gambar virtumon
	 * @return tile
	 */
	public Image render(){
		return tile;
	}
	/**
	 * setter isAlive
	 * @param input kondisi hidup virtumon
	 */
	public void setAlive(boolean input){
		alive = input;
	}

	/**
	 * setter isActive
	 * @param isActive kondisi aktif virtumon
	 */
	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}
	
	/**
	 * getter score
	 * @return score
	 */
	public int getScore() {
		return score;
	}
}
