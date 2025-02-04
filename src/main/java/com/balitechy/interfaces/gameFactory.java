package com.balitechy.interfaces;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.main.BulletController;

public interface gameFactory {
    
    backgroundFactory crearBackgroundFactory();
    BulletController crearBulletFactory(Game game); 
    playerFactory crearPlayerFactory (Game game);
   
}
