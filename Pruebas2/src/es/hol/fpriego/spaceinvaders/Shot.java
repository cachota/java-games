package es.hol.fpriego.spaceinvaders;

import javax.swing.ImageIcon;

// This is the Shot sprite. The shot is triggered with the alt key. 
// The H_SPACE and the V_SPACE constants are used to position the missile appropriately

public class Shot extends Sprite {

    private String shot = "dot.png";
    private final int H_SPACE = 6;
    private final int V_SPACE = 1;

    public Shot() {
    }

    public Shot(int x, int y) {

        ImageIcon ii = new ImageIcon(shot);
        setImage(ii.getImage());
        setX(x + H_SPACE);
        setY(y - V_SPACE);
    }
}