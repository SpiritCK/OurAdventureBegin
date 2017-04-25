package main;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class MainMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton start;
	JButton exit;
	Image background;
	JLabel logo;
	
	public MainMenu() throws IOException {
		GridBagConstraints c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		BufferedImage x = ImageIO.read(new File("logo.png"));
		logo = new JLabel(new ImageIcon(((Image) x).getScaledInstance(319, 154, Image.SCALE_DEFAULT)));
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;
		c.fill = GridBagConstraints.NONE;
		add(logo, c);
		start = new JButton("Start Game");
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(start, c);
		exit = new JButton("Exit Game");
		c.gridy = 2;
		add(exit, c);
		BufferedImage y = ImageIO.read(new File("background.png"));
		background = y;
		new MainMenuController(this);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT), 0, 0, this);
		logo.repaint();
		start.repaint();
		exit.repaint();
	}
	
	void play() {
		CardLayout cl = (CardLayout)(Driver.cards.getLayout());
        cl.show(Driver.cards, Driver.MAP);
	}
}
