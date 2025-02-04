package com.balitechy.interfaces;
import java.awt.Graphics;

public interface playerFactory {
 double getX();
 double getY();

 void setX(double x);
 void setY(double y);

 void setVelX(double velX);
 void setVelY(double velY);
 
 void shoot();
 void tick();
 void render(Graphics g);

    
} 
