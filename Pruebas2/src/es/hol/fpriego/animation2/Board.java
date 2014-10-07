package es.hol.fpriego.animation2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8728356860559094200L;
	private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;    
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;
    
    private Image star;
    
    // java.util.Timer. For Java Swing games this way should be more accurate
    
    private Timer timer;
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
        
        // In this example, the timer will regularly call the run() method of the ScheduleTask class
        // Here we create a timer and schedule a task with a specific interval. There is an initial delay
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 
                INITIAL_DELAY, PERIOD_INTERVAL);        
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


    private class ScheduleTask extends TimerTask {
    	
    	// Each 10ms the timer will call this run() method
    	
        @Override
        public void run() {
            x += 1;
            y += 1;

            if (y > B_HEIGHT) {
                y = INITIAL_Y;
                x = INITIAL_X;
            }
            
            repaint();
        }
    }
}