package es.hol.fpriego.animation2;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class UtilityTimerExample extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5119987083584997955L;

	public UtilityTimerExample() {

        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
                        
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
                JFrame ex = new UtilityTimerExample();
                ex.setVisible(true);                
            }
        });
    }
}