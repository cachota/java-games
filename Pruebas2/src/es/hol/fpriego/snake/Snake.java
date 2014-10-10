package es.hol.fpriego.snake;

import java.awt.EventQueue;
import javax.swing.JFrame;


public class Snake extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Snake() {

        add(new Board());
        
        // The setResizable() method affects the insets of the JFrame container on some platforms. 
        // Therefore, it is important to call it before the pack() method. Otherwise, the collision of 
        // the snake's head with the right and bottom borders might not work correctly
        
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new Snake();
                ex.setVisible(true);                
            }
        });
    }
}
