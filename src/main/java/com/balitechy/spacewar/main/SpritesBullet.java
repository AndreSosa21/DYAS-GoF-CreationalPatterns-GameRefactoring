package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.balitechy.interfaces.bulletFactory;



public class SpritesBullet implements bulletFactory {
	
	private double x;
	private double y;
	private Game game;
	public static final int WIDTH = 11;
	public static final int HEIGHT = 21;
	private BufferedImage image;
	
	public SpritesBullet(double x, double y, Game game){
		this.x = x;
		this.y = y;
		this.game = game;

		image = game.getSprites().getImage(35, 52, WIDTH, HEIGHT);
	}
	@Override
	public void tick(){
		y -= 5;
	}
	@Override
	public void render(Graphics g){
		g.drawImage(image, (int) x, (int) y, null);
	}
	@Override
	public double getY(){
		return y;
	}
}
