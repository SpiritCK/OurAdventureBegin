package battle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import player.Player;
import virtumon.*;

public class BattleController implements ActionListener{
    private Player player;
    private Virtumon enemy;
    private Battle btl;
    private int specialLimit;
    private BattleView view;
    private Timer timer;
    private boolean locked = false;

    public BattleController(BattleView _view, Player _player, Virtumon _enemy){
        view = _view;
        player = _player;
        enemy = _enemy;
        btl = new Battle(view,player,enemy);
        specialLimit = 3;
    }

    public void actionPerformed(ActionEvent e) {
        int action = Integer.parseInt(e.getActionCommand());
        if (action == 1) {
            if (!locked) {
                locked = true;
                timer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent x) {
                        int damage = (int) Math.round((player.getlevel() * 0.4 + 2) * 100 * player.getAttack() / (enemy.getDefense() * 50) + 2);
                        btl.start(1);
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
                    }
                });
                timer.setInitialDelay(1000);
                timer.setRepeats(false);
                timer.start();
            }
            locked = false;
        }

    }
}
