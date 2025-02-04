package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Canvas;
import java.awt.Graphics;

import com.balitechy.abstractClass.AbstractVectorComponent;
import com.balitechy.interfaces.backgroundFactory;

public class ColorfulVectorBackground extends AbstractVectorComponent implements backgroundFactory {
    
    @Override
    public void render(Graphics g, Canvas c) {
        renderBackground(g, c.getWidth(), c.getHeight());
    }

    @Override
    protected Color getPrimaryColor() {
        return Color.BLUE; // Fondo azul
    }

    @Override
    protected Color getSecondaryColor() {
        return Color.WHITE; // Luna blanca
    }
}

