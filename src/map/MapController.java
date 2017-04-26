package map;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

/**
 * controller untuk kelas map.
 */
public class MapController {
	/**
	 * data member kelas view map.
	 */
	Map view;
	/**
	 * penanda cheat menyala.
	 */
	boolean cheatOn;
	
	/**
	 * constructor.
	 * @param m kelas view map.
	 */
	public MapController(Map m) {
		view = m;
		cheatOn = false;
		Action leftAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
	            view.IncrementX(false);
	            view.repaint();
            }
        };
        Action rightAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			
            @Override
            public void actionPerformed(ActionEvent e) {
	            view.IncrementX(true);
	            view.repaint();
            }
        };
        Action upAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			
            @Override
            public void actionPerformed(ActionEvent e) {
	            view.IncrementY(false);
	            view.repaint();
            }
        };
        Action downAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			
			@Override
            public void actionPerformed(ActionEvent e) {
				view.IncrementY(true);
				view.repaint();
            }
        };
        
        int temp = JComponent.WHEN_IN_FOCUSED_WINDOW;

        bindKeyStroke(temp, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), leftAction);
        bindKeyStroke(temp, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_KP_LEFT, 0), leftAction);
        bindKeyStroke(temp, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), leftAction);

        bindKeyStroke(temp, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), rightAction);
        bindKeyStroke(temp, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_KP_RIGHT, 0), rightAction);
        bindKeyStroke(temp, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), rightAction);

        bindKeyStroke(temp, "move.up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), upAction);
        bindKeyStroke(temp, "move.up", KeyStroke.getKeyStroke(KeyEvent.VK_KP_UP, 0), upAction);
        bindKeyStroke(temp, "move.up", KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), upAction);

        bindKeyStroke(temp, "move.down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), downAction);
        bindKeyStroke(temp, "move.down", KeyStroke.getKeyStroke(KeyEvent.VK_KP_DOWN, 0), downAction);
        bindKeyStroke(temp, "move.down", KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), downAction);
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
