package es.hol.fpriego.breakout;


import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

// This is the Paddle class. It encapsulates the paddle object in the Breakout game. The paddle is controlled 
// with left and right arrow keys. By pressing the arrow key, we set the direction variable. By releasing the 
// arrow key, we set the dx variable to zero. This way the paddle stops moving

public class Paddle extends Sprite implements Commons {

    String paddle = "paddle.png";

    int dx;

    public Paddle() {

        ImageIcon ii = new ImageIcon(paddle);
        image = ii.getImage();

        width = image.getWidth(null);
        heigth = image.getHeight(null);

        resetState();

    }

    public void move() {
        x += dx;
        if (x <= 2) 
          x = 2;
        if (x >= Commons.PADDLE_RIGHT)
          x = Commons.PADDLE_RIGHT;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;

        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    public void resetState() {
        x = 200;
        y = 360;
    }
}