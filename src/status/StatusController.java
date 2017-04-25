package status;

import java.awt.event.*;
import javax.swing.*;

public class StatusController {
	Status view;
	
	public StatusController(Status m) {
		view = m;
		Action incAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
				System.out.println("plus");
            	view.hp2.change(5);
            	view.repaint();
            }
        };
        Action decAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			
            @Override
            public void actionPerformed(ActionEvent e) {
				System.out.println("minus");
            	view.hp2.change(-5);
            	view.repaint();
            }
        };
		Action incXpAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
				System.out.println("xp plus");
            	view.xp2.change(3);
            	view.repaint();
            }
        };
        Action decXpAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			
            @Override
            public void actionPerformed(ActionEvent e) {
				System.out.println("xp minus");
            	view.xp2.change(-3);
            	view.repaint();
            }
        };
        view.heal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.model.useMedicine();
			}
        	
        });
        
        int temp = JComponent.WHEN_IN_FOCUSED_WINDOW;

        bindKeyStroke(temp, "inc.hp", KeyStroke.getKeyStroke(KeyEvent.VK_T, 0), incAction);
        bindKeyStroke(temp, "dec.hp", KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), decAction);
        bindKeyStroke(temp, "inc.xp", KeyStroke.getKeyStroke(KeyEvent.VK_G, 0), incXpAction);
        bindKeyStroke(temp, "dec.xp", KeyStroke.getKeyStroke(KeyEvent.VK_F, 0), decXpAction);
    }

    protected void bindKeyStroke(int condition, String name, KeyStroke keyStroke, Action action) {
    	view.getInputMap(condition).put(keyStroke, name);
        view.getActionMap().put(name, action);
    }
}
