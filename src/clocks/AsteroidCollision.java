package clocks;

import actions.Collision;
import characters.Asteroid;
import characters.Player;

public class AsteroidCollision {

    public static void collide(){

        try{
            for (int i = 0; i < AsteroidCreation.asteroids.size(); i ++){
                for (int j = 0; j < BulletCreation.bullets.size(); j++){
                    if(Collision.collisionBulletAsteroid(BulletCreation.bullets.get(j), AsteroidCreation.asteroids.get(i))){
                        AsteroidCreation.asteroids.get(i).setHit(true);
                        BulletCreation.bullets.remove(j);
                        AsteroidCreation.asteroids.get(i).setCurrentHealth(AsteroidCreation.asteroids.get(i).getCurrentHealth() - 25);
                    if(AsteroidCreation.asteroids.get(i).getCurrentHealth()< 0){
                        if(AsteroidCreation.asteroids.get(i).containsIridium()){
                            if(Player.iridium < 9999999999999L){
                                Player.iridium += AsteroidCreation.asteroids.get(i).getValue();
                            }else {
                                Player.iridium = 9999999999999L;
                            }
                        }
                        AsteroidCreation.asteroids.remove(i);
                    }
                    }
                }
            }

        }catch (Exception e){
            System.out.println("Asteroid collision error");
        }

        try{
            for(int i = 0; i < AsteroidCreation.asteroids.size(); i++){
                if(Collision.collisionPlayerAsteroid(AsteroidCreation.asteroids.get(i))){
                    Player.isHit = true;
                    PlayerHit.start();
                    AsteroidCreation.asteroids.remove(i);
                    Player.decrementHealth();
                }
            }
        }catch (Exception e){
            System.out.println("Player hit error");
        }
    }
}
