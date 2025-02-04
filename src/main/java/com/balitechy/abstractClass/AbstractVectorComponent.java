package com.balitechy.abstractClass;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public abstract class AbstractVectorComponent {
    
    // Métodos abstractos para definir los colores
    protected abstract Color getPrimaryColor();
    protected abstract Color getSecondaryColor();

    // Método común para renderizar una bala
    public void renderBullet(Graphics g, double x, double y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getPrimaryColor());
        g2d.setStroke(new BasicStroke(3));
        int ix = (int) x;
        int iy = (int) y;
        g2d.drawLine(ix, iy, ix, iy + 21);
    }

    // Método común para renderizar un jugador
    public void renderPlayer(Graphics g, double x, double y) {
        int width = 40;
        int height = 50;

        g.setColor(getPrimaryColor());

        int[] xPoints = {(int) (x + width / 2), (int) x, (int) (x + width)};
        int[] yPoints = {(int) y, (int) (y + height), (int) (y + height)};

        g.fillPolygon(xPoints, yPoints, 3);
        g.setColor(getSecondaryColor());
        g.drawPolygon(xPoints, yPoints, 3);
    }

    // Método común para renderizar el fondo
    public void renderBackground(Graphics g, int width, int height) {
        g.setColor(getPrimaryColor());
        g.fillRect(0, 0, width, height);

        g.setColor(getSecondaryColor());
        int moonDiameter = 100;
        g.drawOval(20, 20, moonDiameter, moonDiameter);
    }
}

