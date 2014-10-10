package es.hol.fpriego.tetris;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

// In the Tetris.java file, we set up the game. We create a board on which we play the game. We create a statusbar

public class Tetris extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel statusbar;


    public Tetris() {

        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);
        Board board = new Board(this);
        add(board);
        
        //  The start() method starts the Tetris game. Immediately, after the window appears on the screen. 
        
        board.start();

        setSize(200, 400);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   public JLabel getStatusBar() {
       return statusbar;
   }

    public static void main(String[] args) {

        Tetris game = new Tetris();
        game.setLocationRelativeTo(null);
        game.setVisible(true);

    } 
}
