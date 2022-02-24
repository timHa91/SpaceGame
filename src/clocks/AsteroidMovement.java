package clocks;

import characters.Asteroid;
import gui.Gui;

public class AsteroidMovement {

    public static void asteroidMove(){
        for(int i = 0; i <AsteroidCreation.asteroids.size(); i++){
            AsteroidCreation.asteroids.get(i).setY(AsteroidCreation.asteroids.get(i).getY()+ AsteroidCreation.asteroids.get(i).getAsteroidSpeed());

            if(AsteroidCreation.asteroids.get(i).getY() > Gui.GAME_HEIGHT){
                AsteroidCreation.asteroids.remove(i);
            }

        }
    }
}
