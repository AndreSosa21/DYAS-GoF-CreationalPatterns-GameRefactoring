package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import com.balitechy.interfaces.bulletFactory;

public class VectorBullet implements bulletFactory {
    
    private double x;
    private double y;
    private Game game;
    public static final int HEIGHT = 21; // Altura de la línea
    
    public VectorBullet(double x, double y, Game game) {
        this.x = x;
        this.y = y;
        this.game = game;
    }
    
    @Override
    public void tick() {
        y -= 5;  // Movimiento hacia arriba
    }
    
    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; // Convertimos Graphics a Graphics2D para usar Stroke
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3)); // Grosor de la línea (ajústalo según prefieras)

        int ix = (int) x;
        int iy = (int) y;

        // Dibujar una línea vertical como bala
        g2d.drawLine(ix, iy, ix, iy + HEIGHT);
    }
    
    @Override
    public double getY() {
        return y;
    }
}