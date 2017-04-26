package status;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;

import entity.Entity;

/**
 * Panel view untuk kelas Status.
 */
public class HealthBar extends JProgressBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * data member model kelas Player.
	 */
	Entity model;

	/**
	 * constructor.
	 */
	public HealthBar(Entity p) {
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
		setStringPainted(true);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(100, 20));
	}

	/**
	 * mengubah HP player.
	 * @param change perubahan hp player.
	 */
	public void change(int change) {
		model.incHp(change);
	}

	/**
	 * menampilkan isi panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setString(model.getHp()+"/"+model.getMaxHp());
		setValue(model.getHp());
		setMaximum(model.getMaxHp());
		if (model.getHp() <= model.getMaxHp()/4) {
			setForeground(Color.RED);
		}
		else if (model.getHp() <= model.getMaxHp()/2) {
			setForeground(Color.YELLOW);
		}
		else {
			setForeground(Color.GREEN);
		}
	}
}
