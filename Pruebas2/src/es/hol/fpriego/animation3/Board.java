package es.hol.fpriego.animation3;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel
        implements Runnable {

    /*
	 In the previous examples, we executed a task at specific intervals. In this example, the animation will take 
	 place inside a thread. The run() method is called only once. This is why why we have a while loop in the method. 
	 From this method, we call the cycle() and the repaint() methods. 
	 */
	private static final long serialVersionUID = -2414852276103463678L;
	
	private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 25;

    private Image star;
    private Thread animator;
    private int x, y;

    public Board() {

        initBoard();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("star.png");
        star = ii.getImage();
    }

    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);

        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;
    }

    // The addNotify() method is called after our JPanel has been added to the JFrame component. 
    // This method is often used for various initialization tasks.
    
    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawStar(g);
    }

    private void drawStar(Graphics g) {

        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void cycle() {

        x += 1;
        y += 1;

        if (y > B_HEIGHT) {

            y = INITIAL_Y;
            x = INITIAL_X;
        }
    }

    @Override
    public void run() {
    	
    	// We want our game run smoothly, at constant speed. Therefore we compute the system time
    	
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {
        	
        	// The cycle() and the repaint() methods might take different time at various while cycles. 
        	// We calculate the time both methods run and subtract it from the DELAY constant. 
        	// This way we want to ensure that each while cycle runs at constant time. In our case, it is DELAYms each cycle
        	
            cycle();
            repaint();
            
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }

            beforeTime = System.currentTimeMillis();
        }
    }
}