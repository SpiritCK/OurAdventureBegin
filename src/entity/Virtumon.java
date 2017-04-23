package entity;

import java.awt.*;

public abstract class Virtumon extends Entity {
	String nama;
	int damage;
	int defense;
	int absis;
	int ordinat;
	int level;
	Image tile;
	
	/**
	 * Constructor class
	 * @param _nama nama dari virtumon
	 * @param _maxHp hp maksimum dari virtumon
	 * @param _damage damage untuk mengurangi hp musuh
	 * @param _defense defense untuk mengurangi damage yang masuk
	 * @param _absis koordinat sumbu-X
	 * @param _ordinat koordinat sumbu-Y
	 * @param _level level dari virtumon
	 */
	public Virtumon(String _nama, int _maxHp, int _damage, int _defense, int _absis, int _ordinat, int _level){
		nama = _nama;
		maxHp = _maxHp;
		hp = maxHp;
		damage = _damage;
		defense = _defense;
		absis = _absis;
		ordinat = _ordinat;
		level = _level;
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
	
}
