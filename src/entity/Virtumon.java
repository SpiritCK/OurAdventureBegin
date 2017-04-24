package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Virtumon extends Entity {
	static Image belra;
	static Image charwak;
	static Image dugsect;
	static Image kadaix;
	static Image kingbat;
	static Image moltcuno;
	static Image oddchu;
	static Image pindrill;
	static Image ratung;
	static Image weehorn;
	static boolean rendered = false;
	String nama;
	int damage;
	int defense;
	int absis;
	int ordinat;
	int level;
	boolean alive;
	Image tile;
	boolean isActive;
	
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
			BufferedImage a = ImageIO.read(new File("belra.png"));
			belra = a;
			BufferedImage b = ImageIO.read(new File("charwak.png"));
			charwak = b;
			BufferedImage c = ImageIO.read(new File("dugsect.png"));
			dugsect = c;
			BufferedImage d = ImageIO.read(new File("kadaix.png"));
			kadaix = d;
			BufferedImage e = ImageIO.read(new File("kingbat.png"));
			kingbat = e;
			BufferedImage f = ImageIO.read(new File("moltcuno.png"));
			moltcuno = f;
			BufferedImage g = ImageIO.read(new File("oddchu.png"));
			oddchu = g;
			BufferedImage h = ImageIO.read(new File("pindrill.png"));
			pindrill = h;
			BufferedImage i = ImageIO.read(new File("ratung.png"));
			ratung = i;
			BufferedImage j = ImageIO.read(new File("weehorn.png"));
			weehorn = j;
		}
		isActive = false;
	}
	
	public boolean isAlive(){
		return alive;
	}
	
	public int getLevel() {return level;}

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
	
	public Image render(){
		return tile;
	}
	
	public void setAlive(boolean input){
		alive = input;
	}
	
	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}
}
