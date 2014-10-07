package es.hol.fpriego;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Application extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6587005150426060114L;

	public Application() throws HeadlessException {
		initUI();
	}
	
	private void initUI(){
		
		add(new Board());

        setSize(330, 330);

        setTitle("Donut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		
		// We create an instance of our code example and make it visible on the screen
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Application ex = new Application();
				ex.setVisible(true);
			}
		});
	}

}
