package es.hol.fpriego.animation;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class SwingTimerExample extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7409017146192315138L;

	public SwingTimerExample() throws HeadlessException {
		initUI();
	}

	private void initUI() {
		add(new Board());
		
		// The pack() method causes this window to be sized to fit the preferred size and layouts of its children. 
		// Note that the order in which these two methods are called is important. (The setResizable() changes the insets 
		// of the frame on some platforms; calling this method after the pack() method might lead to incorrect results—the 
		// star would not go precisely into the right-bottom border of the window.) 
		
        setResizable(false);
        pack();
        
        setTitle("Star");
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new SwingTimerExample();
                ex.setVisible(true);                
            }
        });
	}

}
