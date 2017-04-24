package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {
	MainMenu view;
	
	public MainMenuController(MainMenu m) {
		m.start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				m.play();
			}
			
		});
		m.exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
	}
}
