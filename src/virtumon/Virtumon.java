package virtumon;

import java.awt.*;

public abstract class Virtumon {
	String nama;
	final int maxHp;
	int hp;
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
	
	/**
	 * fungsi untuk mendapatkan nama virtumon
	 * @return nama
	 */
	public String getNama(){
		return nama;
	}
	
	/**
	 * fungsi untuk mendapatkan hp
	 * @return hp
	 */
	public int getHp(){
		return hp;
	}
	
	/**
	 * fungsi untuk mendapatkan hp maksimum
	 * @return
	 */
	public int getMaxHp(){
		return maxHp;
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
	
	/**
	 * fungsi untuk meningkatkan hp
	 * @param amount
	 */
	public void increaseHp(int amount){
		hp += amount;
		
		if(hp > maxHp){
			hp = maxHp;
		}
	}
	
	/**
	 * fungsi untuk mengurangi hp
	 * @param amount
	 */
	public void decreaseHp(int amount){
		hp -= amount;
		
		if(hp<0){
			hp = 0;
		}
	}
	
	public Image render(){
		return tile;
	}
	
}
