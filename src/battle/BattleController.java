package battle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import entity.*;
/**
 * Kelas controller dari battle scene.
 */
public class BattleController implements ActionListener{
    /**
     * player.
     */
    private Player player;
    /**
     * enemy.
     */
    private Virtumon enemy;
    /**
     * battle model.
     */
    private Battle btl;
    /**
     * Limit special.
     */
    private int specialLimit;
    /**
     * battle view.
     */
    private BattleView view;
    /**
     * timer.
     */
    private Timer timer;
    boolean cheatOn;
    /**
     * lock mutex.
     */
    private boolean locked = false;
    /**
     * Constructor.
     * @param _view battle view.
     * @param _player player.
     * @param _enemy musuh.
     */
    public BattleController(BattleView _view, Player _player, Virtumon _enemy){
        view = _view;
        player = _player;
        enemy = _enemy;
        btl = new Battle(view,player,enemy);
        specialLimit = 3;
        cheatOn = false;
		Action cheat = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
				cheatOn = true;
            }
        };
		Action healCheat = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
				if(cheatOn) {
					player.setHp(999);
				}
            }
        };
		Action lvCheat = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
				if (cheatOn) {
					player.incExp(1000);
				}
            }
        };

        int temp = JComponent.WHEN_IN_FOCUSED_WINDOW;
        
        bindKeyStroke(temp, "cheat.onoff", KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK), cheat);
        bindKeyStroke(temp, "cheat.heal", KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0), healCheat);
        bindKeyStroke(temp, "cheat.level", KeyStroke.getKeyStroke(KeyEvent.VK_X, 0), lvCheat);
    }
	
    protected void bindKeyStroke(int condition, String name, KeyStroke keyStroke, Action action) {
    	view.getInputMap(condition).put(keyStroke, name);
        view.getActionMap().put(name, action);
    }
    /**
     * Mengatur interaksi terhadap input user pada button.
     * @param e ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int action = Integer.parseInt(e.getActionCommand());
        if (action == 1) {
            if (!locked) {
                locked = true;
                timer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent x) {
                        int damage = (int) Math.round((player.getlevel() * 0.4 + 2) * 100 * player.getAttack() / (enemy.getDefense() * 50) + 2);
                        btl.start(1);
                        view.repaint();
                    }
                });
                timer.setRepeats(false);
                timer.start();
                locked = false;
            }
        }
        else
        if (action == 2){
            if (!locked) {
                locked = true;
                if (specialLimit > 0) {
                    timer = new Timer(1000, new ActionListener() {
                        public void actionPerformed(ActionEvent x) {
                            specialLimit--;
                            int damage = (int) Math.round((player.getlevel() * 0.4 + 2) * 200 * player.getAttack() / (enemy.getDefense() * 50) + 2);
                            btl.start(2);
                            view.repaint();
                        }
                    });
                    timer.setInitialDelay(1000);
                    timer.setRepeats(false);
                    timer.start();
                }
                locked = false;
            }
        }
        else
        if (action == 3){
            if (!locked) {
                locked = true;
                timer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent x) {
                        btl.start(3);
                        view.repaint();
                    }
                });
                timer.setInitialDelay(1000);
                timer.setRepeats(false);
                timer.start();
            }
            locked = false;
        }
        else {
            if (!locked) {
                locked = true;
                timer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent x) {
                        btl.start(4);
                        view.repaint();
                    }
                });
                timer.setInitialDelay(1000);
                timer.setRepeats(false);
                timer.start();
            }
            locked = false;
        }
        view.repaint();
    }
}
