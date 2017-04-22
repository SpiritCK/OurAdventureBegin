package main;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import map.*;
import player.Player;
import status.*;

public class Main {
	public static void main(String[] args) {
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Game");
                File filename = new File("map.txt");
                frame.setLayout(new GridBagLayout());
        		GridBagConstraints c = new GridBagConstraints();
				try {
					Player player = new Player("Solid",100);
	                Map map = new Map(filename);
					c.gridx = 0;
					c.gridy = 0;
	                frame.add(map, c);
	                //HealthBar status = new HealthBar(player);
	                Status status = new Status(player);
					c.gridx = 1;
					c.gridy = 0;
					c.anchor = GridBagConstraints.FIRST_LINE_START;
	                frame.add(status, c);
	                
				} catch (IOException e) {
					JLabel err = new JLabel("Missing data file");
					frame.add(err);
				}
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
