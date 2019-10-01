package com.zelda.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Entities {
	
	protected int x;
	protected int y;
	protected int whidth;
	protected int height;
	
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
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	
	

}
