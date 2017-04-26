package status;

import java.awt.*;
import javax.swing.*;

import entity.Player;

public class Status extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * data member model kelas status.
	 */
	private Player model;
	/**
	 * label untuk sprite.
	 */
	JLabel sprite;
	/**
	 * label untuk tulisan "Nama".
	 */
	JLabel nama1;
	/**
	 * label untuk nama.
	 */
	JLabel nama2;
	/**
	 * label untuk tulisan "Level".
	 */
	JLabel level1;
	/**
	 * label untuk level.
	 */
	JLabel level2;
	/**
	 * label untuk tulisan "HP".
	 */
	JLabel hp1;
	/**
	 * HP bar.
	 */
	HealthBar hp2;
	/**
	 * label untuk tulisan "EXP".
	 */
	JLabel xp1;
	/**
	 * EXP bar.
	 */
	ExpBar xp2;
	/**
	 * label untuk tulisan "ATK".
	 */
	JLabel atk1;
	/**
	 * label untuk attack.
	 */
	JLabel atk2;
	/**
	 * label untuk tulisan "DEF".
	 */
	JLabel def1;
	/**
	 * label untuk defense.
	 */
	JLabel def2;
	/**
	 * label untuk tulisan "Score".
	 */
	JLabel score1;
	/**
	 * label untuk score.
	 */
	JLabel score2;
	/**
	 * tombol untuk menampilkan virtumon yang ditangkap.
	 */
	JButton caught;
	/**
	 * tombol untuk heal.
	 */
	JButton heal;
	/**
	 * penanda apakah caught virtumon diperlihatkan atau tidak.
	 */
	boolean showCaught;

	/**
	 * constructor.
	 */
	public Status(Player p) {
		super();
		model = p;
		showCaught = false;
        setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		sprite = new JLabel(new ImageIcon(getModel().getSprite().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.ipadx = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		add(sprite,c);
		
		nama1 = new JLabel("Nama: ");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.ipady = 10;
		add(nama1,c);
		
		nama2 = new JLabel(getModel().getName());
		c.gridx = 1;
		c.gridy = 1;
		add(nama2,c);
		
		level1 = new JLabel("Level: ");
		c.gridx = 0;
		c.gridy = 2;
		add(level1,c);
		
		level2 = new JLabel(new Integer(getModel().getlevel()).toString());
		c.gridx = 1;
		c.gridy = 2;
		add(level2,c);
		
		hp1 = new JLabel("HP: ");
		c.gridx = 0;
		c.gridy = 3;
		add(hp1,c);
		
		hp2 = new HealthBar(getModel());
		c.gridx = 1;
		c.gridy = 3;
		c.ipady = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(hp2,c);
		
		xp1 = new JLabel("EXP: ");
		c.gridx = 0;
		c.gridy = 4;
		c.ipady = 10;
		c.fill = GridBagConstraints.NONE;
		add(xp1,c);
		
		xp2 = new ExpBar(getModel());
		c.gridx = 1;
		c.gridy = 4;
		c.ipady = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		add(xp2,c);
		
		atk1 = new JLabel("ATK: ");
		c.gridx = 0;
		c.gridy = 5;
		c.ipady = 10;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		add(atk1,c);
		
		atk2 = new JLabel(new Integer(getModel().getAttack()).toString());
		c.gridx = 1;
		c.gridy = 5;
		add(atk2,c);
		
		def1 = new JLabel("DEF: ");
		c.gridx = 0;
		c.gridy = 6;
		add(def1,c);
		
		def2 = new JLabel(new Integer(getModel().getDefense()).toString());
		c.gridx = 1;
		c.gridy = 6;
		add(def2,c);
		
		score1 = new JLabel("Score: ");
		c.gridx = 0;
		c.gridy = 7;
		add(score1,c);
		
		score2 = new JLabel(new Integer(getModel().getScore()).toString());
		c.gridx = 1;
		c.gridy = 7;
		add(score2,c);
		
		caught = new JButton("Caught Virtumon");
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(caught, c);
		
		heal = new JButton("Medicine left : 0");
		c.gridy = 9;
		add(heal, c);
		
		new StatusController(this);
	}

	/**
	 * menampilkan isi panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		hp2.repaint();
		xp2.repaint();
		sprite.setIcon(new ImageIcon(getModel().getSprite().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		level2.setText(new Integer(getModel().getlevel()).toString());
		atk2.setText(new Integer(getModel().getAttack()).toString());
		def2.setText(new Integer(getModel().getDefense()).toString());
		nama2.setText(getModel().getName());
		heal.setText("Medicine left : "+getModel().getMedicine());
		score2.setText(new Integer(getModel().getScore()).toString());
	}
	/**
	 * getter model
	 * @return the model
	 */
	public Player getModel() {
		return model;
	}

	/**
	 * getter showCaught
	 * @return showCaught
	 */
	public boolean getShowCaught() {
		return showCaught;
	}
	/**
	 * memberi tahu bahwa caught virtumon sudah ditampilkan
	 */
	public void shown() {
		showCaught = false;
	}
}
