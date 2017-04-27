package main;

import java.awt.*;
import java.io.*;
import java.util.Vector;

import javax.swing.*;

import battle.BattleView;
import entity.Player;
import map.*;
import status.*;

public class Driver {

    final static String MAIN = "Main Menu GUI";
    final static String MAP = "Map GUI";
    final static String BATTLE = "Battle GUI";
    int GUIstate;
    static JPanel cards;
    static Map map;
    public static JFrame frame;
    static int fail;
    static MainMenu mainMenu;
    static Status status;
    
    public static void teleport() {
    	JTextField PosX = new JTextField(5);
    	JTextField PosY = new JTextField(5);
    	JPanel panel = new JPanel();
    	panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
    	c.gridx = 0;
    	c.gridy = 0;
    	panel.add(new JLabel("X: "), c);
    	c.gridx = 1;
    	c.gridy = 0;
    	panel.add(PosX, c);
    	c.gridx = 0;
    	c.gridy = 1;
    	panel.add(new JLabel("Y: "), c);
    	c.gridx = 1;
    	c.gridy = 1;
    	panel.add(PosY, c);
    	int result = JOptionPane.showConfirmDialog(null, panel, "Enter teleport coordinate", JOptionPane.OK_CANCEL_OPTION);
    	if (result == JOptionPane.OK_OPTION) {
    		if (0 <= Integer.parseInt(PosX.getText()) && 0 <= Integer.parseInt(PosY.getText()) &&
    				map.getNumCols() > Integer.parseInt(PosX.getText()) && map.getNumRows() > Integer.parseInt(PosY.getText())) {
    			map.getPlayer().teleport(Integer.parseInt(PosX.getText()), Integer.parseInt(PosY.getText()));
    		}
    	}
    }
	
    public static String report(Player p) {
    	String caught = new String();
		Vector<String> mentioned = new Vector<String>();
		for(int i = 0;i < status.getModel().getVirtumon().size(); i++){
			String namaVirtumon = new String(status.getModel().getVirtumon().elementAt(i).getNama());
			if(!mentioned.contains(namaVirtumon)){
				mentioned.add(namaVirtumon);
				int jumlahVirtumon = status.getModel().getNumVirtumon(namaVirtumon);
				caught = caught + "\n  - " + namaVirtumon + " : " + Integer.toString(jumlahVirtumon);
			}
		}
    	return caught;
    }
    
	public static void startCheck() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				Thread showCaught = new Thread(new Runnable() {

					@Override
					public void run() {
						while (true) {
							while (!status.getShowCaught()) {
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							/*String caught = new String();
							Vector<String> mentioned = new Vector<String>();
							for(int i = 0;i < status.getModel().getVirtumon().size(); i++){
								String namaVirtumon = new String(status.getModel().getVirtumon().elementAt(i).getNama());
								if(!mentioned.contains(namaVirtumon)){
									mentioned.add(namaVirtumon);
									int jumlahVirtumon = status.getModel().getNumVirtumon(namaVirtumon);
									caught = caught + "\n" + namaVirtumon + " : " + Integer.toString(jumlahVirtumon);
								}
							}*/
							JOptionPane.showMessageDialog(Driver.frame, "Your caught virtumon :" + report(map.getPlayer()));
							status.shown();
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				});
				showCaught.start();
				new Thread(new Runnable() {

					@Override
					public void run() {
						while (true) {
							while (!status.getTeleport()) {
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							Driver.teleport();
							status.setTeleport(false);
						}
					}
					
				}).start();
				while(true) {
					while(mainMenu.status == 0) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (mainMenu.status == 2) {
							JOptionPane.showMessageDialog(frame, "Please enter your name");
							mainMenu.shown();
						}
						else if (mainMenu.status == 3) {
							JOptionPane.showMessageDialog(frame, "Warning : input name max 10 character");
							mainMenu.shown();
						}
					}
					mainMenu.shown();
					map.setNama(mainMenu.getNama());
					CardLayout cl = (CardLayout) cards.getLayout();
			        cl.show(cards, MAP);
			        boolean alive = true;
					while(fail == 0 && alive && !map.getFinish()) {
						while(map.getBattle()==-1 && !map.getFinish()) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if (!map.getFinish()) {		//ada battle
							boolean check = (map.getPlayer().getX() == map.getVirtumon(map.getBattle()).getX() && map.getPlayer().getY() == map.getVirtumon(map.getBattle()).getY());
							assert check;
							BattleView battlePane = new BattleView(map.getPlayer(), map.getVirtumon(map.getBattle()));
							cards.add(battlePane, BATTLE);
					        cl.show(cards, BATTLE);
					        frame.pack();
					        int curLv = map.getPlayer().getlevel();
					        while(battlePane.getStatus() == 0) {
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
					        }
					        if (battlePane.getStatus() == 1) {
					        	if (map.getPlayer().getlevel() > curLv) {
					        		JOptionPane.showMessageDialog(frame, "You win against "+map.getVirtumon(map.getBattle()).getNama()+"\n"
					        				+ "Your level is now : "+map.getPlayer().getlevel());
						        }
					        	else {
					        		JOptionPane.showMessageDialog(frame, "You win against "+map.getVirtumon(map.getBattle()).getNama());
					        	}
					        }
					        else if (battlePane.getStatus() == 2) {
					        	JOptionPane.showMessageDialog(frame, "You're dead\n"
					        			+ "Your caught virtumon : "+report(map.getPlayer())+"\n"
					        			+ "Final score : "+map.getPlayer().getScore());
					        	alive = false;
					        }
					        else {
					        	JOptionPane.showMessageDialog(frame, "Congratulation, you caught it!");
					        }
							map.battleConfirmed(battlePane.getStatus());
					        cards.remove(battlePane);
					        cl.show(cards, MAP);
						}
						else {
							map.getPlayer().addScore(10);
							JOptionPane.showMessageDialog(frame, "Congratulation, you have reached the finish\n"
									+ "You got 10 bonus point for reaching the finish\n"
									+ "Your caught virtumon : "+report(map.getPlayer())+"\n"
									+ "Final score : "+map.getPlayer().getScore());
						}
					}
					cl.show(cards, MAIN);
					try {
						map.refresh();
					} catch (IOException e) {
						assert false;
					}
				}
			}
        	
        }).start();
	}
	
	public static void prepareGUI() {
		//Create and set up the window.
		frame = new JFrame("Solid Adventure : Catch All Virtumon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        Driver demo = new Driver();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	public void addComponentToPane(Container pane) {
		cards = new JPanel(new CardLayout());
		try {
			//setup main menu
			mainMenu = new MainMenu();
			cards.add(mainMenu, MAIN);
			
			//setup map
			JPanel mapPane = new JPanel();
			mapPane.setLayout(new GridBagLayout());
			Player player = new Player("",100);
			File filename = new File("data/map.txt");
			GridBagConstraints c = new GridBagConstraints();
			map = new Map(filename, player);
			c.gridx = 0;
			c.gridy = 0;
			c.ipadx = 0;
			c.ipady = 0;
			mapPane.add(map, c);
			status = new Status(player);
			c.gridx = 1;
			c.gridy = 0;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			mapPane.add(status, c);
			mapPane.setVisible(true);
			
			cards.add(mapPane, MAP);
			fail = 0;
		} catch (IOException e) {
			JPanel error = new JPanel();
			JLabel err = new JLabel("Missing data file");
			error.add(err);
			error.setVisible(true);
			cards.add(error, MAP);
			fail = 1;
		}
		pane.add(cards);
	}
}
