package com.balitechy.interfaces;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.main.SpritesBackgroundRenderer;
import com.balitechy.spacewar.main.SpritesBullet;
import com.balitechy.spacewar.main.BulletController;
import com.balitechy.spacewar.main.SpritesPlayer;

public class SpritesFactory implements gameFactory{

    @Override
    public backgroundFactory crearBackgroundFactory() {
        return new SpritesBackgroundRenderer();
    }

    @Override
    public BulletController crearBulletFactory(Game game) {
         return new BulletController(); 
    }

    @Override
    public SpritesPlayer crearPlayerFactory(Game game) { // Cambia el método para recibir Game
        return new SpritesPlayer(0, 0, game); // Pasa la referencia de Game
    }
    
}
