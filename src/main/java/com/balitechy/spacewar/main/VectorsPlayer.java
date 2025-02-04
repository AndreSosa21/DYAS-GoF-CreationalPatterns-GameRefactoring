package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;
import com.balitechy.interfaces.playerFactory;

public class VectorsPlayer implements playerFactory {

    private double x;
    private double y;
    
    private double velX;
    private double velY;
    
    public static final int WIDTH = 40;  // Se ajusta para un mejor aspecto
    public static final int HEIGHT = 50; // Se ajusta para que el triángulo sea más estilizado
    
    private Game game;
    
    public VectorsPlayer(double x, double y, Game game) {
        this.x = x;
        this.y = y;
        this.game = game;
    }
    
    @Override
    public double getX() {
        return x;
    }
    
    @Override
    public void setX(double x) {
        this.x = x;
    }
    
    @Override
    public double getY() {
        return y;
    }
    
    @Override
    public void setY(double y) {
        this.y = y;
    }
    
    @Override
    public void setVelX(double velX) {
        this.velX = velX;
    }
    
    @Override
    public void setVelY(double velY) {
        this.velY = velY;
    }
    
    @Override
    public void shoot() {
        VectorBullet b = new VectorBullet(x + WIDTH / 2, y - VectorBullet.HEIGHT, game);
        game.getBullets().addBullet(b);
    }
    
    @Override
    public void tick() {
        x += velX;
        y += velY;
        
        // Evitar que la nave salga del área de juego
        if (x <= 0)
            x = 0;
        if (x >= (Game.WIDTH * Game.SCALE) - WIDTH)
            x = (Game.WIDTH * Game.SCALE) - WIDTH;
        if (y <= 0)
            y = 0;
        if (y >= (Game.HEIGHT * Game.SCALE) - HEIGHT)
            y = (Game.HEIGHT * Game.SCALE) - HEIGHT;
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        
        // Definir los puntos del triángulo
        int[] xPoints = {
            (int) (x + WIDTH / 2), // Punto superior (punta del triángulo)
            (int) (x),             // Esquina inferior izquierda
            (int) (x + WIDTH)      // Esquina inferior derecha
        };
        
        int[] yPoints = {
            (int) (y),           // Punta arriba
            (int) (y + HEIGHT),  // Base izquierda
            (int) (y + HEIGHT)   // Base derecha
        };
        
        g.fillPolygon(xPoints, yPoints, 3);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 3);
    }
}