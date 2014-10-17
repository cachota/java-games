package es.hol.fpriego.pruebas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Player player;
	private Timer timer;
	
	public Main() {
		
		this.addKeyListener(new Teclado());
		this.setBackground(Color.gray);
		this.setFocusable(true);
		
		this.setPreferredSize(new Dimension(640,480));
		initGame();
	}
	
	private void initGame(){
		
		player = new Player();
		timer = new Timer(25,this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		
		this.draw(g);
	}

	private void draw(Graphics g){
		
		g.clearRect(0, 0, 640, 480);
		g.drawImage(player.getAnimation().getSprite(), player.getX(), player.getY(),null);
		Toolkit.getDefaultToolkit().sync();
		
	}
	
	private class Teclado extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent event) {
			
			int key = event.getKeyCode();
			
			switch(key){
			case KeyEvent.VK_LEFT:
				player.setX(player.getX()-2);
				player.setAnimation(player.getWalkLeft());
				break;
			case KeyEvent.VK_RIGHT:
				player.setX(player.getX()+2);
				player.setAnimation(player.getWalkRight());
				break;
			case KeyEvent.VK_UP:
				player.setY(player.getY()+2);
				player.setAnimation(player.getWalkLeft());
				break;
			case KeyEvent.VK_DOWN:
				player.setY(player.getY()-2);
				player.setAnimation(player.getWalkRight());
				break;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent event) {
			
			player.setAnimation(player.getStand());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		repaint();
	}

}
