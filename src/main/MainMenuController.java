package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {
	MainMenu view;
	
	public MainMenuController(MainMenu m) {
		m.start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (m.nama.getText().equals("") || m.nama.getText().equalsIgnoreCase("Enter your name")) {
					m.warning();
				}
				else {
					m.play();
				}
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
