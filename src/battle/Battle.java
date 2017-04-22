package battle;

import player.Player;
import virtumon.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Battle {
    private boolean isPlayerTurn = true;
    private Player player;
    private Virtumon enemy;
    private BattleView view;
    private int commandp,commande;
    private Timer timer;

    public Battle(BattleView _view, Player _player, Virtumon _enemy) {
        player = _player;
        enemy = _enemy;
        view = _view;
    }

    public void start(int cmd){
        if (isPlayerTurn && (player.getHp() > 0) ) {
            int dmg = 0;
            commandp = cmd;
            commande = generateRandomAttack();
            shoutPlayer(commandp);
            shoutVirtumon(commande);
            if ((commandp == 1 || commandp == 2) && (commande == 1 || commande == 2)) {
                attackToEnemyTimer(1500);
                attackToPlayerTimer(3000);
            }
            else
            if (commandp == 3 && commande == 3) {
            }
            else
            if (commandp == 3 && commande == 1) {
                attackToPlayerTimer(1500);
            }
            else
            if (commandp == 1 && commande == 3) {
                attackToEnemyTimer(1500);
            }
            else
            if (commandp == 2 && commande == 3) {
                view.playertxt.setText("Attack blocked!");
                view.virtumontxt.setText("Blocking !");
            }
            else
            if (commandp == 3 && commande == 2) {
                view.virtumontxt.setText("Attack blocked!");
                view.playertxt.setText("Blocking !");
            }
            else
            if (commandp == 4 && (commande == 1 || commande == 2)) {
                catching();
                attackToPlayerTimer(3000);
            }
            else {  //commandp == 4 && commande == 3
                catching();
            }

        }
    }

    private void attackToPlayerTimer(int delay) {
        timer = new Timer(1500, new ActionListener() {
            public void actionPerformed(ActionEvent x) {
                attackToPlayer(commande);
            }
        });
        timer.setInitialDelay(delay);
        timer.setRepeats(false);
        timer.start();
    }

    private void attackToEnemyTimer(int delay) {
        timer = new Timer(1500, new ActionListener() {
            public void actionPerformed(ActionEvent x) {
                attackToEnemy(commandp);
            }
        });
        timer.setInitialDelay(delay);
        timer.setRepeats(false);
        timer.start();
    }

    private int generateRandomAttack() {
        Random random = new Random(System.nanoTime());
        int attackNumber = random.nextInt(3) + 1;
        return attackNumber;
    }

    private void shoutVirtumon(int attackNumber) {
        switch (attackNumber) {
            case 1:
                view.virtumontxt.setText("<html>Virtumon menyerang<br>dengan normal attack !</html>");
                break;
            case 2:
                view.virtumontxt.setText("<html>Virtumon menyerang<br>dengan special attack !</html>");
                break;
            case 3:
                view.virtumontxt.setText("<html>Virtumon bertahan!!</html>");
                break;
        }
    }

    private void attackToPlayer(int attackNumber) {
        int dmg = 0;
        switch (attackNumber) {
            case 1:
                dmg = (int) (Math.round((enemy.getLevel() * 0.4 + 2) * 100 * enemy.getDamage() / (player.getDefense() * 50) + 2));
                break;
            case 2:
                dmg = (int) (Math.round((enemy.getLevel() * 0.4 + 2) * 250 * enemy.getDamage() / (player.getDefense() * 50) + 2));
                break;
        }
        player.incHp((-1) * dmg);
        view.playerhp2.setText(Integer.toString(player.getHp()));
        if (player.getHp() <= 0) {
            lose();
        }
        else {
            view.playertxt.setText("HP - " + Integer.toString(dmg));
            view.virtumontxt.setText("Attack success!");
        }
    }

    private void shoutPlayer(int attackNumber) {
        switch (attackNumber) {
            case 1:
                view.playertxt.setText("<html>Player menyerang<br>dengan normal attack !</html>");
                break;
            case 2:
                view.playertxt.setText("<html>Player menyerang<br>dengan special attack !</html>");
                break;
            case 3:
                view.playertxt.setText("<html>Player bertahan!!</html>");
                break;
            case 4:
                view.playertxt.setText("<html>Player melempar VirtuBall !!</html>");
                break;
        }
    }

    private void attackToEnemy(int attackNumber) {
        int dmg = 0;
        switch (attackNumber) {
            case 1:
                dmg = (int) (Math.round((player.getlevel() * 0.4 + 2) * 100 * enemy.getDamage() / (player.getDefense() * 50) + 2));
                break;
            case 2:
                dmg = (int) (Math.round((player.getlevel() * 0.4 + 2) * 250 * enemy.getDamage() / (player.getDefense() * 50) + 2));
                break;
        }
        enemy.decreaseHp(dmg);
        view.virtumonhp2.setText(Integer.toString(enemy.getHp()));
        if (enemy.getHp() <= 0) {
            won();
        }
        else {
            view.virtumontxt.setText("HP - " + Integer.toString(dmg));
            view.playertxt.setText("Attack success!");
        }
    }

    private void won() {
        view.playertxt.setText("WIN !!");
        view.virtumontxt.setText("Dead");
    }

    private void lose() {
        view.playertxt.setText("Dead");
        view.virtumontxt.setText("Win");
    }

    public void catching() {
        int satu = 1;
        int seratus = 100;
        double percentageOfSuccess = ((double)satu - (double)enemy.getHp()/(double)enemy.getMaxHp())*(double)seratus;
        double hasilRandom = Math.random() * 100 + 1;
        timer = new Timer(1500, new ActionListener() {
            public void actionPerformed(ActionEvent x) {
                if (hasilRandom <= percentageOfSuccess) {      //berhasil menangkap pokemon
                    player.addVirtumon(enemy);
                    view.playertxt.setText("Berhasil menangkap Pokemon !!");
                    view.virtumontxt.setText("Tertangkap !!");
                    //Keluar dari battle
                }
                else {		//gagal menngkap virtumon
                    view.playertxt.setText("Gagal menangkap Pokemon !!");
                    view.virtumontxt.setText("Berhasil menghindar !!!");
                }
            }
        });
        timer.setInitialDelay(1500);
        timer.setRepeats(false);
        timer.start();
    }
}
