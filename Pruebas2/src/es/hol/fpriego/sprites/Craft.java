package es.hol.fpriego.sprites;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

// This class represents a spacecraft. In this class we keep the image of the sprite and the coordinates of the sprite. 
// The keyPressed() and keyReleased() methods control whether the sprite is moving or is in standstill

public class Craft {

    private String craft = "craft.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;

    public Craft() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        x = 40;
        y = 60;
    }

    //  The move() method changes the coordinates of the sprite. 
    // These x, y values are used in the paint() method to draw the image of the sprite
    
    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        // When we release the left cursor key, we set the dx variable to zero. The spacecraft will stop moving
        
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
