package es.hol.fpriego.shootingmissiles;

import java.awt.Image;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Craft {

    private String craft = "craft.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;

    private ArrayList<Missile> missiles;

    private final int CRAFT_SIZE = 20;

    public Craft() {
        ImageIcon ii = new ImageIcon(craft);
        image = ii.getImage();
        missiles = new ArrayList<Missile>();
        x = 40;
        y = 60;
    }


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
    
    // The getMissiles() method returns the ArrayList of missiles. It is called from the Board class
    
    public ArrayList<Missile> getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        // If we press the space key, we fire
        
        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

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
    
    // The fire() method creates a new Missile object and adds it to the missiles ArrayList
    
    public void fire() {
        missiles.add(new Missile(x + CRAFT_SIZE, y + CRAFT_SIZE/2));
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

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