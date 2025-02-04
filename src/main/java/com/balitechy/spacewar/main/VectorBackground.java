package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import com.balitechy.interfaces.backgroundFactory;

public class VectorBackground implements backgroundFactory {
    @Override
    public void render(Graphics g, Canvas c) {
        // Fondo blanco
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        
        // Dibujar un círculo como la luna
        g.setColor(Color.BLACK);
        int moonDiameter = 100; // Tamaño del círculo
        int moonX = 20; // Posición en X
        int moonY = 20; // Posición en Y
        g.drawOval(moonX, moonY, moonDiameter, moonDiameter);
    }
}
