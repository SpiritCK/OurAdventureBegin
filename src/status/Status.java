package status;

import java.awt.*;
import javax.swing.*;

import player.Player;

public class Status extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * data member model kelas status.
	 */
	Player model;
	JLabel sprite;
	JLabel nama1;
	JLabel nama2;
	JLabel level1;
	JLabel level2;
	JLabel hp1;
	HealthBar hp2;
	JLabel xp1;
	ExpBar xp2;

	/**
	 * constructor.
	 */
	public Status(Player p) {
		super();
		model = p;
        setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		sprite = new JLabel(new ImageIcon(model.getSprite().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		add(sprite,c);
		
		nama1 = new JLabel("Nama: ");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.ipady = 10;
		add(nama1,c);
		
		nama2 = new JLabel(model.getName());
		c.gridx = 1;
		c.gridy = 1;
		add(nama2,c);
		
		level1 = new JLabel("Level: ");
		c.gridx = 0;
		c.gridy = 2;
		add(level1,c);
		
		level2 = new JLabel(new Integer(model.getlevel()).toString());
		c.gridx = 1;
		c.gridy = 2;
		add(level2,c);
		
		hp1 = new JLabel("HP: ");
		c.gridx = 0;
		c.gridy = 3;
		add(hp1,c);
		
		hp2 = new HealthBar(model);
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
		
		xp2 = new ExpBar(model);
		c.gridx = 1;
		c.gridy = 4;
		c.ipady = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		add(xp2,c);
		
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
		level2.setText(new Integer(model.getlevel()).toString());
	}
}
