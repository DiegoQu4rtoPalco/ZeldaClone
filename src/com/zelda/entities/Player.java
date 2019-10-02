package com.zelda.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import zelda.clone.Main;

public class Player extends Entities {
	
	public boolean right;
	public  boolean left;
	public boolean up;
	public boolean down;
	public double speed = 3.0;
	
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	
	private int dir = 0;
	private int dir_Right = 0;
	private int dir_Left = -1;
	
	
	private int frames = 0, maxFrames = 5, index = 0, maxIndex = 10;
	private boolean moved = false;
	
	public Player(int x, int y, int whidth, int height, BufferedImage sprite) {
		super(x, y, whidth, height, sprite);
		
		rightPlayer = new BufferedImage[11];
		leftPlayer = new BufferedImage[11];
		
		for(int i = 0; i < 11; i++) {
			rightPlayer[i] = Main.spriteSheet.getSprite(0 + (i * 65), 0, 65, 65);
		}
		
		for(int i = 0; i < 11; i++) {
			leftPlayer[i] = Main.spriteSheet.getSprite(0 + (i * 65), 65, 65, 65);
		}

	}
	
	public void tick() {
		moved = false;
		if(right) {
			moved = true;
			x+=speed;
			dir = dir_Right;
		}
		else if(left) {
			moved = true;
			x-=speed;
			dir = dir_Left;
		}
		if(up) {
			moved = true;
			y-=speed;
		}
		else if(down) {
			moved = true;
			y+=speed;
		}
		
		if(moved) {
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
					index = 0;
				}
			}
		}
	}

	public void render(Graphics g) {
		if(dir == dir_Right) {
			g.drawImage(rightPlayer[index], this.getX(), this.getY(), null);
		}
		else if(dir == dir_Left) {
			g.drawImage(leftPlayer[index], this.getX(), this.getY(), null);
		}
		
	}
	

}
