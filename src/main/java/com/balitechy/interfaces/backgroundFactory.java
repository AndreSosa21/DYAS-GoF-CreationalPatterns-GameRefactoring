package com.balitechy.interfaces;
import java.awt.Canvas;
import java.awt.Graphics;
import java.io.IOException;

public interface backgroundFactory {
    void render(Graphics g, Canvas c) throws IOException;
}
