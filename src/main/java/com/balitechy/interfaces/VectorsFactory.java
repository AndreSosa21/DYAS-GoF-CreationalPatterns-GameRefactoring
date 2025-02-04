package com.balitechy.interfaces;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.main.SpritesBackgroundRenderer;
import com.balitechy.spacewar.main.SpritesPlayer;
import com.balitechy.spacewar.main.VectorBackground;
import com.balitechy.spacewar.main.VectorsPlayer;
import com.balitechy.spacewar.main.BulletController;

public class VectorsFactory implements gameFactory {

    @Override
    public backgroundFactory crearBackgroundFactory() {
        
        return new VectorBackground();
    }

    @Override
    public BulletController crearBulletFactory(Game game) {
        return new BulletController(); 
    }

    @Override
    public playerFactory crearPlayerFactory(Game game) {
        return new VectorsPlayer(0, 0, game);
    }
    
}
