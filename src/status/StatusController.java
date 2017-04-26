package status;

import java.awt.event.*;
import javax.swing.*;

public class StatusController {
	/**
	 * data member view
	 */
	Status view;
	/**
	 * penanda nyala tidaknya cheat
	 */
	private boolean cheatOn;
	
	/**
	 * Constructor.
	 * @param m view
	 */
	public StatusController(Status m) {
		view = m;
		cheatOn = false;
		Action cheat = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
				cheatOn = true;
            }
        };
		Action incAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
				if (cheatOn) {
	            	view.hp2.change(5);
	            	view.repaint();
				}
            }
        };
        Action decAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			
            @Override
            public void actionPerformed(ActionEvent e) {
				if (cheatOn) {
	            	view.hp2.change(-5);
	            	view.repaint();
				}
            }
        };
		Action incXpAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
				if (cheatOn) {
	            	view.xp2.change(3);
	            	view.repaint();
				}
            }
        };
        Action decXpAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			
            @Override
            public void actionPerformed(ActionEvent e) {
				if (cheatOn) {
	            	view.xp2.change(-3);
	            	view.repaint();
				}
            }
        };
        
        view.caught.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.showCaught = true;
			}
        	
        });
        view.heal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getModel().useMedicine();
			}
        	
        });
        Action teleport = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			
			@Override
            public void actionPerformed(ActionEvent e) {
				if (cheatOn) {
					view.getModel().teleport(390, 390);
					view.repaint();
				}
            }
        };
        
        int temp = JComponent.WHEN_IN_FOCUSED_WINDOW;

        bindKeyStroke(temp, "cheat.onoff", KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK), cheat);
        bindKeyStroke(temp, "inc.hp", KeyStroke.getKeyStroke(KeyEvent.VK_T, 0), incAction);
        bindKeyStroke(temp, "dec.hp", KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), decAction);
        bindKeyStroke(temp, "inc.xp", KeyStroke.getKeyStroke(KeyEvent.VK_G, 0), incXpAction);
        bindKeyStroke(temp, "dec.xp", KeyStroke.getKeyStroke(KeyEvent.VK_F, 0), decXpAction);
        bindKeyStroke(temp, "teleport", KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), teleport);
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
