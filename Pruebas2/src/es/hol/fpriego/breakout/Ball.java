package es.hol.fpriego.breakout;

import javax.swing.ImageIcon;


public class Ball extends Sprite implements Commons {

   private int xdir;
   private int ydir;

   protected String ball = "ball.png";

   public Ball() {

     xdir = 1;
     ydir = -1;

     ImageIcon ii = new ImageIcon(ball);
     image = ii.getImage();

     width = image.getWidth(null);
     heigth = image.getHeight(null);

     resetState();
    }

   // The move() method moves the ball on the Board. If the ball hits the borders, the directions are changed accordingly
   
    public void move()
    {
      x += xdir;
      y += ydir;

      if (x == 0) {
        setXDir(1);
      }

      if (x == BALL_RIGHT) {
        setXDir(-1);
      }

      if (y == 0) {
        setYDir(1);
      }
    }

    public void resetState() 
    {
      x = 230;
      y = 355;
    }
    
    //  These two methods are called, when the ball hits the paddle or a brick
    
    public void setXDir(int x)
    {
      xdir = x;
    }

    public void setYDir(int y)
    {
      ydir = y;
    }

    public int getYDir()
    {
      return ydir;
    }
}