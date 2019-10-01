package com.zelda.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Entities {
	
	private int x;
	private int y;
	private int whidth;
	private int height;
	
	BufferedImage sprite;
	
	public Entities(int x, int y, int whidth, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.whidth = whidth;
		this.height = height;
		this.sprite = sprite;
	}
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, this.getX(), this.getY(), null);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWhidth() {
		return whidth;
	}

	public int getHeight() {
		return height;
	}
	
	

}
