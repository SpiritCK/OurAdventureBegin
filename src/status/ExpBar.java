package status;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;

import player.Player;

/**
 * Panel view untuk kelas Status.
 */
public class ExpBar extends JProgressBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * data member model kelas Player.
	 */
	Player model;

	/**
	 * constructor.
	 */
	public ExpBar(Player p) {
		super();
		model = p;
		setUI(new BasicProgressBarUI() {
			protected Color getSelectionBackground() {
				return Color.BLACK;
			}
			protected Color getSelectionForeground() {
				return Color.BLACK;
			}
		});
		setStringPainted(false);
		setBackground(Color.WHITE);
		setForeground(Color.YELLOW);
		setPreferredSize(new Dimension(100, 5));
	}

	/**
	 * mengubah HP player.
	 * @param perubahan hp player.
	 */
	public void change(int change) {
		model.incExp(change);
	}

	/**
	 * menampilkan isi panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setValue(model.getExp());
		setMaximum(model.getMaxExp());
		System.out.println("ok");
	}
}
