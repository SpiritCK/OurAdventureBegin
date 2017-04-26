package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class MainMenuController {
	MainMenu view;
	
	public MainMenuController(MainMenu m) {
		view = m;
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

        Action enter = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (m.nama.getText().equals("") || m.nama.getText().equalsIgnoreCase("Enter your name")) {
					m.warning();
				}
				else {
					m.play();
				}
            }
        };
        int temp = JComponent.WHEN_IN_FOCUSED_WINDOW;
        bindKeyStroke(temp, "enter", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enter);
	}
	
	/**
	 * mengikat tombol keyboard dengan aksi
	 * @param condition kondisi utama
	 * @param name nama aksi
	 * @param keyStroke tombol yang ditekan
	 * @param action aksi yang dijalankan
	 */
    protected void bindKeyStroke(int condition, String name, KeyStroke keyStroke, Action action) {
    	view.getInputMap(condition).put(keyStroke, name);
        view.getActionMap().put(name, action);
    }
}
