package es.hol.fpriego.pruebas;

import java.awt.image.BufferedImage;

public class Player {
	
	// Images for each animation
	private BufferedImage[] walkingLeft = {Sprite.getSprite(0, 1), Sprite.getSprite(2, 1)}; // Gets the upper left images of my sprite sheet
	private BufferedImage[] walkingRight = {Sprite.getSprite(0, 2), Sprite.getSprite(2, 2)};
	private BufferedImage[] standing = {Sprite.getSprite(1, 0)};

	// These are animation states
	private Animation walkLeft = new Animation(walkingLeft, 10);
	private Animation walkRight = new Animation(walkingRight, 10);
	private Animation stand = new Animation(standing, 10);

	// This is the actual animation
	private Animation animation = stand;
	
	private int x,y;
	
	public Player() {
		this.setX(320);
		this.setY(240);
	}

	public Animation getWalkLeft() {
		return walkLeft;
	}

	public void setWalkLeft(Animation walkLeft) {
		this.walkLeft = walkLeft;
	}

	public Animation getWalkRight() {
		return walkRight;
	}

	public void setWalkRight(Animation walkRight) {
		this.walkRight = walkRight;
	}

	public Animation getStand() {
		return stand;
	}

	public void setStand(Animation stand) {
		this.stand = stand;
	}

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
