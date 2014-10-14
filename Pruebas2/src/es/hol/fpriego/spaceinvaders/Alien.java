package es.hol.fpriego.spaceinvaders;

import javax.swing.ImageIcon;

// This is the Alien sprite. Each alien has an inner Bomb class

public class Alien extends Sprite {

    private Bomb bomb;
    private final String shot = "alien2.png";

    public Alien(int x, int y) {
        this.x = x;
        this.y = y;

        bomb = new Bomb(x, y);
        ImageIcon ii = new ImageIcon(shot);
        setImage(ii.getImage());

    }

    // The act() method is called from the Board class. It is used to position an alien in horizontal direction
    
    public void act(int direction) {
        this.x += direction;
    }

    // The getBomb() method is called, when the alien is about to drop a bomb
    
    public Bomb getBomb() {
        return bomb;
    }

    public class Bomb extends Sprite {

        private final String bomb = "head.png";
        private boolean destroyed;

        public Bomb(int x, int y) {
            setDestroyed(true);
            this.x = x;
            this.y = y;
            ImageIcon ii = new ImageIcon(bomb);
            setImage(ii.getImage());
        }

        public void setDestroyed(boolean destroyed) {
            this.destroyed = destroyed;
        }

        public boolean isDestroyed() {
            return destroyed;
        }
    }
}