package entity;

public abstract class Entity {
	/**
	 * nilai maksimum HP pemain.
	 */
	int maxHp;
	/**
	 * HP pemain saat ini.
	 */
	int hp;

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
	 * mengubah nilai HP
	 * @param val
	 */
	public void setHp(int val) {
		hp = val;
		if (hp > maxHp){
			hp = maxHp;
		}
		else if(hp < 0){
			hp = 0;
		}
	}
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
}
