package main;

import javax.swing.SwingUtilities;

public class Main {
    
	public static void main(String[] args) {
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Driver.prepareGUI();
                Driver.startCheck();
            }
        });
    }

}
