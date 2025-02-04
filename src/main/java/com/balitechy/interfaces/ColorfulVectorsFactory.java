package com.balitechy.interfaces;

import com.balitechy.spacewar.main.BulletController;
import com.balitechy.spacewar.main.ColorfulVectorBackground;
import com.balitechy.spacewar.main.ColorfulVectorBullet;
import com.balitechy.spacewar.main.ColorfulVectorPlayer;
import com.balitechy.spacewar.main.Game;

public class ColorfulVectorsFactory implements gameFactory {

    @Override
    public backgroundFactory crearBackgroundFactory() {
        return new ColorfulVectorBackground();
    }

    @Override
    public BulletController crearBulletFactory(Game game) {
        return new BulletController(); 
    }

    @Override
    public playerFactory crearPlayerFactory(Game game) {
        return new ColorfulVectorPlayer(100, 300, game);
    }
}
