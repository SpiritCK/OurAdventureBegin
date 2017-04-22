package player;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import virtumon.*;

import javax.imageio.ImageIO;
/**
 * Kelas untuk menyimpan data terkait pemain.
 */
public class Player {
	/**
	 * nama dari pemain.
	 */
	final String name;
	/**
	 * nilai maksimum HP pemain.
	 */
	int maxHp;
	/**
	 * HP pemain saat ini.
	 */
	int hp;
	/**
	 * level pemain saat ini.
	 */
	int level;
	/**
	 * jumlah exp yang dibutuhkan untuk bisa naik level.
	 */
	int maxExp;
	/**
	 * jumlah exp yang dimiliki pemain.
	 */
	int exp;
	/**
	 * gambar sprite pemain.
	 */
	Image sprite;
	/**
	 * Virtumon yang sudah ditangkap
	 */
	Vector<Virtumon> caught;
	
	/**
	 * constructor.
	 * @param nama pemain.
	 * @param maksimum nilai HP pemain.
	 */
	public Player(String inName, int inMaxHp) throws IOException {
		name = inName;
		maxHp = inMaxHp;
		hp = maxHp;
		level = 1;
		maxExp = 5 + 5*level;
		exp = 0;

		BufferedImage x = ImageIO.read(new File("playerdown.png"));
		sprite = x;
	}
	
	//Getter
	/**
	 * mengembalikan nama pemain.
	 * @return nama pemain.
	 */
	public String getName(){
		return name;
	}
	/**
	 * mengembalikkan nilai maksimum HP pemain.
	 * @return
	 */
	public int getMaxHp(){
		return maxHp;
	}
	/**
	 * mengembalikan HP pemain.
	 * @return HP pemain.
	 */
	public int getHp(){
		return hp;
	}
	/**
	 * Mengembalikan level pemain.
	 * @return level pemain.
	 */
	public int getlevel(){
		return level;
	}
	/**
	 * Mengambalikan maksimum exp sampai pemain naik level.
	 * @return maksimum exp pemain.
	 */
	public int getMaxExp(){
		return maxExp;
	}
	/**
	 * Mengembalikan exp pemain.
	 * @return exp pemain
	 */
	public int getExp(){
		return exp;
	}
	/**
	 * Mengembalikan sprite pemain.
	 * @return sprite pemain
	 */
	public Image getSprite() {
		return sprite;
	}
	/**
	 * Mengembalikan vector virtumon yang sudah ditangkap/
	 * @return vector virtumon yang sudah ditangkap.
	 */
	public Vector<Virtumon> getVirtumon(){
		return caught;
	}
	
	//Setter
	/**
	 * menambah/mengurangi HP pemain sebanyak masukan. prekondisi masukan tidak negatif.
	 * @param change
	 */
	public void incHp(int change){
		hp += change;
		if (hp > maxHp){
			hp = maxHp;
		}
		else if(hp < 0){
			hp = 0;
		}
	}
	/**
	 * mengubah HP pemain menjadi masukan.
	 * @param inHp
	 */
	public void setHp(int inHp){
		hp = inHp;
		if (hp > maxHp){
			hp = maxHp;
		}
		else if (hp < 0){
			hp = 0;
		}
	}
	/**
	 * Menambah exp pemain. 
	 * Jika exp lebih besar dari maxEXP, exp akan dikurangi maxEXP,
	 * melakukan level up, dan nilai maxEXP ditambah sesuai dengan level.
	 * @param ZExp
	 */
	public void incExp(int ZExp){
		exp += ZExp;
		while(exp >= maxExp){
			exp -= maxExp;
			levelUp();
			maxExp = 5 + 5*level;
		}
	}
	/**
	 * menambah level pemain.
	 * menambah maxHP pemain sebanyak 10%
	 */
	public void levelUp(){
		level++;
		Double newMaxHP = 1.1 * maxHp;
		maxHp = newMaxHP.intValue();
	}
	/**
	 * menambah virtumon ke dalam vector virtumon yang sudah ditangkap.
	 * @param Virtumon yang ingin dimasukkan.
	 */
	public void AddVirtumon(Virtumon V){
		caught.add(V);
	}
	
}