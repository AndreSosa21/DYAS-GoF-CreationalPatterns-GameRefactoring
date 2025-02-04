package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

import com.balitechy.abstractClass.AbstractVectorComponent;
import com.balitechy.interfaces.bulletFactory;

public class ColorfulVectorBullet extends AbstractVectorComponent implements bulletFactory {

    private double x, y;
    private Game game;

    public ColorfulVectorBullet(double x, double y, Game game) {
        this.x = x;
        this.y = y;
        this.game = game;
    }

    @Override
    public void tick() {
        y -= 5;
    }

    @Override
    public void render(Graphics g) {
        renderBullet(g, x, y);
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    protected Color getPrimaryColor() {
        return Color.YELLOW; // Balas amarillas
    }

    @Override
    protected Color getSecondaryColor() {
        return Color.ORANGE;
    }
}
