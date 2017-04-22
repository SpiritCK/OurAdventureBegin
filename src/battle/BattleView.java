package battle;

import javax.swing.*;
import player.Player;
import virtumon.*;

public class BattleView extends JFrame{
    public JLabel playerhp,playerhp2,virtumonhp,virtumonhp2,playertxt,virtumontxt;
    public JButton button1, button2, button3, button4;
    public BattleView(Player p, Virtumon v){
        playerhp = new JLabel("HP : ");
        playerhp.setBounds(50,50,100,30);
        playerhp2 = new JLabel("100");
        playerhp2.setBounds(75,50,75,30);
        playertxt = new JLabel();
        playertxt.setBounds(50,60,200,200);

        virtumonhp = new JLabel("HP : ");
        virtumonhp.setBounds(200,50,100,30);
        virtumonhp2 = new JLabel("100");
        virtumonhp2.setBounds(225,50,75,30);
        virtumontxt = new JLabel();
        virtumontxt.setBounds(200,60,200,200);

        BattleController c = new BattleController(this,p,v);
        button1 = new JButton("Normal Atk");
        button1.setBounds(50,250,120,30);
        button1.setActionCommand("1");
        button1.addActionListener(c);
        button2 = new JButton("Special Atk");
        button2.setBounds(200,250,120,30);
        button2.setActionCommand("2");
        button2.addActionListener(c);
        button3 = new JButton("Defend");
        button3.setBounds(50,300,120,30);
        button3.setActionCommand("3");
        button3.addActionListener(c);
        button4 = new JButton("Catch");
        button4.setBounds(200,300,120,30);
        button4.setActionCommand("4");
        button4.addActionListener(c);
        add(playerhp);add(playerhp2);add(virtumonhp);add(virtumonhp2);add(button1);add(button2);
        add(playertxt);add(virtumontxt);add(button3); add(button4);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
