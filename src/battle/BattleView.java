package battle;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.*;

import entity.*;
import status.HealthBar;
/**
 * Kelas view untuk mengatur tampilan battle scene.
 */
public class BattleView extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * karakter newline untuk battle log;
	 */
    static final String newline = System.getProperty("line.separator");
    /**
     * label nama player.
     */
    JLabel playername;
    /**
     * label nama virtumon.
     */
    JLabel virtumonname;
    /**
     * HP bar player.
     */
    HealthBar playerhp;
    /**
     * HP bar virtumon.
     */
    HealthBar virtumonhp;
    /**
     * sprite player.
     */
    JLabel playersprite;
    /**
     * sprite virtumon.
     */
    JLabel  virtumonsprite;
    /**
     * tombol normal attack.
     */
    JButton button1;
    /**
     * tombol special attack.
     */
    JButton button2;
    /**
     * tombol defense.
     */
    JButton button3;
    /**
     * tombol catch virtumon.
     */
    JButton button4;
    /**
     * tombol catch virtumon.
     */
    JTextArea battlelog;
    /**
     * status keberjalanan battle
     * 0 : masih berjalan
     * 1 : menang
     * 2 : kalah
     * 3 : berhasil di catch
     */
    int battleStatus;
    /**
     * Constructor.
     * @param p pemain.
     * @param v virtumon yang dilawan.
     */
    public BattleView(Player p, Virtumon v){
    	super();
        setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
    	
		
        playername = new JLabel(p.getName());
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 20;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        add(playername, c);
        
        virtumonname = new JLabel(v.getNama());
        c.gridx = 2;
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        add(virtumonname, c);
        
        playerhp = new HealthBar(p);
        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 5;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(playerhp, c);
        
        virtumonhp = new HealthBar(v);
        c.gridx = 2;
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        add(virtumonhp, c);
        
        playersprite = new JLabel(new ImageIcon(p.getBattleSprite().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        c.gridx = 0;
        c.gridy = 2;
        c.ipady = 4;
        c.anchor = GridBagConstraints.CENTER;
        add(playersprite, c);
        
        virtumonsprite = new JLabel(new ImageIcon(v.render().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        c.gridx = 2;
        c.gridy = 2;
        add(virtumonsprite, c);

        BattleController control = new BattleController(this,p,v);
        button1 = new JButton("Normal Atk");
        button1.setActionCommand("1");
        button1.addActionListener(control);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(button1, c);
        
        button2 = new JButton("Special Atk");
        button2.setActionCommand("2");
        button2.addActionListener(control);
        c.gridy = 4;
        c.ipady = 0;
        add(button2, c);
        
        button3 = new JButton("Defend");
        button3.setActionCommand("3");
        button3.addActionListener(control);
        c.gridy = 5;
        add(button3, c);
        
        button4 = new JButton("Catch");
        button4.setActionCommand("4");
        button4.addActionListener(control);
        c.gridy = 6;
        add(button4, c);
        
        battlelog = new JTextArea();
        battlelog.setEditable(false);
        battlelog.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(battlelog);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(50, 50));
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 3;
        c.gridheight = 4;
        c.fill = GridBagConstraints.BOTH;
        add(scrollPane, c);
        
        setVisible(true);
    }
    /**
     * menambahkan text ke log
     * @param text
     */
    public void addLog(String text) {
        battlelog.append(text + newline);
        battlelog.setCaretPosition(battlelog.getDocument().getLength());
    }
    /**
     * Memberi pesan hasil battle.
     */
    public int getStatus() {
        return battleStatus;
    }
    

    @Override
    /**
     * Menampilkan isi panel.
     */
    public void paintComponent(Graphics g) {
        // Important to call super class method
        super.paintComponent(g);
        // Clear the board
        g.clearRect(0, 0, getWidth(), getHeight());
    }
}