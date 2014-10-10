package es.hol.fpriego.breakout;

// The Sprite class is a base class for all objects on the Board. We put here all methods and variables 
// that are in Ball, Brick and Paddle objects. Like getImage() or getX() methods

import java.awt.Image;
import java.awt.Rectangle;

public class Sprite {

    protected int x;
    protected int y;
    protected int width;
    protected int heigth;
    protected Image image;


    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return heigth;
    }

    Image getImage()
    {
      return image;
    }

    Rectangle getRect()
    {
      return new Rectangle(x, y, 
          image.getWidth(null), image.getHeight(null));
    }
}
