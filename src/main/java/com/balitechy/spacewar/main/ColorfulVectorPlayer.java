package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

import com.balitechy.abstractClass.AbstractVectorComponent;
import com.balitechy.interfaces.playerFactory;

public class ColorfulVectorPlayer extends AbstractVectorComponent implements playerFactory {

    private double x, y, velX, velY;
    private Game game;
    public static final int WIDTH = 40, HEIGHT = 50;

    public ColorfulVectorPlayer(double x, double y, Game game) {
        this.x = x;
        this.y = y;
        this.game = game;
    }

    @Override
    public double getX() { return x; }

    @Override
    public void setX(double x) { this.x = x; }

    @Override
    public double getY() { return y; }

    @Override
    public void setY(double y) { this.y = y; }

    @Override
    public void setVelX(double velX) { this.velX = velX; }

    @Override
    public void setVelY(double velY) { this.velY = velY; }

    @Override
    public void shoot() {
        ColorfulVectorBullet b = new ColorfulVectorBullet(x + WIDTH / 2, y - 21, game);
        game.getBullets().addBullet(b);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (x <= 0) x = 0;
        if (x >= (Game.WIDTH * Game.SCALE) - WIDTH) x = (Game.WIDTH * Game.SCALE) - WIDTH;
        if (y <= 0) y = 0;
        if (y >= (Game.HEIGHT * Game.SCALE) - HEIGHT) y = (Game.HEIGHT * Game.SCALE) - HEIGHT;
    }

    @Override
    public void render(Graphics g) {
        renderPlayer(g, x, y);
    }

    @Override
    protected Color getPrimaryColor() {
        return Color.RED; // Nave roja
    }

    @Override
    protected Color getSecondaryColor() {
        return Color.BLACK;
    }
}

