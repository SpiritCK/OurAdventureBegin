package entity;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
/**
 * Kelas untuk menyimpan data terkait pemain.
 */
public class Player extends Entity {
	/**
	 * nama dari pemain.
	 */
	final String name;
	/**
	 * Posisi absis pemain.
	 */
	int absis;
	/**
	 * Posisi ordinat pemain.
	 */
	int ordinat;
	/**
	 * attack dari pemain.
	 */
	int attack;
	/**
	 * defense dari pemain.
	 */
	int defense;
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
	 * arah pemain
	 */
	int state;
	/**
	 * gambar sprite pemain.
	 * sprite[0] down
	 * sprite[1] left
	 * sprite[2] right
	 * sprite[3] up
	 */
	Image[] sprite;
 	/**
	 * gambar sprite pemain dalam pertarungan
	 */
	Image battlesprite;
	/**
	 * gambar sprite pemain dalam pertarungan
	 */
	Image battlesprite;
	/**
	 * Virtumon yang sudah ditangkap
	 */
	Vector<Virtumon> caught;
	
	/**
	 * constructor.
	 * @param inName pemain.
	 * @param inMaxHp nilai HP pemain.
	 */
	public Player(String inName, int inMaxHp) throws IOException {
		name = inName;
		maxHp = inMaxHp;
		hp = maxHp;
		absis = 0;
		ordinat = 0;
		level = 1;
		maxExp = 5 + 5*level;
		exp = 0;
		attack = 100;
		defense = 70;
		state = 0;
		caught = new Vector<Virtumon>();

		sprite = new Image[4];
		BufferedImage[] x = new BufferedImage[4];
		x[0] = ImageIO.read(new File("playerdown.png"));
		sprite[0] = x[0];
		x[1] = ImageIO.read(new File("playerleft.png"));
		sprite[1] = x[1];
		x[2] = ImageIO.read(new File("playerright.png"));
		sprite[2] = x[2];
		x[3] = ImageIO.read(new File("playerup.png"));
		sprite[3] = x[3];
<<<<<<< HEAD
=======
		
>>>>>>> 1a9fee8a65058147dc42b176b370922de789040a
		BufferedImage y = ImageIO.read(new File("playerbattle.png"));
		battlesprite = y;
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
	 * mengembalikan posisi absis pemain
	 * @return absis
	 */
	public int getX() {
		return absis;
	}
	/**
	 * mengembalikan posisi ordinat pemain
	 * @return ordinat
	 */
	public int getY() {
		return ordinat;
	}
	/**
	 * mengubah posisi absis pemain
	 */
	public void setX(int newabsis) {
		absis = newabsis;
	}
	/**
	 * mengubah posisi ordinat pemain
	 */
	public void setY(int newordinat) {
		ordinat = newordinat;
	}
	/**
	 * mengembalikan nilai attack pemain
	 * @return attack
	 */
	public int getAttack() {
		return attack;
	}
	/**
	 * mengembalikan nilai defense pemain
	 * @return defense
	 */
	public int getDefense() {
		return defense;
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
	 * mengubah arah pemain
	 * @param s arah baru
	 */
	public void setState(int s) {
		state = s;
	}
	/**
	 * Mengembalikan sprite pemain.
	 * @return sprite pemain
	 */
	public Image getSprite() {
		return sprite[state];
	}
	public Image getBattleSprite() {
		return battlesprite;
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
	 * @param V yang ingin dimasukkan.
	 */
	public void addVirtumon(Virtumon V){
		caught.add(V);
	}
	
}